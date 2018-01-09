package servlet;

import Dao.NewsDao;
import JavaBean.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NewsPageAdd")
public class NewsPageAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getQueryString());
        String ID = req.getParameter("ID");
        String Title = req.getParameter("Title");
        String Body = req.getParameter("Body");
        News news = new News();
        news.setNewsId(Integer.parseInt(ID));
        news.setNewsTitle(Title);
        news.setNewsBody(Body);
        new NewsDao().addENews(news);
        req.getRequestDispatcher("/NewsPage").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
