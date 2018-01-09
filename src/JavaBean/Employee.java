package JavaBean;

public class Employee {
    private String employeeName;
    private String employeeSex;
    private String employeePosition;
    private String employeePhone;
    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }
}
