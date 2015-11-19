package com.fengyunhe.wechat.mp.api.impl;

import com.fengyunhe.wechat.mp.ErrorCode;
import com.fengyunhe.wechat.mp.WeChatApp;
import com.fengyunhe.wechat.mp.api.CardApi;
import com.fengyunhe.wechat.mp.api.bean.*;
import com.fengyunhe.wechat.mp.api.util.HttpClientHelper;
import com.fengyunhe.wechat.mp.api.util.JsonObjectUtils;
import org.codehaus.jackson.JsonNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 微信卡券API 实现类
 * Created by yangyan on 2015/6/1.
 */
public class CardApiImpl implements CardApi {

    public static final String URL_UPLOAD_LOGO = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";
    public static final String URL_COLOR_LIST = "https://api.weixin.qq.com/card/getcolors?access_token=";
    public static final String URL_ADD_CARD = "https://api.weixin.qq.com/card/create?access_token=";
    public static final String URL_GEN_QR = "https://api.weixin.qq.com/card/qrcode/create?access_token=";
    public static final String URL_DECODE_CODE = "https://api.weixin.qq.com/card/code/decrypt?access_token=";
    public static final String URL_DEL_CARD = "https://api.weixin.qq.com/card/delete?access_token=";
    public static final String URL_GET_CODE = "https://api.weixin.qq.com/card/code/get?access_token=";
    public static final String URL_BATCH_GET_CARD = "https://api.weixin.qq.com/card/batchget?access_token=";
    public static final String URL_GET_CARD = "https://api.weixin.qq.com/card/get?access_token=";
    public static final String URL_UPDATE_CODE = "https://api.weixin.qq.com/card/code/update?access_token=";
    public static final String URL_UNAVAILABLE = "https://api.weixin.qq.com/card/code/unavailable?access_toke=";
    public static final String URL_UPDATE_CARD = "https://api.weixin.qq.com/card/update?access_token=";
    public static final String URL_MODIFY_STOCK = "https://api.weixin.qq.com/card/modifystock?access_token=";
    public static final String URL_BIND_MEMBER = "https://api.weixin.qq.com/card/membercard/activate?access_token=";

    private final WeChatApp app;

    public CardApiImpl(WeChatApp app) {
        this.app = app;
    }


    @Override
    public String uploadLogo(String accessToken, File file) {

        String post = HttpClientHelper.INSTANCE.upload(URL_UPLOAD_LOGO + accessToken, file);
        JsonNode jsonNode = ErrorCode.check(post);

        if (jsonNode.has("url")) {

            return jsonNode.get("url").getTextValue();
        }
        return null;
    }

