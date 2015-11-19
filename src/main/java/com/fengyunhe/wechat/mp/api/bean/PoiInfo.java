package com.fengyunhe.wechat.mp.api.bean;

import java.util.List;

/**
 * 门店（POI）信息对象
 * Created by yangyan on 2015/6/2.
 */
public class PoiInfo {

    public PoiInfo() {
    }

    public PoiInfo(Business business) {
        this.business = business;
    }

    private Business business;


    public static class Business {

        private BaseInfo base_info;

        public Business() {
        }

        public Business(BaseInfo base_info) {
            this.base_info = base_info;
        }

        public static class BaseInfo {

            /**
             * @param sid           非必填，商户自己的 id，用于后续审核通过收到 poi_id 的通知时，做对应关系。请商户自己保证唯一识别性
             * @param business_name 必填，门店名称（仅为商户名，如：国美、麦当劳，不应包含地区、店号等信息，错误示例：北京国美）
             * @param branch_name   非必填，分店名称（不应包含地区信息、不应与门店名重复，错误示例：北京王府井店）
             * @param province      必填，门店所在的省份（直辖市填城市名,如：北京市）
             * @param city          必填，门店所在的城市
             * @param district      非必填，门店所在地区
             * @param address       必填，门店所在的详细街道地址（不要填写省市信息）
             * @param telephone     必填，门店的电话（纯数字，区号、分机号均由“-”隔开）
             * @param categories    必填，门店的类型（详细分类参见分类附表，不同级分类用“,”隔开，如：美食，川菜，火锅）
             * @param offset_type   必填，坐标类型，1 为火星坐标（目前只能选 1）
             * @param longitude     必填，门店所在地理位置的经度
             * @param latitude      必填，门店所在地理位置的纬度（经纬度均为火星坐标，最好选用腾讯地图标记的坐标）
             * @param photo_list    必填，图片列表，url 形式，可以有多张图片，尺寸为640*340px。必须为上一接口生成的 url
             * @param recommend     非必填，推荐品，餐厅可为推荐菜；酒店为推荐套房；景点为推荐游玩景点等，针对自己行业的推荐内容
             * @param special       必填，特色服务，如免费 wifi，免费停车，送货上门等商户能提供的特色功能或服务
             * @param introduction  非必填，商户简介，主要介绍商户信息等
             * @param open_time     必填，营业时间，24 小时制表示，用“-”连接，如8:00-20:00
             * @param avg_price     非必填，人均价格，大于 0 的整数
             */
            public BaseInfo(String sid, String business_name, String branch_name, String province, String city, String district, String address, String telephone, List<String> categories, Integer offset_type, Float longitude, Float latitude, List<Photo> photo_list, String recommend, String special, String introduction, String open_time, Integer avg_price) {
                this.sid = sid;
                this.business_name = business_name;
                this.branch_name = branch_name;
                this.province = province;
                this.city = city;
                this.district = district;
                this.address = address;
                this.telephone = telephone;
                this.categories = categories;
                this.offset_type = offset_type;
                this.longitude = longitude;
                this.latitude = latitude;
                this.photo_list = photo_list;
                this.recommend = recommend;
                this.special = special;
                this.introduction = introduction;
                this.open_time = open_time;
                this.avg_price = avg_price;
            }

            public BaseInfo() {
            }

            /**
             * 非必填，商户自己的 id，用于后续审核通过收到 poi_id 的通知时，做对应关系。请商户自己保证唯一识别性
             */
            private String sid = "33788392";
            /**
             * 必填，门店名称（仅为商户名，如：国美、麦当劳，不应包含地区、店号等信息，错误示例：北京国美）
             */
            private String business_name = "麦当劳";
            /**
             * 非必填，分店名称（不应包含地区信息、不应与门店名重复，错误示例：北京王府井店）
             */
            private String branch_name = "艺苑路店";

            /**
             * 必填，门店所在的省份（直辖市填城市名,如：北京市）
             */
            private String province = "广东省";

            /**
             * 必填，门店所在的城市
             */
            private String city = "广州市";

            /**
             * 非必填，门店所在地区
             */
            private String district = "海珠区";
            /**
             * 必填，门店所在的详细街道地址（不要填写省市信息）
             */
            private String address = "艺苑路 11 号"; //（不要填写省市信息）

