package com.fengyunhe.wechat.mp.api;

import com.fengyunhe.wechat.mp.api.bean.*;

import java.io.File;
import java.util.List;

/**
 * 卡券API
 * Created by yangyan on 2015/6/1.
 */
public interface CardApi {

    /**
     * 上传商户LOGO ,上传的图片限制文件大小限制 1MB，像素为 300*300，支持 JPG 格式。
     *
     * @param accessToken
     * @param file
     * @return 返回商户logo的url
     */
    public String uploadLogo(String accessToken, File file);


    /**
     * 获取卡券的最新颜色列表
     *
     * @param accessToken
     * @return
     */
    public List<CardColor> getColorList(String accessToken);


    /**
     * 创建卡券
     *
     * @param accessToken
     * @param cardInfo
     * @return 创建成功后返回cardId
     */
    public String createCard(String accessToken, CardInfo cardInfo);


    /**
     * 解码code
     *
     * @param accessToken
     * @param code
     * @return
     */
    public String decode(String accessToken, String code);

    /**
     * 跳转外链签名验证
     *
     * @param code
     * @param cardId
     * @param sign
     * @return 计算结果等于sign时返回true，不等于时返回false
     */
    public boolean checkRedirectParams(String code, String cardId, String sign);


    /**
     * 生成卡券的二维码ticket
     *
     * @param accessToken
     * @param cardCode
     * @return
     */
    public String createQrCodeTicket(String accessToken, CardCode cardCode);


    /**
     * 核销卡卡券
     *
     * @param accessToken
     * @param card_id
     * @param code
     * @return 返回一个数组，第一个值为openId,第二个值为card_id，目前不理解为何微信会返回这两个值
     */
    public String[] comsume(String accessToken, String card_id, String code);

    /**
     * 删除卡券
     * 删除卡券接口允许商户删除任意一类卡券。删除卡券后，该卡券对应已生成的领取用二维
     * 码、添加到卡包 JS API 均会失效。
     * 注意：如用户在商家删除卡券前已领取一张或多张该卡券依旧有效。即删除卡券不能删除已被
     * 用户领取，保存在微信客户端中的卡券。
     *
     * @param accessToken
     * @param card_id
     * @return
     */
    public boolean delCard(String accessToken, String card_id);

    /**
     * 查询code
     * <p>
     * 调用查询 code 接口可获取 code 的有效性（非自定义 code），该 code 对应的用户
     * openid、卡券有效期等信息。
     * 自定义 code（use_custom_code 为 true）的卡券调用接口时，post 数据中需包含
     * card_id，非自定义 code 不需上报。
     *
     * @param accessToken
     * @param code
     * @param card_id
     * @return
     */
    public CardCodeAvailable getCodeAvailable(String accessToken, String code, String card_id);

    /**
     * 批量查询卡列表
     *
     * @param accessToken
     * @param offset
     * @param count
     * @return
     */
    public List<String> getCardList(String accessToken, Integer offset, Integer count);


    /**
     * 查询card
     *
     * @param accessToken
     * @param cardId
     * @return
     */
    public CardInfo get(String accessToken, String cardId);

    /**
     * 修改code
     *
     * @param accessToken
     * @param cardId
     * @param oldCode
     * @param newCode
     * @return
     */
    public boolean updateCode(String accessToken, String cardId, String oldCode, String newCode);


    /**
     * 将code设置为失效
     *
     * @param accessToken
     * @param cardId
     * @param code
     * @return
     */
    public boolean unavailableCode(String accessToken, String cardId, String code);


    /**
     * 更改卡券信息
     *
     * @param accessToken
     * @param cardInfo
     * @return
     */
    public boolean updateCard(String accessToken, UpdateCardInfo cardInfo);


    /**
     * 增加卡券库存
     *
     * @param accessToken
     * @param cardId
     * @param value
     * @return
     */
    public boolean increaseStock(String accessToken, Integer cardId, Integer value);


    /**
     * 减少卡券库存
     *
     * @param accessToken
     * @param cardId
     * @param value
     * @return
     */
    public boolean reduceStock(String accessToken, Integer cardId, Integer value);


    /**
     * 绑定会员卡
     *
     * @param accessToken
     * @param cardId           卡券 ID。自定义 code 的会员卡必填 card_id，
     *                         非自定义 code 的会员卡不必填。
     * @param membershipNumber 必填，会员卡编号，作为序列号显示在用户的
     *                         卡包里。
     * @param code             创建会员卡时获取的 code。
     * @param bonusNumber      初始积分，不填为 0。
     * @param balanceNumber    初始余额，不填为 0。
     * @param bonusUrl         积分查询，仅用于 init_bonus 无法同步的情况
     *                         填写，调转外链查询积分
     * @param balanceUrl       余额查询，仅用于 init_balance 无法同步的情
     *                         况填写，调转外链查询积分
     * @return
     */
    public boolean bindMemberCard(String accessToken, Integer cardId, String membershipNumber,
                                  String code, Integer bonusNumber, Integer balanceNumber,
                                  String bonusUrl, String balanceUrl);


//    TODO 卡券接口文档V2.0第54页

}
