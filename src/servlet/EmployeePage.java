package servlet;

import Dao.AccountDao;
import Dao.EmployeeDao;
import JavaBean.Account;
import JavaBean.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Employee")
public class EmployeePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String EmployeeId = (String)req.getSession().getAttribute("EmployeeId");
        Account account;
        AccountDao accountDao = new AccountDao();
        Employee employee;
        EmployeeDao employeeDao = new EmployeeDao();
        account = accountDao.findAccountById(EmployeeId);
        employee = employeeDao.findAccountById(EmployeeId);
        req.getSession().setAttribute("account", account);
        req.getSession().setAttribute("employee", employee);
        System.out.println(employee.getEmployeeSex());
        req.getRequestDispatcher("/EmployeePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
