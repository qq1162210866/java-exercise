package priv.psq.old.network_train;

/**
 * MeteorologicalUnit.java
 * Description:  气象单元
 *
 * @author Peng Shiquan
 * @date 2020/6/17
 */
public class MeteorologicalUnit {

    /**
     * 气象参数Code
     */
    private String ElementCode;
    /**
     * 气象参数名称
     */
    private String ElementName;
    /**
     * 气象参数值
     */
    private String ElementValue;
    /**
     * 气象参数单位
     */
    private String ElementUnit;

    public String getElementCode() {
        return ElementCode;
    }

    public void setElementCode(String elementCode) {
        ElementCode = elementCode;
    }

    public String getElementName() {
        return ElementName;
    }

    public void setElementName(String elementName) {
        ElementName = elementName;
    }

    public String getElementValue() {
        return ElementValue;
    }

    public void setElementValue(String elementValue) {
        ElementValue = elementValue;
    }

    public String getElementUnit() {
        return ElementUnit;
    }

    public void setElementUnit(String elementUnit) {
        ElementUnit = elementUnit;
    }

    @Override
    public String toString() {
        return "MeteorologicalUnit{" +
                "ElementCode='" + ElementCode + '\'' +
                ", ElementName='" + ElementName + '\'' +
                ", ElementValue='" + ElementValue + '\'' +
                ", ElementUnit='" + ElementUnit + '\'' +
                '}';
    }
}
