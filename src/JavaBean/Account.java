package JavaBean;

public class Account {
    private String password;
    private String employeeId;
    private String lastLogin;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPassword() {
        return password;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
}
