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

@WebServlet("/EmployeeChange")
public class EmployeeChange extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println(req.getQueryString());
        String Password = req.getParameter("Password");
        String EmployeePosition = req.getParameter("EmployeePosition");
        String EmployeeName = req.getParameter("EmployeeName");
        String EmployeePhone = req.getParameter("EmployeePhone");
        String EmployeeSex = req.getParameter("EmployeeSex");
        System.out.println(EmployeeSex);
        Account account = (Account) req.getSession().getAttribute("account");
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        account.setPassword(Password);
        employee.setEmployeeSex(EmployeeSex);
        employee.setEmployeePosition(EmployeePosition);
        employee.setEmployeePhone(EmployeePhone);
        employee.setEmployeeName(EmployeeName);
        AccountDao accountDao = new AccountDao();
        accountDao.updateAccount(account);
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.updateEmployee(employee);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
