<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="GB2312">
		<title>�û���¼ҳ��</title>
	</head>
	<link type="text/css" rel=stylesheet href="log-reg.css">
	<body>
		
		<%
			if(!session.isNew()){
				String id = (String)session.getAttribute("id");
				if(id != null){
					response.sendRedirect("/user?method=queryuser");
				}
			}
		%>
		
		<div id="top">
			<a class="register" href="register.jsp">ע��</a>
			
		</div>
		<div id="login">
            <h2>�˻���¼</h2>
            <form method="post" action="/user?method=verifyuser">
                <div class="form-item">
                    �û���    <input type="text" name="username"><br>
                </div>
                <div class="form-item">
                    ����    <input type="password" name="password"><br>
                </div>
                <div class="form-button">
                    <input type="submit" value="��¼">
                </div>
            </form>
        </div>
		<%
			String msg = (String)session.getAttribute("msg");
			if(msg != null && !"".equals(msg)){
			
			%>
				<script type="text/javascript">
					alert("<%=msg%>");
				</script>
			<%
			session.setAttribute("msg", ""); 
			}
		%>
	</body>
</html>