package com.fengyunhe.wechat.mp.api.bean;

/**
 * 功能：文本
 * 作者： yangyan
 * 时间： 2014/10/17 .
 */
public class Text
{

    public Text()
    {

    }

    public Text(String content)
    {
        super();
        this.content = content;
    }

    private String content;

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}