    @Override
    public List<CardColor> getColorList(String accessToken) {

        String json = null;
        try {
            json = HttpClientHelper.INSTANCE.post(URL_COLOR_LIST + accessToken);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonNode jsonNode = ErrorCode.check(json);

        if (jsonNode.has("colors")) {

            List<CardColor> list = new ArrayList<CardColor>();
            Iterator<JsonNode> colorIter = jsonNode.get("colors").iterator();

            while (colorIter.hasNext()) {
                JsonNode next = colorIter.next();

                CardColor c = JsonObjectUtils.jsonNodeToBean(next, CardColor.class
                );


                list.add(c);

            }

            return list;
        }

        return null;
    }

    @Override
    public String createCard(String accessToken, CardInfo cardInfo) {

        String json = null;
        try {
            json = HttpClientHelper.INSTANCE.post(URL_ADD_CARD + accessToken, JsonObjectUtils.beanToJson(cardInfo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = ErrorCode.check(json);

        if (jsonNode.has("card_id")) {
            return jsonNode.get("card_id").getTextValue();
        }
        return null;
    }

    @Override
    public String decode(String accessToken, String code) {
        String json = null;
        try {
            json = HttpClientHelper.INSTANCE.post(URL_DECODE_CODE + accessToken, JsonObjectUtils.createJson(new String[]{"encrypt_code"}, new Object[]{
                    code
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = ErrorCode.check(json);

        if (jsonNode.has("code")) {
            return jsonNode
                    .get("code").getTextValue();
        }
        return null;
    }

    @Override
    public boolean checkRedirectParams(String code, String cardId, String sign) {
        return false;
    }

    @Override
    public String createQrCodeTicket(String accessToken, CardCode cardCode) {
        String json = null;
        try {
            json = HttpClientHelper.INSTANCE.post(URL_GEN_QR + accessToken, JsonObjectUtils.beanToJson(cardCode));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = ErrorCode.check(json);

        if (jsonNode.has("ticket")) {
            return jsonNode.get("ticket").getTextValue();
        }
        return null;
    }


    @Override
    public String[] comsume(String accessToken, String card_id, String code) {
        return new String[0];
    }

    @Override
    public boolean delCard(String accessToken, String card_id) {
        String json = null;
        try {
            json = HttpClientHelper.INSTANCE.post(URL_DEL_CARD + accessToken, JsonObjectUtils.createJson(new String[]{
                    "card_id"}, new Object[]{card_id
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = ErrorCode.check(json);

        return true;
    }

    @Override
    public CardCodeAvailable getCodeAvailable(String accessToken, String code, String card_id) {
        String json = null;
        if (card_id != null) {
            try {
                json = HttpClientHelper.INSTANCE.post(URL_GET_CODE + accessToken, JsonObjectUtils.createJson(new String[]{
                        "card_id", "code"}, new Object[]{card_id, code
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                json = HttpClientHelper.INSTANCE.post(URL_GET_CODE + accessToken, JsonObjectUtils.createJson(new String[]{
                        "code"}, new Object[]{code
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JsonNode jsonNode = ErrorCode.check(json);


        CardCodeAvailable c = new CardCodeAvailable();
        c.setOpenid(jsonNode.get("openid").getTextValue());
        CardCodeAvailable.Card card = new CardCodeAvailable.Card();

        card.setBegin_time(jsonNode.get("card").get("begin_time").getLongValue());

        card.setEnd_time(jsonNode.get("card").get("end_time").getLongValue());
        card.setCard_id(jsonNode.get("card").get("card_id").getTextValue());

        return c;

    }

    @Override
    public List<String> getCardList(String accessToken, Integer offset, Integer count) {
//        TODO
        return null;
    }

    @Override
    public CardInfo get(String accessToken, String cardId) {
//        TODO
        return null;
    }

    @Override
    public boolean updateCode(String accessToken, String cardId, String oldCode, String newCode) {
        String json = null;
        try {
            json = HttpClientHelper.INSTANCE.post(URL_UPDATE_CODE + accessToken, JsonObjectUtils.createJson(new String[]{
                    "card_id", "code", "new_code"}, new Object[]{cardId,
                    oldCode, newCode
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = ErrorCode.check(json);
        return true;
    }

    @Override
    public boolean unavailableCode(String accessToken, String cardId, String code) {
        String json = null;
        if (cardId != null) {
            try {
                json = HttpClientHelper.INSTANCE.post(URL_UNAVAILABLE + accessToken, JsonObjectUtils.createJson(new String[]{
                        "card_id", "code"}, new Object[]{cardId,
                        code
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                json = HttpClientHelper.INSTANCE.post(URL_UNAVAILABLE + accessToken, JsonObjectUtils.createJson(new String[]{
                        "code"}, new Object[]{
                        code
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JsonNode jsonNode = ErrorCode.check(json);
        return true;
    }

    @Override
    public boolean updateCard(String accessToken, UpdateCardInfo cardInfo) {

        //TODO 这里需要深入
        return false;
    }

    @Override
    public boolean increaseStock(String accessToken, Integer cardId, Integer value) {
        String json = null;
        try {
            json = HttpClientHelper.INSTANCE.post(URL_MODIFY_STOCK + accessToken, JsonObjectUtils.createJson(new String[]{
                    "card_id", "increase_stock_value"}, new Object[]{cardId,
                    value
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = ErrorCode.check(json);
        return true;
    }

    @Override
    public boolean reduceStock(String accessToken, Integer cardId, Integer value) {
        String json = null;
        try {
            json = HttpClientHelper.INSTANCE.post(URL_MODIFY_STOCK + accessToken, JsonObjectUtils.createJson(new String[]{
                    "card_id", "reduce_stock_value"}, new Object[]{cardId,
                    value
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = ErrorCode.check(json);
        return true;
    }

    @Override
    public boolean bindMemberCard(String accessToken, Integer cardId, String membershipNumber, String code, Integer bonusNumber, Integer balanceNumber, String bonusUrl, String balanceUrl) {
        return false;
    }
}
