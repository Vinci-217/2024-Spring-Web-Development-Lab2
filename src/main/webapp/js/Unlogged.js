if(sessionStorage.getItem("loggedIn")==null)
{
        alert("你还没有登录，请登录后再访问");
        window.location.href="login.jsp";
}
