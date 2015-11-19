package com.fengyunhe.wechat.mp.api.bean;

import java.util.List;

public class Menu {

    private List<Button> button;

    public static abstract class Button {

        public Button(String type, String name) {
            super();
            this.type = type;
            this.name = name;
        }

        private String type;
        private String name;

        public final String getType() {
            return type;
        }

        public final void setType(String type) {
            this.type = type;
        }

        public final String getName() {
            return name;
        }

        public final void setName(String name) {
            this.name = name;
        }

    }

    public static class ClickButton extends Button {
        private String key;

        public final String getKey() {
            return key;
        }

        public final void setKey(String key) {
            this.key = key;
        }

        public ClickButton(String name, String key) {
            super("click", name);
            this.key = key;
        }

    }

    public static class ViewButton extends Button {
        private String url;

        public ViewButton(String name, String url) {
            super("view", name);
            this.url = url;
        }

        public final String getUrl() {
            return url;
        }

        public final void setUrl(String url) {
            this.url = url;
        }

    }

    public static class MenuButton extends Button {

        public MenuButton(String name, Button[] sub_button) {
            super("menu", name);
            this.sub_button = sub_button;
        }

        private Button[] sub_button;

        public final Button[] getSub_button() {
            return sub_button;
        }

        public final void setSub_button(Button[] sub_button) {
            this.sub_button = sub_button;
        }

    }

    public final List<Button> getButton() {
        return button;
    }

    public final void setButton(List<Button> button) {
        this.button = button;
    }
}