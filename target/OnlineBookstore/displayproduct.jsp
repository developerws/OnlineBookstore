<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="cn.me.bean.Product" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="GB2312">
	<title>书品详情</title>
</head>
<link type="text/css" rel=stylesheet href="index1.css">
<body>
	<header>
          	<div class="center">
          		
          			
            	<div class="fr">
            		<ul>
	            		<li><a href="index.jsp">主页</a></li>
	            		<li>|</li>
	            		<li><a href="displayinfo.jsp">我的个人信息</a></li>
	            		<li>|</li>
	            		<li><a href="/order?method=displayOrder">我的订单</a></li>
	            		<li>|</li>
	            		<li><a href='exit.jsp'>注销</a></li>
            		</ul>
            		<div class="gouwuche"><a href="/cart?method=displayCart">购物车</a></div>
            	</div>
          		
          	</div>
       	
    </header>
	<%	
		Product product = null;
		product = (Product)session.getAttribute("product");
		if(product == null){
			response.sendRedirect("/index.jsp");
		}
		
	%>
	
	<div class="jieshao">
		<div class="left">
			<img src=<%= product.getImage()%> width="380px" height="500px">
		</div>
		<div class="right">
			<div class="h3">
				<span><%= product.getBname()%></span>
			</div>
			<hr>
			<div class="mingzi">作者:<%= product.getAuthor()%></div>
			<div class="jianjie">简介:<%= product.getPintro()%></div>
			<div class="jiage">
				￥<%= product.getPrice()%>
			</div>
			<div class="gouwuche">
				<form method="post" action="/cart?bid=<%=product.getBid()%>">
					<input type="hidden" name="method" value="addToCart">
					<input type="submit" value="加入购物车">
				</form>
			</div>
			
		</div>
		
		
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