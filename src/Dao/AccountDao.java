package Dao;

import JavaBean.Account;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class AccountDao extends BaseDao {
    public boolean testPasswod(String name, String password){
        String sql = "select * from Account where employeeId = " +  name ;
        Account account = new Account();
        System.out.println(sql);
        try{
            Connection conn = getConnection();
            Statement petmt = conn.createStatement();
            ResultSet resultSet = petmt.executeQuery(sql);
            if(resultSet.next() && resultSet.getString("password").equals(password)) {
                account.setEmployeeId(resultSet.getString("employeeId"));
                account.setPassword(resultSet.getString("password"));
                account.setLastLogin(new Date().toString());
                updateAccount(account);
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean addAccount(Account account){
        String sql = "insert into Account(password, employeeId, lastLogin) values(?, ?, ?)";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.getPassword());
            pstmt.setString(2, account.getEmployeeId());
            pstmt.setString(3, account.getLastLogin());
            int influen = pstmt.executeUpdate();
            return influen == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAccount(Account account){
        String sql = "update Account set password = ?, lastLogin = ? where employeeId = ?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.getPassword());
            pstmt.setString(3, account.getEmployeeId());
            pstmt.setString(2, account.getLastLogin());
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAccount(String employeeId){
        String sql = "delete from Account where employeeId = " + employeeId;
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Account> findAllAccount(){
        String sql = "select * from Account";
        ArrayList<Account> arr = new ArrayList<Account>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                Account account = new Account();
                account.setEmployeeId(rst.getString("EmployeeId"));
                account.setPassword(rst.getString("Password"));
                account.setLastLogin(rst.getString("LastLogin"));
                arr.add(account);
            }
            return arr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Account findAccountById(String employeeId){
        String sql = "select * from Account where employeeId="  + employeeId;
        Account account = new Account();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                account.setEmployeeId(rst.getString("employeeId"));
                account.setPassword(rst.getString("password"));
                account.setLastLogin(rst.getString("lastLogin"));
                return account;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
