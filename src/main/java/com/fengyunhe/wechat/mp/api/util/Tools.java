/**
 * 微信公众平台开发模式(JAVA) SDK
 * (c) 2012-2013 ____′↘夏悸 <wmails@126.cn>, MIT Licensed
 * http://www.jeasyuicn.com/wechat
 */
package com.fengyunhe.wechat.mp.api.util;

import com.fengyunhe.wechat.mp.pay.util.SDKRuntimeException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;

public final class Tools {

    /**
     * 检查公众平台server发来的请求
     *
     * @param token
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static final boolean checkSignature(String token, String signature,
                                               String timestamp, String nonce) {

        if (token == null || signature == null || timestamp == null
                || nonce == null) {
            return false;
        }

        List<String> params = new ArrayList<String>();
        params.add(token);
        params.add(timestamp);
        params.add(nonce);
        Collections.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String temp = params.get(0) + params.get(1) + params.get(2);
        return SHA1.encode(temp).equals(signature);
    }

    /**
     * 获取微信客户端版本号
     *
     * @param request
     * @return
     */
    public static String getClientVersion(HttpServletRequest request) {
        return getClientVersion(request.getHeader("User-Agent"));
    }

    /**
     * 获取微信客户端版本号
     *
     * @param agent
     * @return
     */
    private static String getClientVersion(String agent) {
        int index = agent.indexOf("MicroMessenger/");
        if (index > -1) {
            return agent.substring(index + "MicroMessenger/".length()).trim();
        }
        return null;
    }

    /**
     * 为支付链接显示安全支付
     *
     * @param url
     * @return
     */
    public static String payTitleUrl(String url) {
        if (url.indexOf("?") > -1) {
            return url + "&showwxpaytitle=1";
        } else {
            return url = "?showwxpaytitle=1";
        }
    }

    /**
     * 检测微信客户端是否支持微信支付
     *
     * @param request
     * @return
     */
    public static boolean clientIsSupportPay(HttpServletRequest request) {
        return clientIsSupportPay(getClientVersion(request));
    }

    /**
     * 检测微信客户端是否支持微信支付
     *
     * @param agent
     * @return
     */
    public static boolean clientIsSupportPay(String agent) {
        String clientVersion = getClientVersion(agent);
        try {
            return Float.valueOf(clientVersion) >= 5.0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 当前时间秒
     *
     * @return
     */
    public static long timestamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 当前时间秒
     *
     * @return
     */
    public static String timestampString() {
        return String.valueOf(timestamp());
    }

    /**
     * 随机码
     *
     * @return
     */
    public static String nonceStr() {
        return nonceStr(16);
    }

    /**
     * 随机码
     *
     * @return
     */
    public static String nonceStr(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }


    /**
     * 转换bean为一个map
     *
     * @param obj
     * @return
     */
    public static TreeMap<String, String> transBean2Map(Object obj) {

        if (obj == null) {
            return null;
        }
        TreeMap<String, String> map = new TreeMap<String, String>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if (value == null) {
                        continue;
                    }
                    map.put(key, String.valueOf(value));
                }

            }
        } catch (Exception e) {
//            System.out.println("transBean2Map Error " + e);
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 转换map为query字符串
     *
     * @param paraMap
     * @param urlencode
     * @return
     */
    public static String transMap2QueryString(TreeMap<String, String> paraMap,
                                              boolean urlencode) throws SDKRuntimeException {

        String buff = "";
        List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(
                paraMap.entrySet());

        Collections.sort(infoIds,
                new Comparator<Map.Entry<String, String>>() {
                    public int compare(Map.Entry<String, String> o1,
                                       Map.Entry<String, String> o2) {
                        return (o1.getKey()).toString().compareTo(
                                o2.getKey());
                    }
                });

        for (int i = 0; i < infoIds.size(); i++) {
            Map.Entry<String, String> item = infoIds.get(i);
            if (StringUtils.isNotBlank(item.getValue())) {
                String key = item.getKey();
                String val = item.getValue();
                if (urlencode) {
                    try {
                        val = URLEncoder.encode(val, "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                buff += key.toLowerCase() + "=" + val + "&";
            }
        }

        if (!buff.isEmpty()) {
            buff = buff.substring(0, buff.length() - 1);
        }
        return buff;
    }
}
