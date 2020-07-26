<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="GB2312">
		<title>Insert title here</title>
	</head>
	<link type="text/css" rel=stylesheet href="log-reg.css">
	<body>
		<div id="register">
            <h2>欢迎注册</h2>
            <form method="post" action="/user?method=adduser">
                <div class="form-item">
                   用户名   	<input type="text" name="username"><br>
                </div>
                <div class="form-item">
                    密码  	<input type="password" name="psw"><br>
                </div>
                <div class="form-item">
                    年龄  	<input type="text" name="age"><br>
                </div>
                <div class="form-item">
                    电话		<input type="text" name="phone"><br>
                </div>
                <div class="form-item">
                    地址		<input type="text" name="address"><br>
                </div>
                <div class="form-item">
                    城市		<input type="text" name="city"><br>
                </div>
                
                <div class="form-button">
                    <input type="submit" value="立即注册">
                </div>
                <div class="reg-for">
                    <a href="login.jsp">已有账号？去登录</a>
                </div>
            </form>
        </div>
	</body>
</html>