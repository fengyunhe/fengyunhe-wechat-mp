package com.fengyunhe.wechat.mp.pay.util;

import com.fengyunhe.wechat.mp.api.util.Tools;

import java.util.TreeMap;

public class MD5SignUtil {

    public static String sign(String content, String key)
            throws SDKRuntimeException {
        String signStr = "";

        if ("" == key) {
            throw new SDKRuntimeException("签名key不能为空！");
        }
        if ("" == content) {
            throw new SDKRuntimeException("签名内容不能为空");
        }
        signStr = content + "&key=" + key;
        return MD5Util.MD5(signStr).toUpperCase();
    }

    public static boolean VerifySignature(String content, String sign, String md5Key) {
        String signStr = content + "&key=" + md5Key;
        String calculateSign = MD5Util.MD5(signStr).toUpperCase();
        String tenpaySign = sign.toUpperCase();
        return (calculateSign == tenpaySign);
    }
}
