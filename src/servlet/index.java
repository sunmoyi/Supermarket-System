package servlet;

import Dao.NewsDao;
import JavaBean.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/index")
public class index extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsDao newsDao = new NewsDao();
        ArrayList<News> ans = new ArrayList<News>();
        ans = newsDao.findAllNews();
        int size = ans.size();
        req.getSession().setAttribute("title1", ans.get(size - 1).getNewsTitle());
        req.getSession().setAttribute("body1", ans.get(size - 1).getNewsBody());

        req.getSession().setAttribute("title2", ans.get(size - 2).getNewsTitle());
        req.getSession().setAttribute("body2", ans.get(size - 2).getNewsBody());

        req.getSession().setAttribute("title3", ans.get(size - 3).getNewsTitle());
        req.getSession().setAttribute("body3", ans.get(size - 3).getNewsBody());

        req.getServletContext().log((String)req.getSession().getAttribute("title1"));
        req.getServletContext().log((String)req.getSession().getAttribute("title2"));
        req.getServletContext().log((String)req.getSession().getAttribute("title3"));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}