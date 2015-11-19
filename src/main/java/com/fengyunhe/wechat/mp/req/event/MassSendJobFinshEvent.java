package com.fengyunhe.wechat.mp.req.event;

/**
 * 功能：事件推送群发结果
 * 作者： yangyan
 * 时间： 2014/8/16 .
 * <p/>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody><tr>
 * <th style="width:120px">参数
 * </th>
 * <th>说明
 * </th></tr>
 * <tr>
 * <td> ToUserName
 * </td>
 * <td> 公众号的微信号
 * </td></tr>
 * <tr>
 * <td> FromUserName
 * </td>
 * <td> 公众号群发助手的微信号，为mphelper
 * </td></tr>
 * <tr>
 * <td> CreateTime
 * </td>
 * <td> 创建时间的时间戳
 * </td></tr>
 * <tr>
 * <td> MsgType
 * </td>
 * <td> 消息类型，此处为event
 * </td></tr>
 * <tr>
 * <td> Event
 * </td>
 * <td> 事件信息，此处为MASSSENDJOBFINISH
 * </td></tr>
 * <tr>
 * <td> MsgID
 * </td>
 * <td> 群发的消息ID
 * </td></tr>
 * <tr>
 * <td> Status
 * </td>
 * <td> 群发的结构，为“send success”或“send fail”或“err(num)”。但send success时，也有可能因用户拒收公众号的消息、系统错误等原因造成少量用户接收失败。err(num)是审核失败的具体原因，可能的情况如下：
 * <p>err(10001), //涉嫌广告
 * err(20001), //涉嫌政治
 * err(20004), //涉嫌社会
 * err(20002), //涉嫌色情
 * err(20006), //涉嫌违法犯罪
 * err(20008), //涉嫌欺诈
 * err(20013), //涉嫌版权
 * err(22000), //涉嫌互推(互相宣传)
 * err(21000), //涉嫌其他
 * </p>
 * </td></tr>
 * <tr>
 * <td> TotalCount
 * </td>
 * <td> group_id下粉丝数；或者openid_list中的粉丝数
 * </td></tr>
 * <tr>
 * <td> FilterCount
 * </td>
 * <td> 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
 * </td></tr>
 * <tr>
 * <td> SentCount
 * </td>
 * <td> 发送成功的粉丝数
 * </td></tr>
 * <tr>
 * <td> ErrorCount
 * </td>
 * <td> 发送失败的粉丝数
 * </td></tr>
 * </tbody></table>
 */
public class MassSendJobFinshEvent extends AbstractEventMessage {
    public MassSendJobFinshEvent() {

    }


    //    <xml>
//    <ToUserName><![CDATA[gh_3e8adccde292]]></ToUserName>
//    <FromUserName><![CDATA[oR5Gjjl_eiZoUpGozMo7dbBJ362A]]></FromUserName>
//    <CreateTime>1394524295</CreateTime>
//    <MsgType><![CDATA[event]]></MsgType>
//    <Event><![CDATA[MASSSENDJOBFINISH]]></Event>
//    <MsgID>1988</MsgID>
//    <Status><![CDATA[sendsuccess]]></Status>
//    <TotalCount>100</TotalCount>
//    <FilterCount>80</FilterCount>
//    <SentCount>75</SentCount>
//    <ErrorCount>5</ErrorCount>
//    </xml>

    private String MsgID;
    private String Status;
    private Integer TotalCount;
    private Integer FilterCount;
    private Integer SentCount;
    private Integer ErrorCount;

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Integer getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        TotalCount = totalCount;
    }

    public Integer getFilterCount() {
        return FilterCount;
    }

    public void setFilterCount(Integer filterCount) {
        FilterCount = filterCount;
    }

    public Integer getSentCount() {
        return SentCount;
    }

    public void setSentCount(Integer sentCount) {
        SentCount = sentCount;
    }

    public Integer getErrorCount() {
        return ErrorCount;
    }

    public void setErrorCount(Integer errorCount) {
        ErrorCount = errorCount;
    }
}
