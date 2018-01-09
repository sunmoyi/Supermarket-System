package Dao;

import JavaBean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDao extends BaseDao {
    public boolean addEmployee(Employee employee){
        String sql = "insert into Employee (employeeId, employeeName, employeePhone, employeePosition, employeesex) value(?, ?, ?, ?, ?)";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, employee.getEmployeeId());
            pstmt.setString(2, employee.getEmployeeName());
            pstmt.setString(3, employee.getEmployeePhone());
            pstmt.setString(4, employee.getEmployeePosition());
            pstmt.setString(5, employee.getEmployeeSex());
            return pstmt.executeUpdate() == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmoloyee(String employeeId){
        String sql = "delete from Employee where employeeId" + employeeId;
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateEmployee(Employee employee){
        String sql = "update Employee set employeeName = ?, employeePhone = ?, employeePosition = ?, employeeSex = ? where employeeId = ?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, employee.getEmployeeName());
            pstmt.setString(2, employee.getEmployeePhone());
            pstmt.setString(3, employee.getEmployeePosition());
            pstmt.setString(4, employee.getEmployeeSex());
            pstmt.setString(5, employee.getEmployeeId());
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Employee> findAllEmployee(){
        String sql = "select * from Employee";
        ArrayList<Employee> arr = new ArrayList<Employee>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(rst.getString("employeeId"));
                employee.setEmployeeName(rst.getString("employeeName"));
                employee.setEmployeePhone(rst.getString("employeePhone"));
                employee.setEmployeePosition(rst.getString("employeePosition"));
                employee.setEmployeeSex(rst.getString("employeeSex"));
                arr.add(employee);
            }
            return arr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Employee findAccountById(String employeeId){
        String sql = "select * from Employee where employeeId="  + employeeId;
        Employee employee = new Employee();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                employee.setEmployeeId(rst.getString("employeeId"));
                employee.setEmployeeName(rst.getString("employeeName"));
                employee.setEmployeePhone(rst.getString("employeePhone"));
                employee.setEmployeePosition(rst.getString("employeePosition"));
                employee.setEmployeeSex(rst.getString("employeeSex"));
                return employee;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
