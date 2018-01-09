package servlet;

import Dao.AccountDao;
import Dao.EmployeeDao;
import Dao.JurisdictionDao;
import JavaBean.Account;
import JavaBean.Employee;
import JavaBean.Jurisdiction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EmployeeInfoAdd")
public class EmployeeInfoAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getQueryString());
        String queryString = req.getQueryString();
        Account account = new Account();
        Employee employee = new Employee();
        Jurisdiction jurisdiction = new Jurisdiction();
        account.setEmployeeId(req.getParameter("employeeid"));
        account.setLastLogin(req.getParameter("lastLogin"));
        account.setPassword(req.getParameter("password"));
        employee.setEmployeeId(req.getParameter("employeeid"));
        employee.setEmployeeName(req.getParameter("employeename"));
        employee.setEmployeePhone(req.getParameter("employeephone"));
        employee.setEmployeePosition(req.getParameter("employeeposition"));
        employee.setEmployeeSex(req.getParameter("employeesex"));
        jurisdiction.setShowGoods(queryString.contains("showGoods"));
        jurisdiction.setUpdateGoods(queryString.contains("updateGoods"));
        jurisdiction.setUpdateGoodsNum(queryString.contains("updateGoodsNum"));
        jurisdiction.setAdmin(queryString.contains("admin"));
        jurisdiction.setPostNews(queryString.contains("postNews"));
        jurisdiction.setCharge(queryString.contains("charge"));
        jurisdiction.setChangePrice(queryString.contains("chargePrice"));
        jurisdiction.setEmployeeId(req.getParameter("employeeid"));

        new AccountDao().addAccount(account);
        new EmployeeDao().addEmployee(employee);
        new JurisdictionDao().addJurisdiction(jurisdiction);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}