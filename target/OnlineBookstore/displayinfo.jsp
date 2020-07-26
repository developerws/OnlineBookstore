<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@page import="cn.me.bean.User" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="GB2312">
	<title>个人信息</title>
</head>
<link type="text/css" rel=stylesheet href="log-reg.css">
<body>
	
	<%
		User user = null;
		user =(User) session.getAttribute("userinfo");
		if(user == null){
			response.sendRedirect("/user?method=queryuser");
		}
		
		
	%>
	
	<div id="top">
		<a href="index.jsp">主页</a>
		<a href='exit.jsp'>注销</a>
		<a href='updatepsw.jsp'>修改密码</a>
		
	</div>
	<div id="display">
		<h2>基本信息</h2>
		<form  action="/user?method=updateinfo" method="post">
			<ul style="list-style:none;" id="content">
				<li class="form-item">
			用户名&nbsp;&nbsp;<input type="text" name="username" id="Username" value="<%=user.getName()%>">
				</li>
				<li class="form-item">
			年龄&nbsp;&nbsp;<input type="text" name="age" id="Age" value="<%=user.getAge()%>">
				</li>
				<li class="form-item">
			电话&nbsp;&nbsp;<input type="text" name="phone" id="Phone" value="<%=user.getPhone()%>">
				</li>
				<li class="form-item">
			地址&nbsp;&nbsp;<input type="text" name="address" id="Address" value="<%=user.getAddress() %>">
				</li>
				<li class="form-item">
			城市&nbsp;&nbsp;<input type="text" name="city" id="City" value="<%=user.getCity()%>">
				</li>	
			</ul>
			<div class="form-button">
                 <input type="submit" value="修改">
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