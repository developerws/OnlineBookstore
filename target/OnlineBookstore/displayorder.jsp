<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="cn.me.bean.Order" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="GB2312">
	<title>订单展示</title>
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
	<div class="dingdan">
		<div class="h3">交易订单</div>
		<div class="xiangqing">
			<div class="ddbiaoti">
				<div class="bianhao" style="float: left;">订单编号</div>
				<div class="guanjian">
					<ul>
						<li>书名</li>
						<li>订单状态</li>
						<li>数量</li>
						<li>价格</li>
						<li>收货人</li>
						<li>电话</li>
						<li>收获地址</li>
						<li>交易时间</li>
						
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
			
									<li>已完成</li>
									<li><%=order.get(i).getAmount() %></li>
									<li>￥<%=order.get(i).getSum() %></li>
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