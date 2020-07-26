<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="GB2312">
		<title>Insert title here</title>
	</head>
	<link type="text/css" rel=stylesheet href="log-reg.css">
	<body>
		<div id="top">
			<a href='/user?method=queryuser'>返回</a>
			<a href='exit.jsp'>注销</a>
		</div>
		<div id="updatepsw">
            <h2>修改密码</h2>
            <form action="/user?method=updatepsw" method="post">
                <div class="form-item">
                    旧密码	<input type="password" name="oldpsw"><br>
                </div>
                <div class="form-item">
                    新密码	<input type="password" name="newpsw"><br>
                </div>
                <div class="form-button">
                    <input type="submit" value="修改">
                </div>
            </form>
       
	     </div>
	</body>
</html>