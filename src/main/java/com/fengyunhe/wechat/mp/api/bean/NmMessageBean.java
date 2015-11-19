package com.fengyunhe.wechat.mp.api.bean;

import java.io.Serializable;

/**
 * 从NM发给wx这里的bean.
 * 补充发信人
 *
 * @author yangxun
 */
public class NmMessageBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;


    //发信人的openid
    private String fromUser;


    //msg的完整json字符串
    /*
	  {
	    "touser":"OPENID",
	    "msgtype":"text",
	    "text":{
	         	"content":"Hello World"
	     }
	  }
	 */
    private String MsgJson;

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getMsgJson() {
        return MsgJson;
    }

    public void setMsgJson(String msgJson) {
        MsgJson = msgJson;
    }


}
