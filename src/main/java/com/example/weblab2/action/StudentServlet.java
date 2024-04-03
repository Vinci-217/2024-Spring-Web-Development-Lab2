package com.example.weblab2.action;

import com.example.weblab2.dao.StudentDao;
import com.example.weblab2.dao.impl.StudentDaoImpl;
import com.example.weblab2.entity.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;


@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // 处理请求体字符编码

        String action = request.getParameter("action");
//        String sid= request.getParameter("sid");

        StudentDao studentDao = new StudentDaoImpl();
//        Student student =studentDao.getById(sid);
//        request.setAttribute("student", student);

        if (action != null) {
            if (action.equals("add")){
                String sid=request.getParameter("sid");
                String name=request.getParameter("name");
                String gender=request.getParameter("gender");
                String age=request.getParameter("age");
                String birthday=request.getParameter("birthday");
                studentDao.add(new Student(sid,name,gender,Integer.valueOf(age),birthday));
            }

            if (action.equals("modify"))
            {
                String sid=request.getParameter("sid");
                String name=request.getParameter("name");
                String gender=request.getParameter("gender");
                String age=request.getParameter("age");
                String birthday=request.getParameter("birthday");
                studentDao.modify(new Student(sid,name,gender,Integer.valueOf(age),birthday));
            }
            if (action.equals("remove")){
                String sid=request.getParameter("sid");
                studentDao.remove(sid);
            }
//            if (action.equals("query"))
//                queryStudents(request, response);
        }

        response.sendRedirect("jsp/student.jsp");
    }


//    private void removeStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String sid = request.getParameter("sid");
//        Student student = new Student();
//        student.setSid(sid);
//        studentDao.remove(student);
//        response.sendRedirect("student.jsp");
//    }
//
//    private void modifyStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Student student = new Student();
//        student.setSid(request.getParameter("sid"));
//        student.setName(request.getParameter("name"));
//        student.setGender(request.getParameter("gender").charAt(0));
//        student.setAge(Integer.parseInt(request.getParameter("age")));
//        student.setBirthday((request.getParameter("birthday")));
//        studentDao.modify(student);
//        response.sendRedirect("student.jsp");
//    }
//
//    private void queryStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Student> students = studentDao.getAll();
//        request.setAttribute("students", students);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/student.jsp");
//        dispatcher.forward(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}