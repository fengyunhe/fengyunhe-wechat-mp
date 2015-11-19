package com.fengyunhe.wechat.mp.send.msg;

//{"touser":"OPENID",
//"msgtype":"text",
//"text":
//{
//     "content":"Hello World"
//}
//}

import com.fengyunhe.wechat.mp.api.bean.Text;

/**
 * 客服消息：发送的消息
 *
 * @author Administrator
 */
public class TextMsg extends AbstractSendMsg
{

    private Text text;


    public Text getText()
    {
        return text;
    }

    public void setText(Text text)
    {
        this.text = text;
    }

}
