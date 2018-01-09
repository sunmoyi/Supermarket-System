package JavaBean;

public class Evidence {
    private String customerId;
    private String evidenceTime;
    private double evidencePrice;
    private String goodsIds;
    private String goodsNums;

    public double getEvidencePrice() {
        return evidencePrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setEvidenceTime(String evidenceTime) {
        this.evidenceTime = evidenceTime;
    }

    public String getGoodsIds() {
        return goodsIds;
    }

    public String getGoodsNums() {
        return goodsNums;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setEvidencePrice(double evidencePrice) {
        this.evidencePrice = evidencePrice;
    }

    public String getEvidenceTime() {
        return evidenceTime;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }

    public void setGoodsNums(String goodsNums) {
        this.goodsNums = goodsNums;
    }
}
