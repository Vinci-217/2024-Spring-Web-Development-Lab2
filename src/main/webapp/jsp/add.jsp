
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>


<div class="container mt-3">
    <h2>添加学生</h2>
<form action="/web_lab2_war_exploded/StudentServlet" method="post">
    <input type="hidden" name="action" value="add">
    <table class="table mt-3">
        <tbody>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="sid" ></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name" ></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><select name="gender">
                    <option value="m">男</option>
                    <option value="f">女</option>
                </select></td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td><input type="number" name="age" ></td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><input type="date" name="birthday" ></td>
            </tr>

        </tbody>
    </table>
    <input type="submit" value="提交" class="btn btn-success">
</form>
</div>
</body>
</html>
