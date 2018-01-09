package servlet;

import Dao.AccountDao;
import Dao.EmployeeDao;
import Dao.JurisdictionDao;
import JavaBean.AccEmJur;
import JavaBean.Account;
import JavaBean.Employee;
import JavaBean.Jurisdiction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/EmployeeInfo")
public class EmployeeInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean test = (boolean)req.getSession().getAttribute("admin");
        if(!test)
            req.getRequestDispatcher("/NoJurisdiction.jsp").forward(req, resp);
        EmployeeDao employeeDao = new EmployeeDao();
        AccountDao accountDao = new AccountDao();
        JurisdictionDao jurisdictionDao = new JurisdictionDao();

        ArrayList<Employee> find = employeeDao.findAllEmployee();
        ArrayList<AccEmJur> ans = new ArrayList<AccEmJur>();
        for(Employee employee: find){
            String employeeid = employee.getEmployeeId();
            System.out.println(employeeid);
            Account account = accountDao.findAccountById(employeeid);
            Jurisdiction jurisdiction = jurisdictionDao.findJurisdictionById(employeeid);
            AccEmJur accEmJur = new AccEmJur();
            accEmJur.setAdmin(jurisdiction.isAdmin());
            accEmJur.setCharge(jurisdiction.isCharge());
            accEmJur.setChargePrice(jurisdiction.isChangePrice());
            accEmJur.setEmployeeId(account.getEmployeeId());
            accEmJur.setEmployeeName(employee.getEmployeeName());
            accEmJur.setEmployeePhone(employee.getEmployeePhone());
            accEmJur.setEmployeePositior(employee.getEmployeePosition());
            accEmJur.setEmployeeSex(employee.getEmployeeSex());
            accEmJur.setLastLogin(account.getLastLogin());
            accEmJur.setPassword(account.getPassword());
            accEmJur.setPostNews(jurisdiction.isPostNews());
            accEmJur.setShowGoods(jurisdiction.isShowGoods());
            accEmJur.setUpdateGoods(jurisdiction.isUpdateGoods());
            accEmJur.setUpdateGoodsNum(jurisdiction.isUpdateGoodsNum());
            ans.add(accEmJur);
        }
        req.getSession().setAttribute("EmployeeInfo", ans);
        req.getRequestDispatcher("/EmployeeInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
