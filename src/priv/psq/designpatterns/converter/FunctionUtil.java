package priv.psq.designpatterns.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

/**
 * FunctionUtil.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/3/11
 */
public class FunctionUtil {

    /**
     * 时间转换器
     */
    static Function<PersonVO, PersonDTO> TIME_FUNCTION = new Function<PersonVO, PersonDTO>() {
        @Override
        public PersonDTO apply(PersonVO personVO) {
            PersonDTO result = new PersonDTO();
            TimeData timeData = new TimeData(personVO.getBeginDT(), personVO.getEndDT());
            result.setBeginTime(timeData.getBegin());
            result.setEndTime(timeData.getEnd());
            result.setLastBeginTime(timeData.getLbt());
            result.setLastEndTime(timeData.getLet());
            result.setLastYearBeginTime(timeData.getLybt());
            result.setLastYearEndTime(timeData.getLyet());
            //放置code
            result.setCode(personVO.getCode());
            result.setName(personVO.getName());
            result.setSite(changeTradeType(personVO.getSite()));
            return result;
        }
    };

    /**
     * Description: 将前端传递对交易类型转换为数据库查询条件，没有或者对应不上都返回"线上"
     *
     * @param voTradeType 前端传递对交易类型为（ONLINE,OFFLINE,ALL）
     * @return java.lang.String 返回的交易类型为（线上，线下，全部）
     * @author Peng Shiquan
     * @date 2022-01-27
     */
    private static String changeTradeType(String voTradeType) {
        if (voTradeType.isEmpty()) return "线上";
        switch (voTradeType) {
            case "OFFLINE":
                return "线下";
            case "ALL":
                return "全部";
            case "ONLINE":
            default:
                return "线上";
        }
    }
}

class TimeData {
    private String begin;
    private String end;
    private String lbt;
    private String let;
    private String lybt;
    private String lyet;

    public TimeData(String begin, String end) {
        //转换时间
        DateTimeFormatter dfData = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate beginD, endD;
        try {
            beginD = LocalDate.parse(begin, dfData);
            endD = LocalDate.parse(end, dfData);
        } catch (Exception e) {
            //默认取昨天的日期
            beginD = LocalDate.now().plusDays(-1L);
            endD = LocalDate.now().plusDays(-1L);
        }
        this.setBegin(beginD.format(dfData));
        this.setEnd(endD.format(dfData));
        long diff = endD.until(beginD, ChronoUnit.DAYS);
        String let = beginD.plusDays(-1L).format(dfData);
        String lbt = beginD.plusDays(-1 + diff).format(dfData);
        String lybt = beginD.plusYears(-1L).format(dfData);
        String lyet = endD.plusYears(-1L).format(dfData);
        this.setLbt(lbt);
        this.setLet(let);
        this.setLybt(lybt);
        this.setLyet(lyet);
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getLbt() {
        return lbt;
    }

    public void setLbt(String lbt) {
        this.lbt = lbt;
    }

    public String getLet() {
        return let;
    }

    public void setLet(String let) {
        this.let = let;
    }

    public String getLybt() {
        return lybt;
    }

    public void setLybt(String lybt) {
        this.lybt = lybt;
    }

    public String getLyet() {
        return lyet;
    }

    public void setLyet(String lyet) {
        this.lyet = lyet;
    }
}
