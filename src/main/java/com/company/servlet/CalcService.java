package com.company.servlet;

import java.util.List;

public class CalcService {


    public Object calculator(String num1, String num2, String operation, User user, List<Operation> history) {
        if (operation.equals("sum")) {
            String i = String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
            history.add(new Operation(num1, num2, operation, i, user));
            return i;
        }
        if (operation.equals("sub")) {
            String i = String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2));
            history.add(new Operation(num1, num2, operation, i, user));
            return i;
        }
        if (operation.equals("mod")) {
            String i = String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
            history.add(new Operation(num1, num2, operation, i, user));
            return i;
        }
        if (operation.equals("div")) {
            String i = String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2));
            history.add(new Operation(num1, num2, operation, i, user));
            return i;
        }
        return null;
    }


}
