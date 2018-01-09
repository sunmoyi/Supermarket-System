package Dao;

import JavaBean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDao extends BaseDao {
    public boolean addCustomer(Customer customer){
        String sql = "insert into Customer (customerId, customerName, customerSex, customerPhone) value(?, ?, ?, ?)";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getCustomerId());
            pstmt.setString(2, customer.getCustomerName());
            pstmt.setString(3, customer.getCustomerSex());
            pstmt.setString(4, customer.getCustomerPhone());
            return pstmt.executeUpdate() == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletecustomer(String customerId){
        String sql = "delete from Customer where customerId" + customerId;
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCustomer(Customer customer){
        String sql = "update Customer set customerName = ?, customerSex = ?, customerPhone = ? where customerId = ?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getCustomerName());
            pstmt.setString(2, customer.getCustomerSex());
            pstmt.setString(3, customer.getCustomerPhone());
            pstmt.setString(4, customer.getCustomerId());
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Customer> findAllCustomer(){
        String sql = "select * from Customer";
        ArrayList<Customer> arr = new ArrayList<Customer>();

        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                Customer customer = new Customer();
                customer.setCustomerId(rst.getString("customerId"));
                customer.setCustomerName(rst.getString("customerName"));
                customer.setCustomerPhone(rst.getString("customerPhone"));
                customer.setCustomerSex(rst.getString("customerSex"));
                arr.add(customer);
            }
            return arr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
