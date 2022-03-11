package priv.psq.designpatterns.converter;

/**
 * PersonVO.java
 * Description: VO对象
 *
 * @author Peng Shiquan
 * @date 2022/3/11
 */
public class PersonVO extends BaseVO {
    private String site;
    private String beginDT;
    private String endDT;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getBeginDT() {
        return beginDT;
    }

    public void setBeginDT(String beginDT) {
        this.beginDT = beginDT;
    }

    public String getEndDT() {
        return endDT;
    }

    public void setEndDT(String endDT) {
        this.endDT = endDT;
    }
}
