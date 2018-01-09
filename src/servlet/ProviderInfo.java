package servlet;

import Dao.ProviderDao;
import JavaBean.Provider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

@WebServlet("/ProviderInfo")
public class ProviderInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean test = (boolean)req.getSession().getAttribute("admin");
        if(!test)
            req.getRequestDispatcher("/NoJurisdiction.jsp").forward(req, resp);
        ArrayList<Provider> ans;
        ProviderDao providerDao = new ProviderDao();

        ans = providerDao.findAllprovider();
        req.getSession().setAttribute("providerinfo", ans);
        System.out.println(ans.size());
        req.getRequestDispatcher("/ProviderInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
