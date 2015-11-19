package com.fengyunhe.wechat.mp.api.bean;

/**
 * 微信卡券对象
 * Created by yangyan on 2015/6/2.
 */
public abstract class CardInfo {

    /**
     * 卡券类型：通用券
     */
    public static final String TYPE_GENERAL_COUPON = "GENERAL_COUPON";
    /**
     * 卡券类型：团购券：
     */
    public static final String TYPE_GROUPON = "GROUPON";
    /**
     * 卡券类型：折扣券：
     */
    public static final String TYPE_DISCOUNT = "DISCOUNT";
    /**
     * 卡券类型：礼品券：
     */
    public static final String TYPE_GIFT = "GIFT";
    /**
     * 卡券类型：代金券：
     */
    public static final String TYPE_CASH = "CASH";
    /**
     * 卡券类型：会员卡：
     */
    public static final String TYPE_MEMBER_CARD = "MEMBER_CARD";
    /**
     * 卡券类型：景点门票
     */
    public static final String TYPE_SCENIC_TICKET = "SCENIC_TICKET";
    /**
     * 卡券类型：电影票：
     */
    public static final String TYPE_MOVIE_TICKET = "MOVIE_TICKET";
    /**
     * 卡券类型：飞机票：
     */
    public static final String TYPE_BOARDING_PASS = "BOARDING_PASS";
    /**
     * 卡券类型：红包
     */
    public static final String TYPE_LUCKY_MONEY = "LUCKY_MONEY";
    /**
     * 卡券类型：会议门票
     */
    public static final String TYPE_MEETING_TICKET = "MEETING_TICKET";


    /**
     * 通用券
     */
    public static class GeneralCouponCardInfo extends CardInfo {

        public GeneralCouponCardInfo() {
            this.setCard_type(TYPE_GENERAL_COUPON);
        }

