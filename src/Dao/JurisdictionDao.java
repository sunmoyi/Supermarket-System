package Dao;

import JavaBean.Jurisdiction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JurisdictionDao extends BaseDao {
    public boolean addJurisdiction(Jurisdiction jurisdiction){
        String sql = "insert into Jurisdiction (employeeId, showGoods, updataGoods, updateGoodsNum, admin, postNews, charge, changePrice) value(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jurisdiction.getEmployeeId());
            pstmt.setBoolean(2, jurisdiction.isShowGoods());
            pstmt.setBoolean(3, jurisdiction.isUpdateGoods());
            pstmt.setBoolean(4, jurisdiction.isUpdateGoodsNum());
            pstmt.setBoolean(5, jurisdiction.isAdmin());
            pstmt.setBoolean(6, jurisdiction.isPostNews());
            pstmt.setBoolean(7, jurisdiction.isCharge());
            pstmt.setBoolean(8, jurisdiction.isChangePrice());
            return pstmt.executeUpdate() == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteJurisdiction(String employeeId){
        String sql = "delete from Jurisdiction where employeeId" + "/'" + employeeId + "/'";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateJurisdiction(Jurisdiction jurisdiction){
        String sql = "update Jurisdiction set showGoods = ?, updataGoods = ?, updateGoodsNum = ?, admin = ?, postNews = ?, charge = ?, changePrice = ? where employeeId = ?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, jurisdiction.isShowGoods());
            pstmt.setBoolean(2, jurisdiction.isUpdateGoods());
            pstmt.setBoolean(3, jurisdiction.isUpdateGoodsNum());
            pstmt.setBoolean(4, jurisdiction.isAdmin());
            pstmt.setBoolean(5, jurisdiction.isPostNews());
            pstmt.setBoolean(6, jurisdiction.isCharge());
            pstmt.setBoolean(7, jurisdiction.isChangePrice());
            pstmt.setString(8, jurisdiction.getEmployeeId());
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Jurisdiction findJurisdictionById(String EmployeeId)
    {
        String sql = "select * from Jurisdiction where employeeId = ?";
        Jurisdiction jurisdiction = new Jurisdiction();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, EmployeeId);
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                jurisdiction.setEmployeeId(rst.getString("employeeId"));
                jurisdiction.setChangePrice(rst.getBoolean("changePrice"));
                jurisdiction.setCharge(rst.getBoolean("charge"));
                jurisdiction.setPostNews(rst.getBoolean("postNews"));
                jurisdiction.setAdmin(rst.getBoolean("admin"));
                jurisdiction.setUpdateGoodsNum(rst.getBoolean("updateGoodsNum"));
                jurisdiction.setUpdateGoods(rst.getBoolean("updataGoods"));
                jurisdiction.setShowGoods(rst.getBoolean("showGoods"));
                return jurisdiction;
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Jurisdiction> findAllJurisdiction(){
        String sql = "select * from Jurisdiction";
        ArrayList<Jurisdiction> arr = new ArrayList<Jurisdiction>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                Jurisdiction jurisdiction = new Jurisdiction();
                jurisdiction.setShowGoods(rst.getBoolean("showGoods"));
                jurisdiction.setUpdateGoods(rst.getBoolean("updataGoods"));
                jurisdiction.setUpdateGoodsNum(rst.getBoolean("updateGoodsNum"));
                jurisdiction.setAdmin(rst.getBoolean("admin"));
                jurisdiction.setPostNews(rst.getBoolean("postNews"));
                jurisdiction.setCharge(rst.getBoolean("charge"));
                jurisdiction.setChangePrice(rst.getBoolean("changePrice"));
                jurisdiction.setEmployeeId(rst.getString("employeeId"));
                arr.add(jurisdiction);
            }
            return arr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
