package priv.psq.designpatterns.converter;

/**
 * PersonDTO.java
 * Description: DTO
 *
 * @author Peng Shiquan
 * @date 2022/3/11
 */
public class PersonDTO extends BaseDTO {
    private String site;
    private String beginTime;
    private String endTime;
    private String lastBeginTime;
    private String lastEndTime;
    private String lastYearBeginTime;
    private String lastYearEndTime;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLastBeginTime() {
        return lastBeginTime;
    }

    public void setLastBeginTime(String lastBeginTime) {
        this.lastBeginTime = lastBeginTime;
    }

    public String getLastEndTime() {
        return lastEndTime;
    }

    public void setLastEndTime(String lastEndTime) {
        this.lastEndTime = lastEndTime;
    }

    public String getLastYearBeginTime() {
        return lastYearBeginTime;
    }

    public void setLastYearBeginTime(String lastYearBeginTime) {
        this.lastYearBeginTime = lastYearBeginTime;
    }

    public String getLastYearEndTime() {
        return lastYearEndTime;
    }

    public void setLastYearEndTime(String lastYearEndTime) {
        this.lastYearEndTime = lastYearEndTime;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                ", code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                "site='" + site + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", lastBeginTime='" + lastBeginTime + '\'' +
                ", lastEndTime='" + lastEndTime + '\'' +
                ", lastYearBeginTime='" + lastYearBeginTime + '\'' +
                ", lastYearEndTime='" + lastYearEndTime + '\'' +
                '}';
    }
}
