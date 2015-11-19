package com.fengyunhe.wechat.mp.pay.bean;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 退款查询结果
 *
 * @author yangyan
 */
public class RefundQueryResult {
    // 协议参数
    private String sign_type;
    private String input_charset;
    private String sign;
    // 业务参数
    private Integer retcode;
    private String retmsg;
    private String partner;
    private String out_trade_no;
    private String transaction_id;
    private Integer refund_count;
    private Integer sign_key_index;

    private List<RefundItem> list;

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getInput_charset() {
        return input_charset;
    }

    public void setInput_charset(String input_charset) {
        this.input_charset = input_charset;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getRetcode() {
        return retcode;
    }

    public void setRetcode(Integer retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getRefund_count() {
        return refund_count;
    }

    public void setRefund_count(Integer refund_count) {
        this.refund_count = refund_count;
    }

    public List<RefundItem> getList() {
        return list;
    }

    public void setList(List<RefundItem> list) {
        this.list = list;
    }

    public String xml = null;

    /**
     * 将退款查询结果XML转换为对象
     *
     * @param xml
     * @return
     */
    public static RefundQueryResult parseFromXML(String xml) {
        RefundQueryResult q = new RefundQueryResult();
        q.xml = xml;
        Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException("退款XML解析错误", e);
        }
        Node root = document;
        // System.out.println(root);

        q.setInput_charset(root.selectSingleNode("/root/input_charset")
                .getText());

        q.setOut_trade_no(root.selectSingleNode("/root/out_trade_no").getText());
        q.setPartner(root.selectSingleNode("/root/partner").getText());
        q.setRetcode(Integer.valueOf(root.selectSingleNode("/root/retcode")
                .getText()));
        q.setRetmsg(root.selectSingleNode("/root/retmsg").getText());
        q.setSign(root.selectSingleNode("/root/sign").getText());
        q.setSign_key_index(Integer.valueOf(root.selectSingleNode(
                "/root/sign_key_index").getText()));
        q.setSign_type(root.selectSingleNode("/root/sign_type").getText());

        if (q.getRetcode() == 0) {

            q.setRefund_count(Integer.valueOf(root.selectSingleNode(
                    "/root/refund_count").getText()));
            q.setTransaction_id(root.selectSingleNode("/root/transaction_id")
                    .getText());
            if (q.getRefund_count() > 0) {
                q.setList(new ArrayList<RefundQueryResult.RefundItem>());
                for (int i = 0; i < q.getRefund_count(); i++) {
                    RefundItem refundItem = new RefundItem();
                    refundItem.setIndex(i);
                    refundItem.setOut_refund_no(root.selectSingleNode(
                            "/root/out_refund_no_" + i).getText());
                    refundItem.setRecv_user_name(root.selectSingleNode(
                            "/root/recv_user_name_" + i).getText());
                    if (StringUtils.isNotEmpty(root.selectSingleNode(
                            "/root/recv_user_id_" + i).getText())) {
                        refundItem.setRecv_user_id(Integer.parseInt(root
                                .selectSingleNode("/root/recv_user_id_" + i)
                                .getText()));
                    }

                    refundItem.setRefund_channel(Integer.parseInt(root
                            .selectSingleNode("/root/refund_channel_" + i)
                            .getText()));
                    refundItem.setRefund_fee(Integer.parseInt(root
                            .selectSingleNode("/root/refund_fee_" + i)
                            .getText()));
                    refundItem.setRefund_id(root.selectSingleNode(
                            "/root/refund_id_" + i).getText());
                    refundItem.setRefund_state(Integer.parseInt(root
                            .selectSingleNode("/root/refund_state_" + i)
                            .getText()));
                    q.getList().add(refundItem);
                }
            }
        }
        return q;
    }

    public static class RefundItem {
        private Integer index;
        private String out_refund_no;
        private String refund_id;
        private Integer refund_channel;
        private Integer refund_fee;
        private Integer refund_state;
        private Integer recv_user_id;
        private String recv_user_name;

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getOut_refund_no() {
            return out_refund_no;
        }

        public void setOut_refund_no(String out_refund_no) {
            this.out_refund_no = out_refund_no;
        }

        public String getRefund_id() {
            return refund_id;
        }

        public void setRefund_id(String refund_id) {
            this.refund_id = refund_id;
        }

        public Integer getRefund_channel() {
            return refund_channel;
        }

        public void setRefund_channel(Integer refund_channel) {
            this.refund_channel = refund_channel;
        }

        public Integer getRefund_fee() {
            return refund_fee;
        }

        public void setRefund_fee(Integer refund_fee) {
            this.refund_fee = refund_fee;
        }

        public Integer getRefund_state() {
            return refund_state;
        }

        public void setRefund_state(Integer refund_state) {
            this.refund_state = refund_state;
        }

        public Integer getRecv_user_id() {
            return recv_user_id;
        }

        public void setRecv_user_id(Integer recv_user_id) {
            this.recv_user_id = recv_user_id;
        }

        public String getRecv_user_name() {
            return recv_user_name;
        }

        public void setRecv_user_name(String recv_user_name) {
            this.recv_user_name = recv_user_name;
        }
    }

    public Integer getSign_key_index() {
        return sign_key_index;
    }

    public void setSign_key_index(Integer sign_key_index) {
        this.sign_key_index = sign_key_index;
    }

    public String getXml() {
        return xml;
    }
}
