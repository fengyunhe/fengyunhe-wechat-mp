package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.test.TestBase;
import com.fengyunhe.wechat.mp.api.bean.Menu;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 测试自定义菜单
 * Created by yangyan on 2015/6/19.
 */
public class MenuApiTest extends TestBase {

    @Test
    @Ignore
    public void testCreateMenu() throws Exception {
        Menu menu = new Menu();

        List<Menu.Button> buttons = new ArrayList<Menu.Button>();
        buttons.add(new Menu.ClickButton("测试按钮1", "test1"));
        buttons.add(new Menu.MenuButton("测试菜单", new Menu.Button[]{new Menu.ClickButton("测试按钮2", "test2"), new Menu.ViewButton("测试按钮3", "http://baidu.com")}));
        buttons.add(new Menu.ClickButton("测试按钮4", "test4"));
        menu.setButton(buttons);
        boolean menu1 = weChat.getMenuApi().createMenu(token(), menu);
        out(menu1);

    }

    @Test
    @Ignore
    public void testGetMenuInfo() throws Exception {
        Menu menuInfo = weChat.getMenuApi().getMenuInfo(token());
        out(menuInfo);
    }

    @Test
    @Ignore
    public void testDeleteMenu() throws Exception {
        boolean b = weChat.getMenuApi().deleteMenu(token());
        out(b);
    }
}