package com.fengyunhe.wechat.mp.api.bean;

/**
 * 监测code有效性返回的对象
 * Created by yangyan on 2015/6/2.
 */
public class CardCodeAvailable {

    private String openid;
    private Card card;

    public CardCodeAvailable() {
    }

    public CardCodeAvailable(String openid, Card card) {
        this.openid = openid;
        this.card = card;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

   public static class Card {
        private String card_id;
        private long begin_time;
        private long end_time;

        public Card() {

        }

        public Card(String card_id, long begin_time, long end_time) {
            this.card_id = card_id;
            this.begin_time = begin_time;
            this.end_time = end_time;
        }

        public String getCard_id() {
            return card_id;
        }

        public void setCard_id(String card_id) {
            this.card_id = card_id;
        }

        public long getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(long begin_time) {
            this.begin_time = begin_time;
        }

        public long getEnd_time() {
            return end_time;
        }

        public void setEnd_time(long end_time) {
            this.end_time = end_time;
        }
    }
}
