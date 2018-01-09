package JavaBean;

public class Goods {
    private String goodsName;
    private int goodsNumber;
    private double goodsPrice;
    private String goodsId;
    private String providerId;

    public String getGoodsName() {
        return goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