            /**
             * 必填，门店的电话（纯数字，区号、分机号均由“-”隔开）
             */
            private String telephone = "020-12345678";
            /**
             * 必填，门店的类型（详细分类参见分类附表，不同级分类用“,”隔开，如：美食，川菜，火锅）
             */
            private List<String> categories;
            /**
             * 必填，坐标类型，1 为火星坐标（目前只能选 1）
             */
            private Integer offset_type = 1;
            /**
             * 必填，门店所在地理位置的经度
             */
            private Float longitude = 15.32375F;
            /**
             * 必填，门店所在地理位置的纬度（经纬度均为火星坐标，最好选用腾讯地图标记的坐标）
             */
            private Float latitude = 5.097486F;
            /**
             * 必填，图片列表，url 形式，可以有多张图片，尺寸为640*340px。必须为上一接口生成的 url
             */
            private List<Photo> photo_list = null; //640*340
            /**
             * 非必填，推荐品，餐厅可为推荐菜；酒店为推荐套房；景点为推荐游玩景点等，针对自己行业的推荐内容
             */
            private String recommend = "麦辣鸡腿堡套餐，麦乐鸡，全家桶";
            /**
             * 必填，特色服务，如免费 wifi，免费停车，送货上门等商户能提供的特色功能或服务
             */
            private String special = "免费 wifi，外卖服务";
            /**
             * 非必填，商户简介，主要介绍商户信息等
             */
            private String introduction = "麦当劳是全球大型跨国连锁餐厅，1940 年创立于美国，在世界上大约拥有 3 万间分店。主要售卖汉堡包，以及薯条、炸鸡、汽水、冰品、沙拉、水果等 ";
            /**
             * 必填，营业时间，24 小时制表示，用“-”连接，如8:00-20:00
             */
            private String open_time = "8:00-20:00";
            /**
             * 非必填，人均价格，大于 0 的整数
             */
            private Integer avg_price;


            /**
             * 查询时返回，门店是否可用状态。1 表示系统错误、2 表示审核中、3 审核通过、 4 审核驳回。当该字段为 1、2、4 状态时，poi_id 为空
             */
            private Integer available_state;


            /**
             * 查询时返回，扩展字段是否正在更新中。1 表示扩展字段正在更新中，尚未生效，不允许再次更新； 0 表示扩展字段没有在更新中或更新已生效，可以再次更新
             */
            private Integer update_status;

            /**
             * 创建时请不要设置，仅用于用API查询使用
             *
             * @param update_status
             */
            public void setUpdate_status(Integer update_status) {
                this.update_status = update_status;
            }

            /**
             * 创建时请不要设置，仅用于用API查询使用
             *
             * @param available_state
             */
            public void setAvailable_state(Integer available_state) {
                this.available_state = available_state;
            }

            public Integer getUpdate_status() {
                return update_status;
            }

            public Integer getAvailable_state() {
                return available_state;
            }

            public static class Photo {
                private String photo_url;

                public Photo(String photo_url) {
                    this.photo_url = photo_url;
                }

                public String getPhoto_url() {
                    return photo_url;
                }

                public void setPhoto_url(String photo_url) {
                    this.photo_url = photo_url;
                }
            }

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public String getBusiness_name() {
                return business_name;
            }

            public void setBusiness_name(String business_name) {
                this.business_name = business_name;
            }

            public String getBranch_name() {
                return branch_name;
            }

            public void setBranch_name(String branch_name) {
                this.branch_name = branch_name;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public List<String> getCategories() {
                return categories;
            }

            public void setCategories(List<String> categories) {
                this.categories = categories;
            }

            public Integer getOffset_type() {
                return offset_type;
            }

            public void setOffset_type(Integer offset_type) {
                this.offset_type = offset_type;
            }

            public Float getLongitude() {
                return longitude;
            }

            public void setLongitude(Float longitude) {
                this.longitude = longitude;
            }

            public Float getLatitude() {
                return latitude;
            }

            public void setLatitude(Float latitude) {
                this.latitude = latitude;
            }

            public List<Photo> getPhoto_list() {
                return photo_list;
            }

            public void setPhoto_list(List<Photo> photo_list) {
                this.photo_list = photo_list;
            }

            public String getRecommend() {
                return recommend;
            }

            public void setRecommend(String recommend) {
                this.recommend = recommend;
            }

            public String getSpecial() {
                return special;
            }

            public void setSpecial(String special) {
                this.special = special;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getOpen_time() {
                return open_time;
            }

            public void setOpen_time(String open_time) {
                this.open_time = open_time;
            }

            public Integer getAvg_price() {
                return avg_price;
            }

            public void setAvg_price(Integer avg_price) {
                this.avg_price = avg_price;
            }
        }


        public BaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfo base_info) {
            this.base_info = base_info;
        }
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }


//    {"business ":{
//        "base_info":{
//            "sid":"33788392",
//                    "business_name":"麦当劳",
//                    "branch_name":"艺苑路店",
//                    "province":"广东省",
//                    "city":"广州市",
//                    "district":"海珠区",
//                    "address":"艺苑路 11 号",
//                    "telephone":"020-12345678",
//                    "categories":["美食,快餐小吃"],
//            "offset_type":1,
//                    "longitude":115.32375,
//                    "latitude":25.097486,
//                    "photo_list":[{"photo_url":"https:// XXX.com"}，{"photo_url":"https://
//                XXX.com"}],
//                "recommend":"麦辣鸡腿堡套餐，麦乐鸡，全家桶",
//                        "special":"免费 wifi，外卖服务",
//                        "introduction":"麦当劳是全球大型跨国连锁餐厅，1940 年创立于美国，在世界上
//                大约拥有 3 万间分店。主要售卖汉堡包，以及薯条、炸鸡、汽水、冰品、沙拉、水果等
//                快餐食品",
//                "open_time":"8:00-20:00",
//                        "avg_price":35
//            }
//        }
//    }
}
