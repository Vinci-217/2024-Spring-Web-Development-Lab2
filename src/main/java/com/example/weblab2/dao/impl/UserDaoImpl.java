package com.example.weblab2.dao.impl;

import com.example.weblab2.dao.UserDao;
import com.example.weblab2.entity.Student;
import com.example.weblab2.entity.User;
import com.example.weblab2.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        try {
            DBUtil dbUtil=new DBUtil();
            String username=user.getUsername();
            String password= user.getPassword();
            String sql="INSERT INTO user(username,password) VALUES('"+username+"','"+password+"')";
            dbUtil.executeUpdate(sql);
            dbUtil.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(User user) {
        try {
            DBUtil dbUtil=new DBUtil();
            String username=user.getUsername();
            String sql="DELETE FROM user WHERE username='"+username+"'";
            dbUtil.executeUpdate(sql);
            dbUtil.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void modify(User user) {
        try {
            DBUtil dbUtil=new DBUtil();
            String username=user.getUsername();
            String password= user.getPassword();
            String sql="UPDATE user SET username='"+username+"', password='"+password+"'";
            dbUtil.executeUpdate(sql);
            dbUtil.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User getById(User user) {
        User user1=new User();
        try {
            DBUtil dbUtil=new DBUtil();
            String sql="SELECT * FROM user WHERE username='"+user.getUsername()+"'";
            ResultSet resultSet= dbUtil.executeQuery(sql);
            String username=resultSet.getString("username");
            String password=resultSet.getString("password");
            user1.setUsername(username);
            user1.setPassword(password);
            dbUtil.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user1;
    }

    @Override
    public boolean validateUser(String username, String password) {
        try {
            DBUtil dbUtil = new DBUtil();
            String sql = "SELECT COUNT(1) FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            //这里由于我的数据库表里面有一个user表了，并且似乎是隐藏的删除不掉，所以这里就暂时先用users代替
            ResultSet resultSet = dbUtil.executeQuery(sql);
            System.out.println(sql);
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
            dbUtil.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return false;
    }


}
