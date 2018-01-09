package servlet;

import Dao.GoodsDao;
import JavaBean.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsPageAdd")
public class GoodsPageAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getQueryString());
        Goods goods = new Goods();
        goods.setGoodsId(req.getParameter("goodsid"));
        goods.setProviderId(req.getParameter("providerid"));
        goods.setGoodsPrice(Double.parseDouble(req.getParameter("goodsprice")));
        goods.setGoodsNumber(Integer.parseInt(req.getParameter("goodsnumber")));
        goods.setGoodsName(req.getParameter("goodsname"));
        new GoodsDao().addEGoods(goods);

        req.getRequestDispatcher("/GoodsPage").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
