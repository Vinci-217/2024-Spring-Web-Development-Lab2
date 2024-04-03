package com.example.weblab2.dao;

import com.example.weblab2.entity.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);
    void remove(String sid);
    void modify(Student student);
    Student getById(String sid);
    List<Student> getAll();
}
