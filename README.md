# Web开发技术实验2
一部分采用了第一次实验的代码，另一部分采用表单发送到后端servlet请求，实现基本连接数据库以后的增删改查
使用之前需要先创建好数据库表
用户表users：
username character varying(20) 主键
password character varying(20)
学生表student：
sid character varying(10) 主键
name character varying(10)
gender character(1)，m表示男，f表示女
age integer
birthday date
然后修改相关配置（例如数据库的url，用户名密码等等）
