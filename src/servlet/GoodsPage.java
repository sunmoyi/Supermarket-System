package servlet;

import Dao.GoodsDao;
import JavaBean.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GoodsPage")
public class GoodsPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!(boolean)req.getSession().getAttribute("showGoods"))
            req.getRequestDispatcher("/NoJurisdiction.jsp").forward(req, resp);
        System.out.println(req.getQueryString());
        ArrayList<Goods> ans = new ArrayList<Goods>();
        GoodsDao goodsDao = new GoodsDao();
        ans = goodsDao.findAllGoods();
        req.getSession().setAttribute("Goods", ans);
        req.getRequestDispatcher("/GoodsPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
