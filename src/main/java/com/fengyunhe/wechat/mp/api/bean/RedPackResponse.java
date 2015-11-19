package com.fengyunhe.wechat.mp.api.bean;

/**
 * 发送红包响应
 * Created by yangyan on 2015/6/17.
 */
public class RedPackResponse {
//        <xml>
//<return_code><![CDATA[SUCCESS]]></return_code>
//<return_msg><![CDATA[发放成功.]]></return_msg>
//<result_code><![CDATA[SUCCESS]]></result_code>
//<err_code><![CDATA[0]]></err_code>
//<err_code_des><![CDATA[发放成功.]]></err_code_des>
//<mch_billno><![CDATA[0010010404201411170000046545]]></mch_billno>
//<mch_id>10010404</mch_id>
//<wxappid><![CDATA[wx6fa7e3bab7e15415]]></wxappid>
//<re_openid><![CDATA[onqOjjmM1tad-3ROpncN-yUfa6uI]]></re_openid>
//<total_amount>1</total_amount>
//<send_listid>100000000020150520314766074200</send_listid>
//<send_time>20150520102602</send_time>
//</xml>

    private String return_code;
    private String return_msg;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String mch_billno;
    private Integer mch_id;
    private String wxappid;
    private String re_openid;
    private Integer total_amount;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public Integer getMch_id() {
        return mch_id;
    }

    public void setMch_id(Integer mch_id) {
        this.mch_id = mch_id;
    }

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getRe_openid() {
        return re_openid;
    }

    public void setRe_openid(String re_openid) {
        this.re_openid = re_openid;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }
}
