package com.fengyunhe.wechat.mp.req.event;

/**
 * POI 门店审核通知事件
 * Created by yangyan on 2015/6/2.
 */
public class PoiCheckNotifyEvent extends AbstractEventMessage {


    /**
     * 商户自己内部 ID，即字段中的 sid
     */
    private String UniqId;

    /**
     * 微信的门店 ID，微信内门店唯一标示 ID
     */
    private String PoiId;
    /**
     * 审核结果，成功 succ 或失败 fail
     */
    private String Result;
    /**
     * 成功的通知信息，或审核失败的驳回理由
     */
    private String Msg;


//    <xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>1408622107</CreateTime>
//    <MsgType><![CDATA[event]]></MsgType>
//    <Event><![CDATA[poi_check_notify]]></Event>
//    <UniqId><![CDATA[123adb]]></UniqId>
//    <PoiId><![CDATA[123123]]></PoiId>
//    <Result><![CDATA[fail]]></Result>
//    <Msg><![CDATA[xxxxxx]]></Msg>
//    </xml>


    public String getUniqId() {
        return UniqId;
    }

    public void setUniqId(String uniqId) {
        UniqId = uniqId;
    }

    public String getPoiId() {
        return PoiId;
    }

    public void setPoiId(String poiId) {
        PoiId = poiId;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
