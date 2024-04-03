package com.example.weblab2.dao.impl;


import com.example.weblab2.dao.StudentDao;
import com.example.weblab2.entity.Student;
import com.example.weblab2.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void add(Student student) {
        try {
            DBUtil dbUtil=new DBUtil();
            String sid=student.getSid();
            String name=student.getName();
            String gender=student.getGender();
            int age=student.getAge();
            String birthday=student.getBirthday();
            String sql="INSERT INTO student(sid,name,gender,age,birthday) VALUES('"+sid+"','"+name+"','"+gender+"','"+age+"','"+birthday+"')";
            dbUtil.executeUpdate(sql);
            dbUtil.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String sid) {
        try {
            DBUtil dbUtil=new DBUtil();
            String sql = "DELETE FROM student WHERE sid = '" + sid + "'";
            dbUtil.executeUpdate(sql);
            dbUtil.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void modify(Student student) {
        try {
            DBUtil dbUtil=new DBUtil();
            String sql = "UPDATE student SET name = '" + student.getName() + "', gender = '" + student.getGender() + "', age = " + student.getAge() + ", birthday = '" + student.getBirthday() + "' WHERE sid = '" + student.getSid() + "'";
            dbUtil.executeUpdate(sql);
            dbUtil.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getById(String sid) {
        Student student=new Student();
        String name, birthday;
        int age;
        String gender;
        try {
            DBUtil dbUtil=new DBUtil();
            String sql = "SELECT * FROM student WHERE sid = '" + sid + "'";
            ResultSet resultSet= dbUtil.executeQuery(sql);

            if (resultSet.next()) {
                name = resultSet.getString("name");
                gender = resultSet.getString("gender");
                birthday = resultSet.getString("birthday");
                age = resultSet.getInt("age");
                student.setSid(sid);
                student.setAge(age);
                student.setBirthday(birthday);
                student.setGender(gender);
                student.setName(name);
            }
            dbUtil.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList=new ArrayList<>();
        String sql="SELECT * from student";
        try {
            DBUtil dbUtil=new DBUtil();
            String sid, name, birthday;
            int age;
            String gender;
            ResultSet resultSet= dbUtil.executeQuery(sql);
            while (resultSet.next())
            {
                sid = resultSet.getString("sid");
                name = resultSet.getString("name");
                gender = resultSet.getString("gender"); // 假设gender列是一个字符类型
                birthday = resultSet.getString("birthday");
                age = resultSet.getInt("age");
                Student student = new Student(sid,name,gender,age,birthday);
                studentList.add(student);
            }
            dbUtil.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return studentList;
    }
}
