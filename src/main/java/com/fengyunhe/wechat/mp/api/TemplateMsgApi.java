package com.fengyunhe.wechat.mp.api;

import java.util.Map;

/**
 * 模板消息API
 * Created by 27716 on 2015/11/19.
 */
public interface TemplateMsgApi {


    /**
     * 设置行业
     * @param industryId1
     * @param industryId2
     * @return
     */
    public boolean setIndustry(String industryId1, String industryId2);

    /**
     * 获取模板id
     * @param shortTemplateId
     * @return
     */
    public String addTemplate(String shortTemplateId);

    /**
     * 发送模板消息
     * @param openId
     * @param templateId
     * @param url
     * @param dataMap
     * @return 返回消息id
     */
    public String send(String openId, String templateId, String url, Map<String, TemplateData> dataMap);


    class TemplateData {
        String value;
        String color;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
