<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="cn.me.bean.Cart" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="GB2312">
	<title>�ҵĹ��ﳵ</title>
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
	            		
	            	</div>
           		
           	</div>
        	
        </header>
	
	<div class="wodegwc">
		<div class="h3">�ҵĹ��ﳵ</div>
		<div class="biaoti">
			<div class="sub_top">�鱾����</div>
			<div class="sub_top">����</div>
			<div class="sub_top">����</div>
			<div class="sub_top">���</div>
			<div class="sub_top">����</div>
		</div>
		
			<%	
				List<Cart> cart = null;
				cart = (List<Cart>)session.getAttribute("shopcart");
				if(cart == null){
					cart = null;
				}
				for(int i = 0;i<cart.size();i++){
					%>
					<div class="content">
						<div class="sub_content"><%=cart.get(i).getBname() %></div>
						<div class="sub_content"><%=cart.get(i).getAuthor() %></div>
						<div class="sub_content"><%=cart.get(i).getAmount() %></div>
						<div class="sub_content"><%=cart.get(i).getSum() %></div>
						<div class="sub_content">
							<form action="/cart" method="post">
						
							<input type="hidden" name="bid" value="<%=cart.get(i).getBid() %>" >
							<input type="hidden" name="method" value= "deleteFromCart">
							<input type="submit" value="ɾ��">
						</form>
						</div>
						<div class="sub_content">
							<form action="/order" method="post">
						
								<input type="hidden" name="bid" value="<%=cart.get(i).getBid() %>" >
								<input type="hidden" name="method" value="payForOrder">
								<input type="submit" value="����">
							</form>
						</div>
					</div>
					<%
				}
			%>
		
	
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