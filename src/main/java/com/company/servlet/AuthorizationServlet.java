package com.company.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            User byLogin = null;
            if (userService.containsByLogin(login)) {
                 byLogin = userService.getByLogin(login);
                if (byLogin.getPassword().equals(password)) {
                    req.getSession().setAttribute("user", byLogin);
                    req.getSession().setAttribute("history", new ArrayList<>());
                } else resp.getWriter().println("Invalid password");
            } else {
                resp.getWriter().println("Invalid login");
            }
        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid input");
        }
    }
}


