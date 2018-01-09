package JavaBean;

public class Jurisdiction {
    private String employeeId;
    private boolean showGoods;
    private boolean updateGoodsNum;
    private boolean admin;
    private boolean updateGoods;
    private boolean postNews;
    private boolean charge;
    private boolean changePrice;

    public Jurisdiction(){
        showGoods = false;
        updateGoods = false;
        admin = false;
        updateGoods = false;
        postNews = false;
        charge = false;
        changePrice = false;
    }

    public boolean isChangePrice() {
        return changePrice;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isCharge() {
        return charge;
    }

    public boolean isPostNews() {
        return postNews;
    }

    public boolean isShowGoods() {
        return showGoods;
    }

    public boolean isUpdateGoods() {
        return updateGoods;
    }

    public boolean isUpdateGoodsNum() {
        return updateGoodsNum;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setChangePrice(boolean changePrice) {
        this.changePrice = changePrice;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public void setPostNews(boolean postNews) {
        this.postNews = postNews;
    }

    public void setShowGoods(boolean showGoods) {
        this.showGoods = showGoods;
    }

    public void setUpdateGoods(boolean updateGoods) {
        this.updateGoods = updateGoods;
    }

    public void setUpdateGoodsNum(boolean updateGoodsNum) {
        this.updateGoodsNum = updateGoodsNum;
    }

}
