package Dao;

import JavaBean.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GoodsDao extends BaseDao {
    public boolean addEGoods(Goods goods){
        String sql = "insert into Goods (providerId, goodsId, goodsName, goodsNumber, goodsPrice) value(?, ?, ?, ?, ?)";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, goods.getProviderId());
            pstmt.setString(2, goods.getGoodsId());
            pstmt.setString(3, goods.getGoodsName());
            pstmt.setInt(4, goods.getGoodsNumber());
            pstmt.setDouble(5, goods.getGoodsPrice());
            return pstmt.executeUpdate() == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteGoods(String goodId){
        String sql = "delete from Goods where goodsId" + goodId;
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateGoods(Goods goods){
        String sql = "update Goods set providerId = ?, goodsPrice = ?, goodsNumber = ?, goodsName = ? where goodsId = ?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, goods.getProviderId());
            pstmt.setDouble(2, goods.getGoodsPrice());
            pstmt.setInt(3, goods.getGoodsNumber());
            pstmt.setString(4, goods.getGoodsName());
            pstmt.setString(5, goods.getGoodsId());
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Goods> findAllGoods(){
        String sql = "select * from Goods";
        ArrayList<Goods> arr = new ArrayList<Goods>();

        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                Goods goods = new Goods();
                goods.setProviderId(rst.getString("providerId"));
                goods.setGoodsPrice(rst.getDouble("goodsPrice"));
                goods.setGoodsNumber(rst.getInt("goodsNumber"));
                goods.setGoodsName(rst.getString("goodsName"));
                goods.setGoodsId(rst.getString("goodsId"));
                arr.add(goods);
            }
            return arr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateGoodsNum(String goodsId, int minus){
        String sql = "update Goods set goodsNumber = goodsNumber - " + minus + " where goodsId = " + goodsId;

        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Goods findGoodsById(String GoodsId){
        Goods goods = new Goods();
        String sql = "select * from Goods where goodsId=" + GoodsId;

        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                goods.setProviderId(rst.getString("providerId"));
                goods.setGoodsPrice(rst.getDouble("goodsPrice"));
                goods.setGoodsNumber(rst.getInt("goodsNumber"));
                goods.setGoodsName(rst.getString("goodsName"));
                goods.setGoodsId(rst.getString("goodsId"));
                return goods;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
