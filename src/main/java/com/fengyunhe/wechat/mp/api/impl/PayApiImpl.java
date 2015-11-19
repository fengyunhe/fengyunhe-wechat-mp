package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.PayApi;
import com.fengyunhe.wechat.mp.api.bean.GroupRedpack;
import com.fengyunhe.wechat.mp.api.bean.RedPack;
import com.fengyunhe.wechat.mp.api.bean.RedPackResponse;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.MessageUtil;
import com.fengyunhe.wechat.mp.api.util.Tools;
import com.fengyunhe.wechat.mp.pay.util.MD5SignUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class PayApiImpl implements PayApi {

    Log log = LogFactory.getLog(PayApiImpl.class);
    //    带有微信支付证书的http请求使用这个来操作
    HttpClientHelper httpClientHelper = null;
    private WeChatApp app;

    public PayApiImpl(WeChatApp app) {
        this.app = app;
        if (app.getCertPath() != null && app.getCertPassword() != null) {
            httpClientHelper = new HttpClientHelper("PKCS12", app.getCertPath(), app.getCertPassword());
        }
    }

//    @Override
//    public boolean sendDeliverNotify(String accessToken,
//                                     DeliverNotify deliverNotify) {
//
//
////        TODO 新版中此接口被取消了
//        String url = "https://api.weixin.qq.com/pay/delivernotify?access_token="
//                + accessToken;
//        TreeMap<String, String> json = new TreeMap<String, String>();
//        json.put("appid", deliverNotify.getAppid());
//        json.put("openid", deliverNotify.getOpenid());
//        json.put("transid", deliverNotify.getTransid());
//        json.put("out_trade_no", deliverNotify.getOut_trade_no());
//        json.put("deliver_timestamp", deliverNotify.getDeliver_timestamp());
//        json.put("deliver_status", deliverNotify.getDeliver_status());
//        json.put("deliver_msg", deliverNotify.getDeliver_msg());
//        try {
//            json.put("app_signature", wxPayHelper.GetBizSign(json));
//        } catch (SDKRuntimeException e1) {
//            e1.printStackTrace();
//        }
//        json.put("sign_method", "sha1");
//        String result = null;
//        try {
//            result = HttpClientPool.post(url, JsonObjectUtils.beanToJson(json));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        log.debug("微信发货通知返回：" + result);
//        Map<String, Object> map = JsonObjectUtils.jsonToBean(result,
//                Map.class);
//        return "0".equals(map.get("errcode").toString());
//
//    }
//
//    @Override
//    public WxOrderInfo orderQuery(String accessToken, String packageString,
//                                  String timestamp, String app_signature) {
//        String url = "https://api.weixin.qq.com/pay/orderquery?access_token="
//                + accessToken;
//        TreeMap<String, String> json = new TreeMap<String, String>();
//        json.put("appid", app.getAppId());
//        try {
//            json.put("package", wxPayHelper.GetCftPackage());
//        } catch (SDKRuntimeException e2) {
//            e2.printStackTrace();
//        }
//        json.put("timestamp", CommonUtil.CreateNoncestr());
//        try {
//            json.put("app_signature", wxPayHelper.GetBizSign(json));
//        } catch (SDKRuntimeException e1) {
//            e1.printStackTrace();
//        }
//        json.put("sign_method", "sha1");
//        String result = HttpKit.post(url, JsonObjectUtils.beanToJson(json));
//        log.debug("查询订单处理返回：" + result);
//        Map<String, Object> map = JsonObjectUtils.jsonToBean(result,
//                Map.class);
//        if ("0".equals(map.get("errcode"))) { // 结果正常返回
//            return JsonObjectUtils.jsonToBean(map.get("order_info")
//                    .toString(), WxOrderInfo.class);
//        }
//
//        return null;
//    }
//
//    @Override
//    public boolean updateFeedback(String accessToken, String openId,
//                                  String feedbackId) {
//        String url = "https://api.weixin.qq.com/payfeedback/update?access_token="
//                + accessToken
//                + "&openid="
//                + openId
//                + "&feedbackid="
//                + feedbackId;
//        String post = HttpKit.get(url);
//        log.debug("通知维权处理返回：" + post);
//        if (JsonObjectUtils.stringToJsonNode(post).get("errcode")
//                .getIntValue() == 0) {
//            return true;
//        }
//
//        return false;
//    }

//    @Override
//    public RefundRequestResult refund(String outTradeNo, String outRefundNo,
//                                      Integer totalFee, Integer refundFee, Integer op_user_id,
//                                      String op_user_passwd) {
//        HashMap<String, String> params = new HashMap<String, String>();
//        params.put("partner", this.wxPayHelper.getPartnerId());
//        params.put("input_charset", "UTF-8");
//        params.put("out_trade_no", outTradeNo);
//        params.put("out_refund_no", outRefundNo);
//        params.put("total_fee", totalFee.toString());
//        params.put("refund_fee", refundFee.toString());
//        params.put("op_user_id", String.valueOf(op_user_id));
//        params.put("op_user_passwd", op_user_passwd);
//        String unSignParaString;
//        unSignParaString = CommonUtil.transMap2QueryString(params, false);
//        String sign = MD5SignUtil.sign(unSignParaString,
//                this.wxPayHelper.getPartnerKey());
//        params.put("sign", sign);
//        String url = "https://mch.tenpay.com/refundapi/gateway/refund.xml";
//        String string = HttpKit.get(url, params);
//        log.debug("退款处理返回：" + string);
//        return RefundRequestResult.parseFromXML(string);
//
//    }
//
//    @Override
//    public RefundQueryResult queryRefund(String outTradeNo) {
//
//        HashMap<String, String> params = new HashMap<String, String>();
//        params.put("partner", this.wxPayHelper.getPartnerId());
//        params.put("input_charset", "UTF-8");
//        params.put("out_trade_no", outTradeNo);
//        String unSignParaString = CommonUtil.transMap2QueryString(params, false);
//        String sign = MD5SignUtil.sign(unSignParaString,
//                this.wxPayHelper.getPartnerKey());
//        params.put("sign", sign);
//        String url = "https://gw.tenpay.com/gateway/normalrefundquery.xml";
//        String string = HttpKit.get(url, params);
//        log.debug("查询退款返回：" + string);
//        return RefundQueryResult.parseFromXML(string);
//    }

    @Override
    public RedPackResponse sendRedpack(String accessToken, RedPack redPack) {
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
        RedPackResponse resp = null;
        TreeMap<String, String> map = Tools.transBean2Map(redPack);
        String unSignParaString = Tools.transMap2QueryString(map, false);
        String sign = MD5SignUtil.sign(unSignParaString, app.getPayKey());
        redPack.setSign(sign);
        String requestBody = MessageUtil.beanToXML(redPack);
        String s = null;
        try {
//            System.out.println(requestBody);
            s = httpClientHelper.post(url, requestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            RedPackResponse redPackResponse = MessageUtil.convertXmlToBean(s, RedPackResponse.class);
            return redPackResponse;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public RedPackResponse sendGroupRedpack(String accessToken, GroupRedpack redPack) {
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";
        RedPackResponse resp = null;
        TreeMap<String, String> map = Tools.transBean2Map(redPack);
        String unSignParaString = Tools.transMap2QueryString(map, false);
        String sign = MD5SignUtil.sign(unSignParaString, app.getPayKey());
        redPack.setSign(sign);
        String requestBody = MessageUtil.beanToXML(redPack);
        String s = null;
        try {
            System.out.println(requestBody);
            s = httpClientHelper.post(url, requestBody);
            System.out.println("============================");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            RedPackResponse redPackResponse = MessageUtil.convertXmlToBean(s, RedPackResponse.class);
            return redPackResponse;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return resp;
    }

    // @Override
    // public String queryStatement(QueryStatement query) {
    // String url = "http://mch.tenpay.com/cgi-bin/mchdown_real_new.cgi";
    // return null;
    // }


}
