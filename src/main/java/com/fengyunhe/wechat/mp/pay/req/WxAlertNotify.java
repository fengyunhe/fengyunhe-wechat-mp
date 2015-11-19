package com.fengyunhe.wechat.mp.pay.req;

/**
 * 告警通知
 *
 * @author yangyan
 */
public class WxAlertNotify {

    private String AppId;
    private String ErrorType;
    private String Description;
    private String AlarmContent;
    private Long TimeStamp;
    private String AppSignature;
    private String SignMethod;

    public final String getAppId() {
        return AppId;
    }

    public final void setAppId(String appId) {
        AppId = appId;
    }

    public final String getErrorType() {
        return ErrorType;
    }

    public final void setErrorType(String errorType) {
        ErrorType = errorType;
    }

    public final String getDescription() {
        return Description;
    }

    public final void setDescription(String description) {
        Description = description;
    }

    public final String getAlarmContent() {
        return AlarmContent;
    }

    public final void setAlarmContent(String alarmContent) {
        AlarmContent = alarmContent;
    }

    public final Long getTimeStamp() {
        return TimeStamp;
    }

    public final void setTimeStamp(Long timeStamp) {
        TimeStamp = timeStamp;
    }

    public final String getAppSignature() {
        return AppSignature;
    }

    public final void setAppSignature(String appSignature) {
        AppSignature = appSignature;
    }

    public final String getSignMethod() {
        return SignMethod;
    }

    public final void setSignMethod(String signMethod) {
        SignMethod = signMethod;
    }

}
