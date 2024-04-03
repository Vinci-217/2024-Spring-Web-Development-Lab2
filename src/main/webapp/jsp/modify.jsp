<%@ page import="com.example.weblab2.entity.Student" %>
<%@ page import="com.example.weblab2.dao.StudentDao" %>
<%@ page import="com.example.weblab2.dao.impl.StudentDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
    String sid=request.getParameter("sid");
    StudentDao studentDao= new  StudentDaoImpl();
    Student student=studentDao.getById(sid);

%>
<div class="container mt-3">
    <h2>修改学生</h2>
    <form action="/web_lab2_war_exploded/StudentServlet" method="post">
        <input type="hidden" name="action" value="modify">
        <table class="table mt-3">
            <tbody>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="sid" readonly value="<%=sid%>"></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name" value="<%=student.getName()%>"></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><select name="gender">
                    <option value="m" <%
                        if(student.getGender().equals('m'))
                            out.print("selected=\"selected\"");
                    %>>男</option>
                    <option value="f" <%
                        if(student.getGender().equals('f'))
                             out.print("selected=\"selected\"");
                    %>>女</option>
                </select></td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td><input type="number" name="age" value="<%=student.getAge()%>"></td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><input type="date" name="birthday" value="<%=student.getBirthday()%>"></td>
            </tr>

            </tbody>
        </table>
        <input type="submit" value="提交" class="btn btn-success">
    </form>
</div>
</body>
</html>
