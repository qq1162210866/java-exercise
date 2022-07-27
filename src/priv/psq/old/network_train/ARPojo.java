package priv.psq.old.network_train;

import java.util.List;

/**
 * ARPojo.java
 * Description: 气象站的实体类
 *
 * @author Peng Shiquan
 * @date 2020/6/17
 */
public class ARPojo {

    /**
     * 基础信息，固定长度字段
     */
    private String stationNum;
    private String serviceNum;
    private String sensor;
    private String deviceID;
    private String time;
    private String frame;
    private Integer observationNum;
    private Integer statusNum;

    /**
     * 气象单元集合
     */
    private List<MeteorologicalUnit> meteorologicalUnitList;

    public String getStationNum() {
        return stationNum;
    }

    public void setStationNum(String stationNum) {
        this.stationNum = stationNum;
    }

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public Integer getObservationNum() {
        return observationNum;
    }

    public void setObservationNum(Integer observationNum) {
        this.observationNum = observationNum;
    }

    public Integer getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(Integer statusNum) {
        this.statusNum = statusNum;
    }

    public List<MeteorologicalUnit> getMeteorologicalUnitList() {
        return meteorologicalUnitList;
    }

    public void setMeteorologicalUnitList(List<MeteorologicalUnit> meteorologicalUnitList) {
        this.meteorologicalUnitList = meteorologicalUnitList;
    }

    @Override
    public String toString() {
        return "ARPojo{" +
                "stationNum='" + stationNum + '\'' +
                ", serviceNum='" + serviceNum + '\'' +
                ", sensor='" + sensor + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", time='" + time + '\'' +
                ", frame='" + frame + '\'' +
                ", observationNum=" + observationNum +
                ", statusNum=" + statusNum +
                ", meteorologicalUnitList=" + meteorologicalUnitList +
                '}';
    }
}
