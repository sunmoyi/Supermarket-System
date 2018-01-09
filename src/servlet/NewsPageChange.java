package servlet;

import Dao.NewsDao;
import JavaBean.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NewsPageChange")
public class NewsPageChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getQueryString());
        String newsid = req.getParameter("NewsId");
        String title = req.getParameter("Title");
        String newsbody = req.getParameter("News");
        News news = new News();
        news.setNewsId(Integer.parseInt(newsid));
        news.setNewsTitle(title);
        news.setNewsBody(newsbody);
        NewsDao newsDao = new NewsDao();
        newsDao.updateNews(news);
        req.getRequestDispatcher("/NewsPage").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
