package com.fengyunhe.wechat.mp.pay.bean;

/**
 * 告警信息
 *
 * @author Administrator
 */
public class WarningNotify {

    // <xml>
    // <AppId><![CDATA[wxf8b4f85f3a794e77]]></AppId>
    // <ErrorType>1001</ErrorType>
    // <Description><![CDATA[错误描述]]></Description>
    // <AlarmContent><![CDATA[错误详情]]></AlarmContent>
    // <TimeStamp>1393860740</TimeStamp>
    // <AppSignature><![CDATA[f8164781a303f4d5a944a2dfc68411a8c7e4fbea]]></AppSignatur
    // e>
    // <SignMethod><![CDATA[sha1]]></SignMethod>
    // </xml>
    private String AppId;
    /**
     * 1001：发货超时
     */
    private Integer ErrorType;
    private String Description;
    private String AlarmContent;
    private Integer TimeStamp;
    private String AppSignature;
    private String SignMethod;

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public Integer getErrorType() {
        return ErrorType;
    }

    public void setErrorType(Integer errorType) {
        ErrorType = errorType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAlarmContent() {
        return AlarmContent;
    }

    public void setAlarmContent(String alarmContent) {
        AlarmContent = alarmContent;
    }

    public Integer getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getAppSignature() {
        return AppSignature;
    }

    public void setAppSignature(String appSignature) {
        AppSignature = appSignature;
    }

    public String getSignMethod() {
        return SignMethod;
    }

    public void setSignMethod(String signMethod) {
        SignMethod = signMethod;
    }

}
