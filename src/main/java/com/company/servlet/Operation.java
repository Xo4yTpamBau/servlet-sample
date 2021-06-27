package com.company.servlet;

public class Operation {

    private String num1;
    private String num2;
    private String operation;
    private String result;
    private User user;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOp() {
        return operation;
    }

    public void setOp(String operation) {
        this.operation = operation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Operation(String num1, String num2, String operation, String result, User user) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1='" + num1 + '\'' +
                ", num2='" + num2 + '\'' +
                ", operation='" + operation + '\'' +
                ", result='" + result + '\'' +
                ", user=" + user +
                '}';
    }
}

