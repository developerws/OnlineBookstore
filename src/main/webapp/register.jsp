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
            <h2>��ӭע��</h2>
            <form method="post" action="/user?method=adduser">
                <div class="form-item">
                   �û���   	<input type="text" name="username"><br>
                </div>
                <div class="form-item">
                    ����  	<input type="password" name="psw"><br>
                </div>
                <div class="form-item">
                    ����  	<input type="text" name="age"><br>
                </div>
                <div class="form-item">
                    �绰		<input type="text" name="phone"><br>
                </div>
                <div class="form-item">
                    ��ַ		<input type="text" name="address"><br>
                </div>
                <div class="form-item">
                    ����		<input type="text" name="city"><br>
                </div>
                
                <div class="form-button">
                    <input type="submit" value="����ע��">
                </div>
                <div class="reg-for">
                    <a href="login.jsp">�����˺ţ�ȥ��¼</a>
                </div>
            </form>
        </div>
	</body>
</html>