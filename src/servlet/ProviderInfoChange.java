package servlet;

import Dao.ProviderDao;
import JavaBean.Provider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/ProviderInfoChange")
public class ProviderInfoChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getQueryString());
        Provider provider = new Provider();
        provider.setProviderId(req.getParameter("providerId"));
        provider.setProviderName(req.getParameter("providerName"));
        provider.setProviderPhone(req.getParameter("providerphone"));
        provider.setProviderLocation(req.getParameter("providerPosition"));

        ProviderDao providerDao = new ProviderDao();
        providerDao.updateProvider(provider);

        req.getRequestDispatcher("/ProviderInfo").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
