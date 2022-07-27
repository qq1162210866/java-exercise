package priv.psq.old.network_train;

import java.util.ArrayList;
import java.util.List;

/**
 * ARSwitch.java
 * Description:  气象站解析
 *
 * @author Peng Shiquan
 * @date 2020/6/17
 */
public class ARSwitch {

    public static ARPojo LineSwitch(String line) {
        ARPojo result = new ARPojo();
        List<MeteorologicalUnit> meteorologicalUnitList = new ArrayList<>();
        String[] values = line.split(",");
        /**
         * 设置基础信息
         */
        result.setStationNum(values[1]);
        result.setServiceNum(values[2]);
        result.setSensor(values[3]);
        result.setDeviceID(values[4]);
        result.setTime(values[5]);
        result.setFrame(values[6]);
        result.setObservationNum(Integer.valueOf(values[7]));
        result.setStatusNum(Integer.valueOf(values[8]));
        /**
         * 设置气象参数
         */
        Integer paramNum = values.length - 2;
        for (int i = 9; i < paramNum - 1; i = i + 2) {
            MeteorologicalUnit meteorologicalUnit = new MeteorologicalUnit();
            Float temFlocat = null;
            meteorologicalUnit.setElementCode(values[i]);
            switch (values[i]) {
                case "ABA":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.ABA);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.TEMPERATURE_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "ACA":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.ACA);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.HUMIDITY_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "AQA":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.AQA);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.PRESSURE_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "ADC":
                    meteorologicalUnit.setElementName(MeteorologicalUtil.ADC);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.DIRECTION_UNIT);
                    meteorologicalUnit.setElementValue(values[i + 1]);
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "AEC":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.AEC);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.SPEED_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "AFA":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.AFA);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.PRECIPITATION_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "AMA":
                    meteorologicalUnit.setElementName(MeteorologicalUtil.AMA);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.METER_UNIT);
                    meteorologicalUnit.setElementValue(values[i + 1]);
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "AMB":
                    meteorologicalUnit.setElementName(MeteorologicalUtil.AMB);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.METER_UNIT);
                    meteorologicalUnit.setElementValue(values[i + 1]);
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "ANA":
                    meteorologicalUnit.setElementName(MeteorologicalUtil.ANA);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.precipitationSwitch(values[i + 1]));
                    meteorologicalUnit.setElementValue(values[i + 1]);
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "APA":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.APA);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.TEMPERATURE_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "APD":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.APD);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.MILLIMETER_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "APE":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.APE);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.MILLIMETER_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "APF":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.APF);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.MILLIMETER_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "APJ":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.HUNDRED_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.APJ);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "APH":
                    meteorologicalUnit.setElementName(MeteorologicalUtil.APH);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.roadConditionSwitch(values[i + 1]));
                    meteorologicalUnit.setElementValue(values[i + 1]);
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "ZAE":
                    temFlocat = MeteorologicalUtil.zoomAccuracy(values[i + 1], MeteorologicalUtil.TEN_ACCURACY);
                    meteorologicalUnit.setElementName(MeteorologicalUtil.ZAE);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.VOLTAGE_UNIT);
                    meteorologicalUnit.setElementValue(temFlocat.toString());
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "ZGA":
                    meteorologicalUnit.setElementName(MeteorologicalUtil.ZGA);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.detectorSwitch(values[i + 1]));
                    meteorologicalUnit.setElementValue(values[i + 1]);
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                case "ZFA":
                    meteorologicalUnit.setElementName(MeteorologicalUtil.ZFA);
                    meteorologicalUnit.setElementUnit(MeteorologicalUtil.visibilitySwitch(values[i + 1]));
                    meteorologicalUnit.setElementValue(values[i + 1]);
                    meteorologicalUnitList.add(meteorologicalUnit);
                    break;
                default:
                    break;
            }
        }
        result.setMeteorologicalUnitList(meteorologicalUnitList);
        return result;
    }
}
