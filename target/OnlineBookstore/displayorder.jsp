<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="cn.me.bean.Order" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="GB2312">
	<title>����չʾ</title>
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
	<div class="dingdan">
		<div class="h3">���׶���</div>
		<div class="xiangqing">
			<div class="ddbiaoti">
				<div class="bianhao" style="float: left;">�������</div>
				<div class="guanjian">
					<ul>
						<li>����</li>
						<li>����״̬</li>
						<li>����</li>
						<li>�۸�</li>
						<li>�ջ���</li>
						<li>�绰</li>
						<li>�ջ��ַ</li>
						<li>����ʱ��</li>
						
					</ul>
				</div>
			</div>
			
				<%
					List<Order> order = null;
					order = (List<Order>)session.getAttribute("bookorder");
					if(order == null){

					}
					else{
						for(int i = 0;i<order.size();i++){
							
						%>
						<div class="ddxinxi">
							<div class="sub_bianhao" style="float: left;"><%=order.get(i).getOid() %></div>
							<div class="sub_guanjian">
								<ul>
									<li><%=order.get(i).getBname() %></li>
			
									<li>�����</li>
									<li><%=order.get(i).getAmount() %></li>
									<li>��<%=order.get(i).getSum() %></li>
									<li><%=order.get(i).getName() %></li>
									<li><%=order.get(i).getPhone() %></li>
									<li><%=order.get(i).getAddress() %></li>
									<li><%=order.get(i).getCreate_time() %></li>
									
								</ul>
									
							</div>	
						</div>	
						<%
						}
					}
				%>
			
			
			
			
			
		</div>
		
		
	</div>
	
		
</body>
</html>