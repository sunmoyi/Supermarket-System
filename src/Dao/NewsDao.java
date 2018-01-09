package Dao;

import JavaBean.News;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NewsDao extends BaseDao{
    public boolean addENews(News news){
        String sql = "insert into News (newsId, newsBody, newsTitle) value(?, ?, ?)";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, news.getNewsId());
            pstmt.setString(2, news.getNewsBody());
            pstmt.setString(3, news.getNewsTitle());
            return pstmt.executeUpdate() == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNews(String newsId){
        String sql = "delete from News where newsId" + newsId;
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNews(News news){
        String sql = "update News set newsBody = ?, newsTitle = ? where newsId = ?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, news.getNewsBody());
            pstmt.setString(2, news.getNewsTitle());
            pstmt.setInt(3, news.getNewsId());
            return pstmt.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<News> findAllNews(){
        String sql = "select * from News";
        ArrayList<News> arr = new ArrayList<News>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                News news = new News();
                news.setNewsId(rst.getInt("newsId"));
                news.setNewsBody(rst.getString("newsBody"));
                news.setNewsTitle(rst.getString("newsTitle"));
                arr.add(news);
            }
            return arr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
