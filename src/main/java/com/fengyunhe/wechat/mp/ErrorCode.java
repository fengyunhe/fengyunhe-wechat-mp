package com.fengyunhe.wechat.mp;

import com.fengyunhe.wechat.mp.api.WechatApiException;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonNode;

import java.util.ResourceBundle;

/**
 * 功能：微信公众号API错误代码及JSON响应验证类
 * 作者： yangyan
 * 时间： 2014/7/15 .
 */
public class ErrorCode {

    static ResourceBundle resourceBundle = ResourceBundle.getBundle("wechat_mp_code");

    public static JsonNode check(String jsonString) {
        return check(JsonObjectUtils.stringToJsonNode(jsonString));
    }

    public static JsonNode check(JsonNode json) {
        if (json == null) {
            return JsonObjectUtils.stringToJsonNode("{}");
        }
        if (!json.has("errcode")) {
            return json;
        }
        int errcode = json.get("errcode").getIntValue();
        if (errcode == 0) {
            return json;
        }
        throw new RuntimeException(resourceBundle.containsKey("code_" + errcode)?resourceBundle.getString("code_" + errcode):"错误：" + errcode);
    }

    public static JsonNode checkJsApiTicketJson(String jsonStr) {
        JsonNode json = JsonObjectUtils.stringToJsonNode(jsonStr);
        int errcode = -1, expires_in = -1;
        String errmsg = null, ticket = null;
        try {
            if (null != json.get("errcode")) {
                errcode = json.get("errcode").getIntValue();
            }
            if (null != json.get("errmsg")) {
                errmsg = json.get("errmsg").getTextValue();
            }
            if (null != json.get("ticket")) {
                ticket = json.get("ticket").getTextValue();
            }
            if (null != json.get("expires_in")) {
                expires_in = json.get("expires_in").getIntValue();
            }
        } catch (Exception e) {
            throw new WechatApiException("获取json异常，获取到的json内容为：" + jsonStr, e);
        } finally {
            if (errcode == 0 && "ok".equals(errmsg) && expires_in > -1 && StringUtils.isNotBlank(ticket)) {
                return json;
            } else {
                if (errcode == 42001) { //access_token超时
                    return json;
                }
                throw new RuntimeException(resourceBundle.containsKey("code_" + errcode)?resourceBundle.getString("code_" + errcode):"错误：" + errcode);
            }
        }
    }
}
