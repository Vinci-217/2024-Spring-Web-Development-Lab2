package com.example.weblab2.dao;

import com.example.weblab2.entity.Student;
import com.example.weblab2.entity.User;

public interface UserDao {
    void add(User user);
    void remove(User user);
    void modify(User user);
    User getById(User user);
    boolean validateUser(String username,String password);

}
