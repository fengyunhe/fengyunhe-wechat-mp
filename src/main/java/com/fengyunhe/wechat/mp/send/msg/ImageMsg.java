package com.fengyunhe.wechat.mp.send.msg;

//{
//    "touser":"OPENID",
//    "msgtype":"image",
//    "image":
//    {
//      "media_id":"MEDIA_ID"
//    }
//}

import com.fengyunhe.wechat.mp.api.bean.Image;

/**
 * 客服消息：发出的图片消息
 *
 * @author Administrator
 */
public class ImageMsg extends AbstractSendMsg
{
    private Image image;


    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }


}
