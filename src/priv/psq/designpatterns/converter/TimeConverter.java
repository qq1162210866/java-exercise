package priv.psq.designpatterns.converter;

/**
 * TimeConverter.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/3/11
 */
public class TimeConverter extends BaseConverter<PersonVO, PersonDTO> {

    public TimeConverter() {
        super(FunctionUtil.TIME_FUNCTION);
    }

    public static void main(String[] args) {
        TimeConverter timeConverter = new TimeConverter();
        timeConverter.test();
    }

    public void test() {
        PersonVO personVO = new PersonVO();
        personVO.setSite("OFFLINE");
        personVO.setBeginDT("20220309");
        personVO.setEndDT("20220311");
        personVO.setCode("01");
        personVO.setName("测试");
        PersonDTO personDTO = this.converterFromDto(personVO);
        System.err.println(personDTO.toString());
    }


}

