package com.company.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if (!userService.containsByLogin(login)) {
                userService.save(Integer.parseInt(id), name, login, password);
            } else {
                resp.getWriter().println("Invalid login");
            }
        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid input");
        }
    }
}


