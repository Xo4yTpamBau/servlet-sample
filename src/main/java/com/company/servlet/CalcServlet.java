package com.company.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/calc", loadOnStartup = 2, name = "CalcServlet")
public class CalcServlet extends HttpServlet {

    private CalcService calcService = new CalcService();
    //init
    //service
    //destroy

    //servlet context application scope
    //session scope
    //request scope
    //page scope

    @Override
    public void init() throws ServletException {
        System.out.println("Hello Init");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = (User) req.getSession().getAttribute("user");
            if (user != null) {
                String num1 = req.getParameter("num1");
                String num2 = req.getParameter("num2");
                String operation = req.getParameter("operation");
                List<Operation> history = (List<Operation>) req.getSession().getAttribute("history");
                Object calculator = calcService.calculator(num1, num2, operation, user, history);
                resp.getWriter().println(calculator);
            }else {
                resp.getWriter().println("Not authorized");
            }

        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid input");
        }

    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
