package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.test.TestBase;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by 27716 on 2015/11/18.
 */
public class ServerApiTest extends TestBase {

    @Test
    public void testGetServerIpList(){
        List<String> serverIp = null;
        try {
            serverIp = super
                    .weChat.getServerApi().getServerIpList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(serverIp);
    }
}
