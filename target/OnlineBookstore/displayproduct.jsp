<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="cn.me.bean.Product" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="GB2312">
	<title>��Ʒ����</title>
</head>
<link type="text/css" rel=stylesheet href="index1.css">
<body>
	<header>
          	<div class="center">
          		
          			
            	<div class="fr">
            		<ul>
	            		<li><a href="index.jsp">��ҳ</a></li>
	            		<li>|</li>
	            		<li><a href="displayinfo.jsp">�ҵĸ�����Ϣ</a></li>
	            		<li>|</li>
	            		<li><a href="/order?method=displayOrder">�ҵĶ���</a></li>
	            		<li>|</li>
	            		<li><a href='exit.jsp'>ע��</a></li>
            		</ul>
            		<div class="gouwuche"><a href="/cart?method=displayCart">���ﳵ</a></div>
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
			<div class="mingzi">����:<%= product.getAuthor()%></div>
			<div class="jianjie">���:<%= product.getPintro()%></div>
			<div class="jiage">
				��<%= product.getPrice()%>
			</div>
			<div class="gouwuche">
				<form method="post" action="/cart?bid=<%=product.getBid()%>">
					<input type="hidden" name="method" value="addToCart">
					<input type="submit" value="���빺�ﳵ">
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