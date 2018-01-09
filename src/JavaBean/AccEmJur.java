package JavaBean;

public class AccEmJur {
    private String EmployeeId;
    private String password;
    private String lastLogin;
    private String employeeSex;
    private String employeePositior;
    private String employeePhone;
    private String employeeName;
    private boolean showGoods;
    private boolean updateGoodsNum;
    private boolean admin;
    private boolean updateGoods;
    private boolean postNews;
    private boolean charge;
    private boolean chargePrice;

    public String getEmployeeId() {
        return EmployeeId;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public String getPassword() {
        return password;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public String getEmployeePositior() {
        return employeePositior;
    }

    public boolean isUpdateGoodsNum() {
        return updateGoodsNum;
    }

    public boolean isUpdateGoods() {
        return updateGoods;
    }

    public boolean isShowGoods() {
        return showGoods;
    }

    public boolean isPostNews() {
        return postNews;
    }

    public boolean isCharge() {
        return charge;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isChargePrice() {
        return chargePrice;
    }

    public void setUpdateGoodsNum(boolean updateGoodsNum) {
        this.updateGoodsNum = updateGoodsNum;
    }

    public void setUpdateGoods(boolean updateGoods) {
        this.updateGoods = updateGoods;
    }

    public void setShowGoods(boolean showGoods) {
        this.showGoods = showGoods;
    }

    public void setPostNews(boolean postNews) {
        this.postNews = postNews;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public void setChargePrice(boolean chargePrice) {
        this.chargePrice = chargePrice;
    }

    public void setEmployeePositior(String employeePositior) {
        this.employeePositior = employeePositior;
    }
}
