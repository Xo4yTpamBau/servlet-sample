package com.company.servlet;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final static List<User> allUSer = new ArrayList<>();

    public void save(int id, String name, String login, String password){
        allUSer.add(new User(id, name,login, password));
    }

    public User getById(int id){
        for (User user : allUSer) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getByLogin(String login){
        for (User user : allUSer) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    public boolean containsByLogin(String login){
        for (User user : allUSer) {
            if (user.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public void updateName (int id, String newName){
        for (User user : allUSer) {
            if (user.getId() == id) {
                user.setName(newName);
            }
        }
    }

    public void updateLogin(int id, String newLogin){
        for (User user : allUSer) {
            if (user.getId() == id) {
                user.setLogin(newLogin);
            }
        }
    }
    public void updatePassword(int id, String newPassword){
        for (User user : allUSer) {
            if (user.getId() == id) {
                user.setPassword(newPassword);
            }
        }
    }
}
