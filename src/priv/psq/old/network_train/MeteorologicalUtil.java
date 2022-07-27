package priv.psq.old.network_train;

/**
 * meteorologicalUtil.java
 * Description: 气象工具类，存储对应信息和单位
 *
 * @author Peng Shiquan
 * @date 2020/6/17
 */
public class MeteorologicalUtil {
    /**
     * 单位字段
     */
    /**
     * 温度单位
     */
    public static final String TEMPERATURE_UNIT = "℃";
    /**
     * 湿度单位
     */
    public static final String HUMIDITY_UNIT = "%";
    /**
     * 风向单位
     */
    public static final String DIRECTION_UNIT = "°";
    /**
     * 速度单位
     */
    public static final String SPEED_UNIT = "m/s";
    /**
     * 降水量
     */
    public static final String PRECIPITATION_UNIT = "mm/h";
    /**
     * 气压单位
     */
    public static final String PRESSURE_UNIT = "hpa";
    /**
     * 能见度单位
     */
    public static final String METER_UNIT = "m";
    /**
     * 厚度单位
     */
    public static final String MILLIMETER_UNIT = "mm";
    /**
     * 电压单位
     */
    public static final String VOLTAGE_UNIT = "v";
    /**
     * 要素Code含义
     */
    public static final String ABA = "气温";
    public static final String ACA = "相对湿度";
    public static final String AQA = "气压";
    public static final String ADC = "风向";
    public static final String AEC = "风速";
    public static final String AFA = "降水量";
    public static final String AMA = "1分钟能见度";
    public static final String AMB = "10分钟能见度";
    public static final String ANA = "降水天气";
    public static final String APA = "路面温度";
    public static final String APD = "水膜厚度";
    public static final String APE = "冰层厚度";
    public static final String APF = "雪层厚度";
    public static final String APJ = "湿滑系数";
    public static final String APH = "路面状况";

    /**
     * 设备相关字段
     */
    public static final String ZAE = "主采集板电压值";
    public static final String ZGA = "遥感检测仪工作状态";
    public static final String ZFA = "能见度工作状态";

    /**
     * 精度
     */
    public static final Integer TEN_ACCURACY = 10;
    public static final Integer HUNDRED_ACCURACY = 100;


    /**
     * Description: 把数据按精度操作返回
     *
     * @param value
     * @return java.lang.Float
     * @Author: Peng Shiquan
     * @Date: 2020/6/17
     */
    public static Float zoomAccuracy(String value, Integer accuracy) {
        Float result = Float.parseFloat(value);
        result = result / accuracy;
        return result;
    }

    /**
     * Description: 天气现象转换
     *
     * @param value
     * @return java.lang.String
     * @Author: Peng Shiquan
     * @Date: 2020/6/17
     */
    public static String precipitationSwitch(String value) {
        String result = null;
        switch (value) {
            case "R-":
                result = "小雨";
                break;
            case "R":
                result = "中雨";
                break;
            case "R+":
                result = "大雨";
                break;
            case "S-":
                result = "小雪";
                break;
            case "S":
                result = "中雪";
                break;
            case "S+":
                result = "大雪";
                break;
            case "P-":
                result = "小雨夹雪";
                break;
            case "P":
                result = "中雨夹雪";
                break;
            case "P+":
                result = "强雨夹雪";
                break;
            case "F-":
                result = "轻雾";
                break;
            case "F":
                result = "雾";
                break;
            case "F+":
                result = "浓雾";
                break;
            case " C":
                result = "无降水";
                break;
            default:
                result = "未知类型";
                break;
        }
        return result;
    }

    /**
     * Description: 路面状况转换
     *
     * @param value
     * @return java.lang.String
     * @Author: Peng Shiquan
     * @Date: 2020/6/17
     */
    public static String roadConditionSwitch(String value) {
        String result = null;
        switch (value) {
            case "11":
                result = "干燥";
                break;
            case "12":
                result = "潮湿";
                break;
            case "13":
                result = "积水";
                break;
            case "14":
                result = "积雪";
                break;
            case "15":
                result = "结冰";
                break;
            case "16":
                result = "预留";
                break;
            case "18":
                result = "冰水混合物";
                break;
            case "00":
                result = "状况未知";
                break;
            default:
                result = "未知类型";
                break;
        }
        return result;
    }

    /**
     * Description: 遥感检测仪工作状态转换
     *
     * @param value
     * @return java.lang.String
     * @Author: Peng Shiquan
     * @Date: 2020/6/17
     */
    public static String detectorSwitch(String value) {
        String result = null;
        String firstValue = value.substring(0, 1);
        String secondValue = value.substring(1, 2);
        /**
         * 第一个字符判断
         */
        switch (firstValue) {
            case "0":
                result = "接收窗清洁";
                break;
            case "1":
                result = "警告-接收器窗污染";
                break;
            case "2":
                result = "报警-接收器窗污染严重";
                break;
            case "3":
                result = "额外环境光引起数据暂时丢失";
                break;
            default:
                result = "不匹配";
                break;
        }
        switch (secondValue) {
            case "0":
                result = result + ",硬件OK";
                break;
            case "1":
                result = result + ",CPU硬件警告";
                break;
            case "2":
                result = result + ",检测器硬件警告";
                break;
            case "3":
                result = result + ",其它";
                break;
            case "4":
                result = result + ",发射管欠流";
                break;
            case "5":
                result = result + ",发射管过流";
                break;
            case "6":
                result = result + ",发射管超温";
                break;
            case "7":
                result = result + ",发射板通信不正常告警";
                break;
        }
        return result;
    }

    /**
     * Description: 能见度仪工作状态转换
     *
     * @param value
     * @return java.lang.String
     * @Author: Peng Shiquan
     * @Date: 2020/6/17
     */
    public static String visibilitySwitch(String value) {
        String result = null;
        String firstValue = value.substring(0, 1);
        String secondValue = value.substring(1, 2);
        switch (firstValue) {
            case "0":
                result = "能见度值平稳";
                break;
            case "1":
                result = "能见度值下降";
                break;
            case "2":
                result = "能见度值升高";
                break;
            default:
                result = "不匹配";
                break;
        }
        switch (secondValue) {
            case "0":
                result = result + ",正常";
                break;
            case "1":
                result = result + ",电源故障";
                break;
            case "2":
                result = result + ",环境光故障";
                break;
            case "3":
                result = result + ",接收器故障";
                break;
            case "4":
                result = result + ",发生器故障";
                break;
        }
        return result;
    }
}
