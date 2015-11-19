package com.fengyunhe.wechat.mp.pay.bean;

/**
 * 原生支付获取package时的信息
 *
 * @author Administrator
 */
public class NativeGetPackage {
    // <xml>
    // <OpenId><![CDATA[111222]]></OpenId>
    // <AppId><![CDATA[wwwwb4f85f3a797777]]></AppId>
    // <IsSubscribe>1</IsSubscribe>
    // <ProductId><![CDATA[777111666]]></ProductId>
    // <TimeStamp> 1369743908</TimeStamp>
    // <NonceStr><![CDATA[YvMZOX28YQkoU1i4NdOnlXB1]]></NonceStr>
    // <AppSignature><![CDATA[a9274e4032a0fec8285f147730d88400392acb9e]]></AppSignat
    // ure>
    // <SignMethod><![CDATA[sha1]]></ SignMethod >
    // </xml>

    private String OpenId;
    private String AppId;
    private Integer IsSubscribe;
    private String ProductId;
    private Integer TimeStamp;
    private String NonceStr;
    private String AppSignature;
    private String SignMethod;

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public Integer getIsSubscribe() {
        return IsSubscribe;
    }

    public void setIsSubscribe(Integer isSubscribe) {
        IsSubscribe = isSubscribe;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public Integer getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getNonceStr() {
        return NonceStr;
    }

    public void setNonceStr(String nonceStr) {
        NonceStr = nonceStr;
    }

    public String getAppSignature() {
        return AppSignature;
    }

    public void setAppSignature(String appSignature) {
        AppSignature = appSignature;
    }

    public String getSignMethod() {
        return SignMethod;
    }

    public void setSignMethod(String signMethod) {
        SignMethod = signMethod;
    }

}
