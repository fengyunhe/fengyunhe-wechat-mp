package com.fengyunhe.wechat.mp.send.msg;

import com.fengyunhe.wechat.mp.api.bean.News;

//{
//    "touser":"OPENID",
//    "msgtype":"news",
//    "news":{
//        "articles": [
//         {
//             "title":"Happy Day",
//             "description":"Is Really A Happy Day",
//             "url":"URL",
//             "picurl":"PIC_URL"
//         },
//         {
//             "title":"Happy Day",
//             "description":"Is Really A Happy Day",
//             "url":"URL",
//             "picurl":"PIC_URL"
//         }
//         ]
//    }
//}

/**
 * 客服消息：图文
 *
 * @author Administrator
 */
public class NewsMsg extends AbstractSendMsg
{
    private News news;


    public NewsMsg()
    {
    }

    public NewsMsg(News news)
    {
        super();
        this.news = news;
    }

    public News getNews()
    {
        return news;
    }

    public void setNews(News news)
    {
        this.news = news;
    }


}
