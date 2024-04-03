package com.example.weblab2.action;

import com.example.weblab2.dao.StudentDao;
import com.example.weblab2.dao.UserDao;
import com.example.weblab2.dao.impl.UserDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String username=request.getParameter("username");
        String password=request.getParameter("password");
//        boolean rememberMe="true".equals(request.getParameter("remember"));

        UserDao userDao=new UserDaoImpl();
        boolean isValidUser=userDao.validateUser(username,password);

        if(isValidUser)
        {
//            if(rememberMe)
//            {
//                Cookie cookieUsername=new Cookie("username",username);
//                Cookie cookiePassword=new Cookie("password",password);
//                cookieUsername.setMaxAge(60*24*7);
//                cookiePassword.setMaxAge(60*24*7);
//
//                cookieUsername.setHttpOnly(true);
//                cookiePassword.setHttpOnly(true);
//                cookieUsername.setPath("/");
//                cookiePassword.setPath("/");
//
//
//                response.addCookie(cookieUsername);
//                response.addCookie(cookiePassword);
//
//            }
            response.getWriter().write("{\"status\":\"success\"}");
        }
        else
        {
            response.getWriter().write("{\"status\":\"error\"}");
        }


    }
}
