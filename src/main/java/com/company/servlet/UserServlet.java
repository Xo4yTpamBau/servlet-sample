package com.company.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user", loadOnStartup = 1, name = "UserServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    public void init() throws ServletException {
        System.out.println("User servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object name = req.getSession().getAttribute("name");
        System.out.println(name);

        String id = req.getParameter("id");
        User byId = userService.getById(Integer.parseInt(id));
        resp.getWriter().println(byId);

    }
}
