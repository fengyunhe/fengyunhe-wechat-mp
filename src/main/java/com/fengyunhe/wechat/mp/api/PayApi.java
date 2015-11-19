package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.GroupRedpack;
import com.fengyunhe.wechat.mp.api.bean.RedPack;
import com.fengyunhe.wechat.mp.api.bean.RedPackResponse;
import com.fengyunhe.wechat.mp.pay.bean.DeliverNotify;
import com.fengyunhe.wechat.mp.pay.bean.RefundQueryResult;
import com.fengyunhe.wechat.mp.pay.bean.RefundRequestResult;
import com.fengyunhe.wechat.mp.pay.bean.WxOrderInfo;

/**
 * 微信支付API
 */
public interface PayApi {
//    /**
//     * 发货通知
//     *
//     * @param accessToken
//     * @param deliverNotify
//     * @return
//     */
//    public boolean sendDeliverNotify(String accessToken,
//                                     DeliverNotify deliverNotify);
//
//    /**
//     * 查询订单
//     *
//     * @param accessToken
//     * @param packageString
//     * @param timestamp
//     * @param packageString
//     * @param sign_method
//     * @return
//     */
//    public WxOrderInfo orderQuery(String accessToken, String packageString,
//                                  String timestamp, String sign_method);
//
//    /**
//     * 标记客户投诉处理状态
//     *
//     * @param accessToken
//     * @param openId
//     * @param feedbackId
//     * @return
//     */
//    public boolean updateFeedback(String accessToken, String openId,
//                                  String feedbackId);

//    /**
//     * 退款
//     *
//     * @param outTradeNo
//     * @param outRefundNo
//     * @param totalFee
//     * @param refundFee
//     * @param op_user_id
//     * @param op_user_passwd
//     * @return
//     */
//    public RefundRequestResult refund(String outTradeNo, String outRefundNo,
//                                      Integer totalFee, Integer refundFee, Integer op_user_id,
//                                      String op_user_passwd);
//
//    /**
//     * 退款查询
//     *
//     * @param outTradeNo
//     * @return
//     */
//    public RefundQueryResult queryRefund(String outTradeNo);

    // /**
    // * 查询对账单
    // *
    // * @param query
    // * @return
    // */
    // public String queryStatement(QueryStatement query);

    /**
     * 发送红包接口
     *
     * @param accessToken
     * @param redPack
     * @return
     */
    public RedPackResponse sendRedpack(String accessToken, RedPack redPack);

    /**
     * 发送分裂红包接口
     *
     * @param accessToken
     * @param redPack
     * @return
     */
    public RedPackResponse sendGroupRedpack(String accessToken, GroupRedpack redPack);

}
