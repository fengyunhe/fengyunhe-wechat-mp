package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.utils.HttpClientHelper;
import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.TemplateMsgApi;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import com.google.common.collect.ImmutableMap;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.util.Map;

/**
 * Created by 27716 on 2015/11/19.
 */
public class TemplateMsgApiImpl extends ServerApiImpl implements TemplateMsgApi {

    public static final String SET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
    public static final String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
    public static final String SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

    public TemplateMsgApiImpl(WeChatApp app) {
        super(app);
    }

    @Override
    public boolean setIndustry(String industryId1, String industryId2) {

        String json = JsonObjectUtils.beanToJson(ImmutableMap.of(
                "industry_id1", industryId1,
                "industry_id1", industryId2
        ));
        try {
            String jsonStr = HttpClientHelper.INSTANCE.post(SET_INDUSTRY_URL + getAccessTokenString(), json);
            ErrorCode.check(jsonStr);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String addTemplate(String shortTemplateId) {
        String json = JsonObjectUtils.beanToJson(ImmutableMap.of(
                "template_id_short", shortTemplateId
        ));
        try {
            String jsonStr = HttpClientHelper.INSTANCE.post(GET_TEMPLATE_ID_URL + getAccessTokenString(), json);
            JsonNode check = ErrorCode.check(jsonStr);
            if (check.has("template_id")) {
                return check.get("template_id").getTextValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String send(String openId, String templateId, String url, Map<String, TemplateData> dataMap) {
        String json = JsonObjectUtils.beanToJson(ImmutableMap.of(
                "touser", openId,
                "template_id", templateId,
                "url", url,
                "data", dataMap
        ));
        try {
            String jsonStr = HttpClientHelper.INSTANCE.post(GET_TEMPLATE_ID_URL + getAccessTokenString(), json);
            JsonNode check = ErrorCode.check(jsonStr);
            if (check.has("msgid")) {
                return check.get("msgid").asText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
