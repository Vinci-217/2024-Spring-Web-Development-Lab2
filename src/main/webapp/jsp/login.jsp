<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="../css/style.css">
</head>

<body>
<form method="post" id="loginForm">
<div class="container center">
    <div class="mb-3 mt-3">
        <label for="username" class="form-label" style="margin-left: 2%">用户名：</label>
        <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="username">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label" style="margin-left: 2%">密码：</label>
        <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
    </div>
    <div class="form-check mb-3 mt-4">
        <label class="form-check-label" style="margin-left: 70%">
            <input class="form-check-input" type="checkbox" name="remember" value="true" id="remember"> 记住我
        </label>
    </div>
    <button type="submit" class="btn btn-primary" style="margin-left: 70%">登录</button>
</div>
</form>
<script>
    $(document).ready(function() {

        let usernameCookie = getCookie('username');
        let passwordCookie = getCookie('password');
        if (usernameCookie !== "" && passwordCookie !== "") {
            $('#username').val(usernameCookie);
            $('#password').val(passwordCookie);
        }

        $('#loginForm').submit(function(event) {
            event.preventDefault();

            let username = $('#username').val();
            let password = $('#password').val();
            let remember = $('#remember').is(':checked');

            console.log(username);
            console.log(password);
            console.log(remember)

            if (username=="" || password=="") {
                alert('用户名或密码不能为空');
                return;
            }

            $.ajax({
                url: "http://localhost:8080/web_lab2_war_exploded/LoginServlet",
                type: "POST",
                dataType: "json",
                data: {
                    username: username,
                    password: password,
                    // remember: remember,
                },
                success: function (response) {
                    console.log(response);
                    if (response.status === "success") {
                        if (remember) {
                            document.cookie = "username=" + username;
                            document.cookie = "password=" + password;
                        }
                        sessionStorage.setItem("loggedIn", "true");
                        window.location.href = "student.jsp";
                    }
                    else {
                        alert('用户名或密码错误');
                    }
                },
                error: function (xhr, status, error) {
                    console.log("error", status, error);
                }
            });
        });
    });

    function getCookie(name) {
        let cookies = document.cookie.split(';');
        for (let i = 0; i < cookies.length; i++) {
            let cookie = cookies[i].trim();
            if (cookie.startsWith(name + '=')) {
                return cookie.substring(name.length + 1);
            }
        }
        return "";
    }
</script>
</body>
</html>
