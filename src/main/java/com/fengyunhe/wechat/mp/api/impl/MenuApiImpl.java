package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.MenuApi;
import com.fengyunhe.wechat.mp.api.bean.Menu;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MenuApiImpl extends ServerApiImpl implements MenuApi {


    public MenuApiImpl(WeChatApp app) {
        super(app);
    }

    /**
     * 创建菜单
     *
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public boolean createMenu(String accessToken, Menu menu)
            throws KeyManagementException, NoSuchAlgorithmException,
            NoSuchProviderException, IOException {
        String jsonStr = HttpClientHelper.INSTANCE.post(
                "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
                        + accessToken, JsonObjectUtils.beanToJson(menu));
        Map<String, Object> map = JsonObjectUtils
                .jsonToBean(jsonStr, Map.class);
        return "0".equals(map.get("errcode").toString());
    }

    /**
     * 查询菜单
     *
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public Menu getMenuInfo(String accessToken) throws KeyManagementException,
            NoSuchAlgorithmException, NoSuchProviderException, IOException {
        String jsonStr = HttpClientHelper.INSTANCE
                .get("https://api.weixin.qq.com/cgi-bin/menu/get?access_token="
                        + accessToken);
        JsonNode json = JsonObjectUtils.stringToJsonNode(jsonStr);
        if (json.has("menu")) {
            Menu menu = new Menu();
            List<Menu.Button> buttons = new ArrayList<Menu.Button>();

            JsonNode jsonNode = json.get("menu").get("button");
            Iterator<JsonNode> iterator = jsonNode.iterator();
            while (iterator.hasNext()) {
                JsonNode btn = iterator.next();
                Menu.Button b = null;
                String name = btn.get("name").getTextValue();

                if (!btn.has("type")) {
                    ArrayList<Menu.Button> subButtons = null;
                    Iterator<JsonNode> iterator2 = btn.get("sub_button")
                            .iterator();
                    while (iterator2.hasNext()) {
                        Menu.Button sb = null;
                        if (subButtons == null) {
                            subButtons = new ArrayList<Menu.Button>();
                        }
                        JsonNode subBtn = iterator2.next();
                        String n = subBtn.get("name").getTextValue();
                        String t = subBtn.get("type").getTextValue();
                        if (t.equals("click")) {
                            sb = new Menu.ClickButton(n, subBtn.get("key")
                                    .getTextValue());

                        } else if (t.equals("view")) {
                            sb = new Menu.ViewButton(n, subBtn.get("url")
                                    .getTextValue());
                        }
                        sb.setName(n);
                        subButtons.add(sb);
                    }
                    if (subButtons != null) {
                        b = new Menu.MenuButton(
                                name,
                                subButtons.toArray(new Menu.Button[subButtons.size()]));
                    }
                } else {
                    String type = btn.get("type").getTextValue();
                    if (type.equals("click")) {
                        b = new Menu.ClickButton(name, btn.get("key")
                                .getTextValue());
                    } else if (type.equals("view")) {
                        b = new Menu.ViewButton(name, btn.get("url")
                                .getTextValue());
                    }
                }

                b.setName(name);
                buttons.add(b);
            }

            menu.setButton(buttons);
            return menu;
        }
        return null;
    }

    /**
     * 删除自定义菜单
     *
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public boolean deleteMenu(String accessToken)
            throws KeyManagementException, NoSuchAlgorithmException,
            NoSuchProviderException, IOException {
        String jsonStr = HttpClientHelper.INSTANCE
                .get("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="
                        + accessToken);
        Map<String, Object> map = JsonObjectUtils
                .jsonToBean(jsonStr, Map.class);
        return "0".equals(map.get("errcode").toString());
    }
}
