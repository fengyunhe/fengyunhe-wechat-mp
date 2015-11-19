package com.fengyunhe.wechat.mp.pay.bean;

import java.util.List;

/**
 * 新增投诉
 *
 * @author Administrator
 */
public class Complaint {

    private String OpenId;
    private String AppId;
    private Integer TimeStamp;
    /**
     * 必填 通知类型 request 用户提交投诉 confirm 用户确认消除 投诉 reject 用户拒绝消除投诉
     */
    private String MsgType;

    /**
     * 投诉单号
     */
    private String FeedBackId;
    /**
     * 交易订单号
     */
    private String TransId;

    // 投诉原因
    private String Reason;
    // 用户希望解决方案
    private String Solution;

    // 备注信息+电话
    private String ExtInfo;

    /**
     * 必填 ，签名；字段来源：对前面的其他字段不 appKey 按照字典序排序后，使用 SHA1 算法得到的结果。由商户 生成后传入。
     */
    private String AppSignature;
    /**
     * sha1
     */
    private String SignMethod;
    // 用户上传的图片凭证 最多5张
    private List<PicInfo> PicInfo;

    public static class PicInfo {

        private PicUrl item;

        public PicInfo(PicUrl item) {
            super();
            this.item = item;
        }

        public PicUrl getItem() {
            return item;
        }

        public void setItem(PicUrl item) {
            this.item = item;
        }
    }

    public static class PicUrl {
        private String PicUrl;

        public String getPicUrl() {
            return PicUrl;
        }

        public void setPicUrl(String picUrl) {
            PicUrl = picUrl;
        }

        public PicUrl(String picUrl) {
            super();
            PicUrl = picUrl;
        }

    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public Integer getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getFeedBackId() {
        return FeedBackId;
    }

    public void setFeedBackId(String feedBackId) {
        FeedBackId = feedBackId;
    }

    public String getTransId() {
        return TransId;
    }

    public void setTransId(String transId) {
        TransId = transId;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getSolution() {
        return Solution;
    }

    public void setSolution(String solution) {
        Solution = solution;
    }

    public String getExtInfo() {
        return ExtInfo;
    }

    public void setExtInfo(String extInfo) {
        ExtInfo = extInfo;
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

    public List<PicInfo> getPicInfo() {
        return PicInfo;
    }

    public void setPicInfo(List<PicInfo> picInfo) {
        PicInfo = picInfo;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }


}