        public GeneralCouponCardInfo(GeneralCouponCard card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 团购券
     */
    public static class GrouponCardInfo extends CardInfo {

        public GrouponCardInfo() {
            this.setCard_type(TYPE_GROUPON);
        }

        public GrouponCardInfo(GrouponCard card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 礼品券
     */
    public static class GiftCardInfo extends CardInfo {

        public GiftCardInfo() {
            this.setCard_type(TYPE_GIFT);
        }

        public GiftCardInfo(GiftCard card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 现金券
     */
    public static class CashCardInfo extends CardInfo {

        public CashCardInfo() {
            this.setCard_type(TYPE_CASH);
        }

        public CashCardInfo(CashCard card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 折扣券
     */
    public static class DiscountCardInfo extends CardInfo {

        public DiscountCardInfo() {
            this.setCard_type(TYPE_GIFT);
        }

        public DiscountCardInfo(DiscountCard card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 会员卡
     */
    public static class MemberCardInfo extends CardInfo {

        public MemberCardInfo() {
            this.setCard_type(TYPE_MEMBER_CARD);
        }

        public MemberCardInfo(MemberCard card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 景点门票
     */
    public static class ScenicTicketInfo extends CardInfo {

        public ScenicTicketInfo() {
            this.setCard_type(TYPE_SCENIC_TICKET);
        }

        public ScenicTicketInfo(ScenicTicket card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 电影票
     */
    public static class MovieTicketInfo extends CardInfo {

        public MovieTicketInfo() {
            this.setCard_type(TYPE_MOVIE_TICKET);
        }

        public MovieTicketInfo(MovieTicket card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 飞机票
     */
    public static class BoardingPassInfo extends CardInfo {

        public BoardingPassInfo() {
            this.setCard_type(TYPE_BOARDING_PASS);
        }

        public BoardingPassInfo(BoardingPass card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 红包
     */
    public static class LucklyMoneyInfo extends CardInfo {

        public LucklyMoneyInfo() {
            this.setCard_type(TYPE_GIFT);
        }

        public LucklyMoneyInfo(LucklyMoney card) {
            this();
            this.setCard(card);
        }
    }

    /**
     * 会议门票
     */
    public static class MeetingTicketInfo extends CardInfo {

        public MeetingTicketInfo() {
            this.setCard_type(TYPE_GIFT);
        }

        public MeetingTicketInfo(MeetingTicket card) {
            this();
            this.setCard(card);
        }
    }

    private String card_type;
    private AbstractCard card;


    public AbstractCard getCard() {
        return card;
    }

    public void setCard(AbstractCard card) {
        this.card = card;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_type() {
        return card_type;
    }


    static abstract class AbstractCard {

        BaseInfo base_info;

        public AbstractCard() {

        }

        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }
    }

    /**
     * 通用券
     */
    public static class GeneralCouponCard extends AbstractCard {
        private String default_detail;

        public GeneralCouponCard() {

        }

        /**
         * @param base_info
         * @param default_detail 描述文本
         */
        public GeneralCouponCard(BaseInfo base_info, String default_detail) {
            this.base_info = base_info;
            this.default_detail = default_detail;
        }


        public String getDefault_detail() {
            return default_detail;
        }

        public void setDefault_detail(String default_detail) {
            this.default_detail = default_detail;
        }
    }


    /**
     * 团购卡券
     */
    public static class GrouponCard extends AbstractCard {

        private BaseInfo base_info;
        private String deal_detail;


        public GrouponCard() {
        }

        /**
         * @param base_info   基本卡券数据
         * @param deal_detail 团购券专用，团购详情
         */
        public GrouponCard(BaseInfo base_info, String deal_detail) {
            this();
            this.base_info = base_info;
            this.deal_detail = deal_detail;
        }

        public BaseInfo getBase_info() {

            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }

        public String getDeal_detail() {
            return deal_detail;
        }

        public void setDeal_detail(String deal_detail) {
            this.deal_detail = deal_detail;
        }


    }


    /**
     * 礼品卡券
     */

    public static class GiftCard extends AbstractCard {
        private BaseInfo base_info;
        private String gift;

        public GiftCard() {
        }

        /**
         * @param base_info
         * @param gift      礼品名字
         */
        public GiftCard(BaseInfo base_info, String gift) {
            this();
            this.base_info = base_info;
            this.gift = gift;
        }

        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }

        public String getGift() {
            return gift;
        }

        public void setGift(String gift) {
            this.gift = gift;
        }
    }


    /**
     * 代金券
     */
    public static class CashCard extends AbstractCard {

        public CashCard() {
        }

        private BaseInfo base_info;

        private Integer least_cost;

        private Integer reduce_cost;

        /**
         * @param base_info
         * @param least_cost  启用金额（单位分），可以不给
         * @param reduce_cost 减免金额（单位分）
         */
        public CashCard(BaseInfo base_info, Integer least_cost, Integer reduce_cost) {
            this();
            this.base_info = base_info;
            this.least_cost = least_cost;
            this.reduce_cost = reduce_cost;
        }

        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }

        public Integer getLeast_cost() {
            return least_cost;
        }

        public void setLeast_cost(Integer least_cost) {
            this.least_cost = least_cost;
        }

        public Integer getReduce_cost() {
            return reduce_cost;
        }

        public void setReduce_cost(Integer reduce_cost) {
            this.reduce_cost = reduce_cost;
        }
    }


    /**
     * 折扣券
     */
    public static class DiscountCard extends AbstractCard {
        private BaseInfo base_info;
        private Integer discount;

        public DiscountCard() {
        }

        /**
         * @param base_info
         * @param discount  折扣券专用，表示打折额度（百分比）。填 30 就是七折。
         */
        public DiscountCard(BaseInfo base_info, Integer discount) {
            this();
            this.base_info = base_info;
            this.discount = discount;
        }

        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }
    }

    /**
     * 会员卡
     */
    public class MemberCard extends AbstractCard {
        private BaseInfo base_info;
        private boolean supply_bonus;
        private boolean supply_balance;
        private String bonus_cleared;
        private String bonus_rules;
        private String balance_rules;
        private String prerogative;
        private String bind_old_card_url;
        private String activate_url;
        private boolean need_push_on_view;

        public MemberCard() {
            CardInfo.this.card_type = TYPE_MEMBER_CARD;
        }

        /**
         * @param base_info
         * @param supply_bonus      是否支持积分，填写 true 或
         *                          false，如填写 true，积分相关
         *                          字段均为必填。填写 false，积
         *                          分字段无需填写。 储值字段处理
         *                          方式相同。
         * @param supply_balance    是否支持储值，填写 true 或
         *                          false。（该权限申请及说明详
         *                          见 Q&A)
         * @param bonus_cleared     积分清零规则
         * @param bonus_rules       积分规则
         * @param balance_rules     储值说明
         * @param prerogative       特权说明
         * @param bind_old_card_url 绑定旧卡的 url，与
         *                          “activate_url”字段二选一必
         *                          填。
         * @param activate_url      激活会员卡的 url，与
         *                          “bind_old_card_url”字段二
         *                          选一必填。
         * @param need_push_on_view true 为用户点击进入会员卡时
         *                          是否推送事件。
         */
        public MemberCard(BaseInfo base_info, boolean supply_bonus, boolean supply_balance, String bonus_cleared, String bonus_rules, String balance_rules, String prerogative, String bind_old_card_url, String activate_url, boolean need_push_on_view) {
            this();
            this.base_info = base_info;
            this.supply_bonus = supply_bonus;
            this.supply_balance = supply_balance;
            this.bonus_cleared = bonus_cleared;
            this.bonus_rules = bonus_rules;
            this.balance_rules = balance_rules;
            this.prerogative = prerogative;
            this.bind_old_card_url = bind_old_card_url;
            this.activate_url = activate_url;
            this.need_push_on_view = need_push_on_view;
        }

        public BaseInfo getBase_info() {

            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }

        public boolean isSupply_bonus() {
            return supply_bonus;
        }

        public void setSupply_bonus(boolean supply_bonus) {
            this.supply_bonus = supply_bonus;
        }

        public boolean isSupply_balance() {
            return supply_balance;
        }

        public void setSupply_balance(boolean supply_balance) {
            this.supply_balance = supply_balance;
        }

        public String getBonus_cleared() {
            return bonus_cleared;
        }

        public void setBonus_cleared(String bonus_cleared) {
            this.bonus_cleared = bonus_cleared;
        }

        public String getBonus_rules() {
            return bonus_rules;
        }

        public void setBonus_rules(String bonus_rules) {
            this.bonus_rules = bonus_rules;
        }

        public String getBalance_rules() {
            return balance_rules;
        }

        public void setBalance_rules(String balance_rules) {
            this.balance_rules = balance_rules;
        }

        public String getPrerogative() {
            return prerogative;
        }

        public void setPrerogative(String prerogative) {
            this.prerogative = prerogative;
        }

        public String getBind_old_card_url() {
            return bind_old_card_url;
        }

        public void setBind_old_card_url(String bind_old_card_url) {
            this.bind_old_card_url = bind_old_card_url;
        }

        public String getActivate_url() {
            return activate_url;
        }

        public void setActivate_url(String activate_url) {
            this.activate_url = activate_url;
        }

        public boolean isNeed_push_on_view() {
            return need_push_on_view;
        }

        public void setNeed_push_on_view(boolean need_push_on_view) {
            this.need_push_on_view = need_push_on_view;
        }
    }


    /**
     * 景点门票
     */
    public static class ScenicTicket extends AbstractCard {
        private BaseInfo base_info;
        private String ticket_class;
        private String guide_url;

        public ScenicTicket() {
        }

        /**
         * @param base_info
         * @param ticket_class 非必填，票类型， 例如平日全票， 套票等。
         * @param guide_url    非必填，导览图 url
         */
        public ScenicTicket(BaseInfo base_info, String ticket_class, String guide_url) {
            this();
            this.base_info = base_info;
            this.ticket_class = ticket_class;
            this.guide_url = guide_url;
        }

        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }

        public String getTicket_class() {
            return ticket_class;
        }

        public void setTicket_class(String ticket_class) {
            this.ticket_class = ticket_class;
        }

        public String getGuide_url() {
            return guide_url;
        }

        public void setGuide_url(String guide_url) {
            this.guide_url = guide_url;
        }
    }


    /**
     * 电影票
     */
    public static class MovieTicket extends AbstractCard {
        private BaseInfo base_info;
        private String detail;

        public MovieTicket() {
        }

        /**
         * @param base_info
         * @param detail    电影票详情
         */
        public MovieTicket(BaseInfo base_info, String detail) {
            this();
            this.base_info = base_info;
            this.detail = detail;
        }

        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }


    /**
     * 飞机票
     */
    public static class BoardingPass extends AbstractCard {
        private BaseInfo base_info;
        private String form;
        private String to;
        private String flight;
        private long departure_time;
        private long landing_time;
        private String check_in_url;
        private String gate;
        private long boarding_time;
        private String air_model;

        public BoardingPass() {
        }

        /**
         * @param base_info
         * @param form           必填，起点，上限为 18 个汉字。
         * @param to             必填，终点，上限为 18 个汉字。
         * @param flight         必填，航班
         * @param departure_time 非必填，起飞时间。Unix 时间戳格式。
         * @param landing_time   非必填，降落时间。Unix 时间戳格式。
         * @param check_in_url   非必填，在线值机的链接
         * @param gate           非必填，登机口。如发生登机口变更，建
         *                       议商家实时调用该接口变更。
         * @param boarding_time  非必填，登机时间，只显示“时分”不显
         *                       示日期，按时间戳格式填写。如
         *                       发生登机时间变更， 建议商家实
         *                       时调用该接口变更。
         * @param air_model      非必填，机型，上限为 8 个汉字
         */
        public BoardingPass(BaseInfo base_info, String form, String to, String flight, long departure_time, long landing_time, String check_in_url, String gate, long boarding_time, String air_model) {
            this();
            this.base_info = base_info;
            this.form = form;
            this.to = to;
            this.flight = flight;
            this.departure_time = departure_time;
            this.landing_time = landing_time;
            this.check_in_url = check_in_url;
            this.gate = gate;
            this.boarding_time = boarding_time;
            this.air_model = air_model;
        }

        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }

        public String getForm() {
            return form;
        }

        public void setForm(String form) {
            this.form = form;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getFlight() {
            return flight;
        }

        public void setFlight(String flight) {
            this.flight = flight;
        }

        public long getDeparture_time() {
            return departure_time;
        }

        public void setDeparture_time(long departure_time) {
            this.departure_time = departure_time;
        }

        public long getLanding_time() {
            return landing_time;
        }

        public void setLanding_time(long landing_time) {
            this.landing_time = landing_time;
        }

        public String getCheck_in_url() {
            return check_in_url;
        }

        public void setCheck_in_url(String check_in_url) {
            this.check_in_url = check_in_url;
        }

        public String getGate() {
            return gate;
        }

        public void setGate(String gate) {
            this.gate = gate;
        }

        public long getBoarding_time() {
            return boarding_time;
        }

        public void setBoarding_time(long boarding_time) {
            this.boarding_time = boarding_time;
        }

        public String getAir_model() {
            return air_model;
        }

        public void setAir_model(String air_model) {
            this.air_model = air_model;
        }
    }

    /**
     * 红包
     */
    public static class LucklyMoney extends AbstractCard {
        private BaseInfo base_info;

        public LucklyMoney() {

        }

        public LucklyMoney(BaseInfo base_info) {
            this();
            this.base_info = base_info;
        }

        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }
    }


    /**
     * 会议门票
     */
    public static class MeetingTicket extends AbstractCard {
        private String metting_detail;
        private String map_url;
        private BaseInfo base_info;

        public MeetingTicket() {
        }


        /**
         * @param metting_detail 会议详情
         * @param map_url        非必填，会场导览图
         * @param base_info
         */
        public MeetingTicket(String metting_detail, String map_url, BaseInfo base_info) {
            this();
            this.metting_detail = metting_detail;
            this.map_url = map_url;
            this.base_info = base_info;
        }

        public String getMetting_detail() {
            return metting_detail;
        }

        public void setMetting_detail(String metting_detail) {
            this.metting_detail = metting_detail;
        }

        public String getMap_url() {
            return map_url;
        }

        public void setMap_url(String map_url) {
            this.map_url = map_url;
        }

        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }
    }

    /**
     * 卡券基本信息
     */
    public static class BaseInfo {


        public BaseInfo() {

        }


        /**
         * @param logo_url             卡券的商户 logo，尺寸为
         *                             300*300。
         * @param brand_name           商户名字,字数上限为 12 个汉字。
         *                             （填写直接提供服务的商户名，
         *                             第三方商户名填写在 source 字
         *                             段）
         * @param code_type            code 码展示类型。
         *                             "CODE_TYPE_TEXT"，文本；
         *                             "CODE_TYPE_BARCODE"， 一维
         *                             码 ；
         *                             "CODE_TYPE_QRCODE"，二维
         *                             码；
         *                             “CODE_TYPE_ONLY_QRCOD
         *                             E”,二维码无 code 显示；
         *                             “CODE_TYPE_ONLY_BARCO
         *                             DE”,一维码无 code 显示；
         * @param title                券名，字数上限为 9 个汉字。(建
         *                             议涵盖卡券属性、服务及金额)
         * @param sub_title            券名的副标题， 字数上限为 18 个
         *                             汉字。
         * @param color                券颜色。按色彩规范标注填写   Color010-Color100
         * @param notice               使用提醒，字数上限为 12 个汉
         *                             字。（一句话描述，展示在首页
         *                             示例：请出示二维码核销卡券）
         * @param service_phone        客服电话。
         * @param description          使用说明。长文本描述，可以分
         *                             行，上限为 1000 个汉字。
         * @param get_limit            每人最大领取次数，不填写默认
         *                             等于 quantity。
         * @param use_custom_code      是否自定义 code 码。填写 true
         *                             或 false，不填代表默认为 false。
         *                             该字段需单独申请权限，详情见
         *                             三、开发者必读。
         * @param bind_openid          是否指定用户领取，填写 true 或
         *                             false。不填代表默认为否。
         * @param can_share            领取卡券原生页面是否可分享，
         *                             填写 true 或 false，true 代表可
         *                             分享。默认为 true。
         * @param can_give_friend      卡券是否可转赠，填写 true 或
         *                             false,true 代表可转赠。默认为
         *                             true。
         * @param location_id_list     门店位置 ID。商户需在 mp 平台
         *                             上录入门店信息或调用批量导入
         *                             门店信息接口获取门店位置 ID。
         * @param custom_url_name      商户自定义入口名称，与
         *                             custom_url 字段共同使用，长度
         *                             限制在 5 个汉字内。
         * @param custom_url           商户自定义入口跳转外链的地址
         *                             链接,跳转页面内容需与自定义
         *                             cell 名称保持匹配。
         * @param custom_url_sub_title 显示在入口右侧的 tips，长度限
         *                             制在 6 个汉字内。
         * @param promotion_url_name   营销场景的自定义入口。
         * @param promotion_url        入口跳转外链的地址链接。
         * @param source               第三方来源名，例如同程旅游、
         *                             格瓦拉。
         */
        public BaseInfo(String logo_url, String brand_name, String code_type, String title, String sub_title, String color, String notice, String service_phone, String description, DateInfo dateInfo, Integer get_limit, boolean use_custom_code, boolean bind_openid, boolean can_share, boolean can_give_friend, Integer[] location_id_list, String custom_url_name, String custom_url, String custom_url_sub_title, String promotion_url_name, String promotion_url, String source) {

            this.logo_url = logo_url;
            this.brand_name = brand_name;
            this.code_type = code_type;
            this.title = title;
            this.sub_title = sub_title;
            this.color = color;
            this.notice = notice;
            this.service_phone = service_phone;
            this.description = description;
            this.dateInfo = dateInfo;
            this.get_limit = get_limit;
            this.use_custom_code = use_custom_code;
            this.bind_openid = bind_openid;
            this.can_share = can_share;
            this.can_give_friend = can_give_friend;
            this.location_id_list = location_id_list;
            this.custom_url_name = custom_url_name;
            this.custom_url = custom_url;
            this.custom_url_sub_title = custom_url_sub_title;
            this.promotion_url_name = promotion_url_name;
            this.promotion_url = promotion_url;
            this.source = source;
        }

        private String logo_url;
        private String brand_name;
        private String code_type;
        private String title;
        private String sub_title;
        private String color;
        private String notice;
        private String service_phone;
        private String description;

        private DateInfo dateInfo;

        private Integer get_limit;
        private boolean use_custom_code;
        private boolean bind_openid;
        private boolean can_share;
        private boolean can_give_friend;
        private Integer[] location_id_list;
        private String custom_url_name;
        private String custom_url;
        private String custom_url_sub_title;
        private String promotion_url_name;
        private String promotion_url;
        private String source;

        public DateInfo getDateInfo() {
            return dateInfo;
        }

        public void setDateInfo(DateInfo dateInfo) {
            this.dateInfo = dateInfo;
        }

        public String getLogo_url() {

            return logo_url;
        }

        public void setLogo_url(String logo_url) {
            this.logo_url = logo_url;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }

        public String getCode_type() {
            return code_type;
        }

        public void setCode_type(String code_type) {
            this.code_type = code_type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public String getService_phone() {
            return service_phone;
        }

        public void setService_phone(String service_phone) {
            this.service_phone = service_phone;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getGet_limit() {
            return get_limit;
        }

        public void setGet_limit(Integer get_limit) {
            this.get_limit = get_limit;
        }

        public boolean isUse_custom_code() {
            return use_custom_code;
        }

        public void setUse_custom_code(boolean use_custom_code) {
            this.use_custom_code = use_custom_code;
        }

        public boolean isBind_openid() {
            return bind_openid;
        }

        public void setBind_openid(boolean bind_openid) {
            this.bind_openid = bind_openid;
        }

        public boolean isCan_share() {
            return can_share;
        }

        public void setCan_share(boolean can_share) {
            this.can_share = can_share;
        }

        public boolean isCan_give_friend() {
            return can_give_friend;
        }

        public void setCan_give_friend(boolean can_give_friend) {
            this.can_give_friend = can_give_friend;
        }

        public Integer[] getLocation_id_list() {
            return location_id_list;
        }

        public void setLocation_id_list(Integer[] location_id_list) {
            this.location_id_list = location_id_list;
        }

        public String getCustom_url_name() {
            return custom_url_name;
        }

        public void setCustom_url_name(String custom_url_name) {
            this.custom_url_name = custom_url_name;
        }

        public String getCustom_url() {
            return custom_url;
        }

        public void setCustom_url(String custom_url) {
            this.custom_url = custom_url;
        }

        public String getCustom_url_sub_title() {
            return custom_url_sub_title;
        }

        public void setCustom_url_sub_title(String custom_url_sub_title) {
            this.custom_url_sub_title = custom_url_sub_title;
        }

        public String getPromotion_url_name() {
            return promotion_url_name;
        }

        public void setPromotion_url_name(String promotion_url_name) {
            this.promotion_url_name = promotion_url_name;
        }

        public String getPromotion_url() {
            return promotion_url;
        }

        public void setPromotion_url(String promotion_url) {
            this.promotion_url = promotion_url;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public static class DateInfo {
            private Integer type;
            private long begin_timestamp;
            private long end_timestamp;

            public DateInfo() {
            }

            public DateInfo(Integer type, long begin_timestamp, long end_timestamp) {
                this.type = type;
                this.begin_timestamp = begin_timestamp;
                this.end_timestamp = end_timestamp;
            }

            public Integer getType() {
                return type;
            }

            public void setType(Integer type) {
                this.type = type;
            }

            public long getBegin_timestamp() {
                return begin_timestamp;
            }

            public void setBegin_timestamp(long begin_timestamp) {
                this.begin_timestamp = begin_timestamp;
            }

            public long getEnd_timestamp() {
                return end_timestamp;
            }

            public void setEnd_timestamp(long end_timestamp) {
                this.end_timestamp = end_timestamp;
            }
        }
    }


}
