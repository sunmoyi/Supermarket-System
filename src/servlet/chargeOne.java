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
import java.util.Map;

@WebServlet("/chargeOne")
public class chargeOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getQueryString());
        Map<String, String[]> ans = req.getParameterMap();
        System.out.println(ans.size());
        int size = ans.size();
        String customerId = req.getParameter("customerId");
        String employee = req.getParameter("employee");
        double money = 0;
        GoodsDao goodsDao = new GoodsDao();
        ArrayList<String>finalGoods = new ArrayList<String>();
        ArrayList<String>finalNumber = new ArrayList<String>();
        for(int i = 1; i <= (size - 2) / 2; i++)
        {
            String goodstr = "employeeid" + i;
            String numberstr = "password" + i;
            String goods = req.getParameter(goodstr);
            String number = req.getParameter(numberstr);
            finalGoods.add(goods);
            finalNumber.add(number);
            if(goods.equals("0"))
                continue;
            Goods goods1 = goodsDao.findGoodsById(goods);
            money += goods1.getGoodsPrice() * Double.parseDouble(number);
        }
        System.out.println(1);
        req.getSession().setAttribute("customerId", customerId);
        req.getSession().setAttribute("employee", employee);
        req.getSession().setAttribute("finalGoods", finalGoods);
        req.getSession().setAttribute("finalNumber", finalNumber);
        req.getSession().setAttribute("sumprice", money);
        System.out.println(money);
        req.getRequestDispatcher("/cash.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}