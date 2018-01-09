package servlet;

import Dao.AccountDao;
import Dao.EmployeeDao;
import Dao.JurisdictionDao;
import JavaBean.Account;
import JavaBean.Jurisdiction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getQueryString());
        String EmplpyeeId = (String)req.getParameter("EmployeeId");
        String Password = (String)req.getParameter("Password");
        System.out.println(EmplpyeeId);
        AccountDao accountDao = new AccountDao();
        boolean success = accountDao.testPasswod(EmplpyeeId, Password);
        if(success){
            req.getSession().setAttribute("error", "");
            req.getSession().setAttribute("EmployeeId", EmplpyeeId);
            JurisdictionDao jurisdictionDao = new JurisdictionDao();
            Jurisdiction jurisdiction = jurisdictionDao.findJurisdictionById(EmplpyeeId);
            req.getSession().setAttribute("showGoods", jurisdiction.isShowGoods());
            req.getSession().setAttribute("admin", jurisdiction.isAdmin());
            req.getSession().setAttribute("changePrice", jurisdiction.isChangePrice());
            req.getSession().setAttribute("charge", jurisdiction.isCharge());
            req.getSession().setAttribute("postNews", jurisdiction.isPostNews());
            System.out.println(jurisdiction.isPostNews());
            req.getSession().setAttribute("updateGoods", jurisdiction.isUpdateGoods());
            req.getSession().setAttribute("updateGoodsNum", jurisdiction.isUpdateGoodsNum());
            resp.sendRedirect("/index");
        }else {
            req.getSession().setAttribute("error", "用户名或密码错误");
            resp.sendRedirect("/Login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
