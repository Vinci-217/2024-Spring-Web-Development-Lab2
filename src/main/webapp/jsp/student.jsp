<%@ page import="com.example.weblab2.dao.StudentDao" %>
<%@ page import="com.example.weblab2.dao.impl.StudentDaoImpl" %>
<%@ page import="com.example.weblab2.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/Unlogged.js"></script>
</head>
<body>
    <div class="container mt-3">
        <h2>学生列表</h2>
        <table class="table mt-3">
            <thead>
            <tr>
                <td>ID</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>生日</td>
            </tr>

            </thead>
            <tbody>
            <%
                StudentDao studentDao=new StudentDaoImpl();
                List<Student> studentList=studentDao.getAll();

                // 使用 Lambda 表达式创建比较器
                Comparator<Student> comparator = Comparator.comparing(Student::getSid);
                // 使用 Collections.sort() 方法对 studentList 进行排序
                Collections.sort(studentList, comparator);


                for(Student student:studentList)
                {
            %>
            <tr>
                <td><%=
                    student.getSid()
                %></td>
                <td><%=
                    student.getName()
                %></td>
                <td>
                    <%
                        String gender = student.getGender();
                        if (gender.equals("f")) {
                            out.print("女");
                        } else if (gender.equals("m")) {
                            out.print("男");
                        } else {
                            out.print("未知");
                        }
                    %>
                </td>

                <td><%=
                    student.getAge()
                %></td>
                <td><%=
                    student.getBirthday()
                %></td>
                <td><button type="button" class="btn btn-primary" onclick="window.location.href='modify.jsp?sid=<%= student.getSid() %>'">修改</button></td>
                <td><button type="button" class="btn btn-primary" onclick="confirmDelete('<%= student.getSid() %>')">删除</button></td>
            </tr>
            <%
                }
            %>

            </tbody>

        </table>
        <div>
            <button type="button" class="btn btn-success" onclick="window.location.href='add.jsp'">添加学生</button>
        </div>

    </div>

    <script>
        function confirmDelete(sid) {
            if (confirm("确定要删除该学生吗？")) {
                window.location.href = '/web_lab2_war_exploded/StudentServlet?action=remove&sid=' + sid;
            }
        }
    </script>



</body>
</html>