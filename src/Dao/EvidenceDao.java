package Dao;

import JavaBean.Evidence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EvidenceDao extends BaseDao {
    public boolean addEvidence(Evidence evidence){
        String sql = "insert into Evidence (customerId, evidenceTime, goodsIds, goodsNums, evidencePrice) value(?, ?, ?, ?, ?)";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, evidence.getCustomerId());
            pstmt.setString(2, evidence.getEvidenceTime());
            pstmt.setString(3, evidence.getGoodsIds());
            pstmt.setString(4, evidence.getGoodsNums());
            pstmt.setDouble(5, evidence.getEvidencePrice());
            return pstmt.executeUpdate() == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Evidence> findAllEvidence(){
        String sql = "select * from Evidence";
        ArrayList<Evidence> arr = new ArrayList<Evidence>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                Evidence evidence = new Evidence();
                evidence.setCustomerId(rst.getString("customerId"));
                evidence.setEvidenceTime(rst.getString("evidenceTime"));
                evidence.setGoodsIds(rst.getString("goodsIds"));
                evidence.setGoodsNums(rst.getString("goodsNums"));
                evidence.setEvidencePrice(rst.getDouble("evidencePrice"));
                arr.add(evidence);
            }
            return arr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
