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
			<a href='/user?method=queryuser'>����</a>
			<a href='exit.jsp'>ע��</a>
		</div>
		<div id="updatepsw">
            <h2>�޸�����</h2>
            <form action="/user?method=updatepsw" method="post">
                <div class="form-item">
                    ������	<input type="password" name="oldpsw"><br>
                </div>
                <div class="form-item">
                    ������	<input type="password" name="newpsw"><br>
                </div>
                <div class="form-button">
                    <input type="submit" value="�޸�">
                </div>
            </form>
       
	     </div>
	</body>
</html>