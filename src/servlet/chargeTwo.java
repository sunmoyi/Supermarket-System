package servlet;

import Dao.EvidenceDao;
import Dao.GoodsDao;
import JavaBean.Evidence;
import JavaBean.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/chargeTwo")
public class chargeTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getQueryString());
        ArrayList<String> goods = (ArrayList<String>) req.getSession().getAttribute("finalGoods");
        ArrayList<String> number = (ArrayList<String>)req.getSession().getAttribute("finalNumber");
        GoodsDao goodsDao = new GoodsDao();
        Goods god = new Goods();
        for(int i = 0; i < goods.size(); i++){
            String a = goods.get(i);
            String b = number.get(i);
            god = goodsDao.findGoodsById(a);
            god.setGoodsNumber(god.getGoodsNumber() - Integer.parseInt(b));
            goodsDao.updateGoods(god);
        }
        String customerId = (String)req.getSession().getAttribute("customerId");
        String employee = (String)req.getSession().getAttribute("employee");
        System.out.println(req.getSession().getAttribute("sumprice"));
        double money = (Double) req.getSession().getAttribute("sumprice");
        System.out.println(goods.toString());

        Evidence evidence = new Evidence();
        EvidenceDao evidenceDao = new EvidenceDao();
        evidence.setCustomerId(customerId);
        evidence.setEvidenceTime(new Date().toString());
        evidence.setEvidencePrice(money);
        evidence.setGoodsIds(goods.toString());
        evidence.setGoodsNums(number.toString());
        evidenceDao.addEvidence(evidence);
        req.getRequestDispatcher("/chargeInfo").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
