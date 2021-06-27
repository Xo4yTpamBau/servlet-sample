package com.company.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/changeLogin", name = "ChangeLoginServlet")
public class ChangeLoginServlet extends HttpServlet {
    UserService userService =new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String newLogin = req.getParameter("login");
        userService.updateLogin(user.getId(), newLogin);
    }
}
