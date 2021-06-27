package com.company.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/history", name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = (User) req.getSession().getAttribute("user");
            if (user != null) {
                String type = req.getParameter("type");
                String id = req.getParameter("id");
                List<Operation> history = (List<Operation>) req.getSession().getAttribute("history");
                if (type == null & id == null) {
                    for (Operation operation : history) {
                        resp.getWriter().println(operation);
                    }
                } else {
                    for (Operation operation : history) {
                        if (operation.getOp().equals(type)) {
                            resp.getWriter().println(operation);
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid input");
        }

    }
}
