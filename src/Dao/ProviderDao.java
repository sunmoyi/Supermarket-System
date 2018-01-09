package Dao;

import JavaBean.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProviderDao extends BaseDao {
    public boolean addProvider(Provider provider){
        String sql = "insert into Provider (providerId, providerName, providerLocation, providerPhone) value(?, ?, ?, ?)";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, provider.getProviderId());
            pstmt.setString(2, provider.getProviderName());
            pstmt.setString(3, provider.getProviderLocation());
            pstmt.setString(4, provider.getProviderPhone());
            return pstmt.executeUpdate() == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProvider(String providerId){
        String sql = "delete from Provider where providerId" + providerId;
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProvider(Provider provider){
        String sql = "update Provider set providerLocation = ?, providerName = ?, providerPhone = ? where providerId = ?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, provider.getProviderLocation());
            pstmt.setString(2, provider.getProviderName());
            pstmt.setString(3, provider.getProviderPhone());
            pstmt.setString(4, provider.getProviderId());
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Provider> findAllprovider(){
        String sql = "select * from Provider";
        ArrayList<Provider> arr = new ArrayList<Provider>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                Provider provider = new Provider();
                provider.setProviderLocation(rst.getString("providerLocation"));
                provider.setProviderName(rst.getString("providerName"));
                provider.setProviderPhone(rst.getString("providerPhone"));
                provider.setProviderId(rst.getString("providerId"));
                arr.add(provider);
            }
            return arr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
