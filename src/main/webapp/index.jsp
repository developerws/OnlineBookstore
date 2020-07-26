<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@page import="java.util.*" %>
<%@page import="cn.me.bean.Product" %>
<%@page import="cn.me.bean.PageBean" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="GB2312">
		<title>网上书城</title>
	</head>
	<link type="text/css" rel=stylesheet href="index1.css">
	
	<body>
		
		<div class="page">
            <header>
           	<div class="center">
	            	<div class="fr">
	            		<ul>
	            			<%
	            			if(!session.isNew()){
	            				String id = (String)session.getAttribute("id");
	            				if(id == null){
	            					%>
	            					<li><a href="login.jsp">登录</a></li>
				            		<li>|</li>
				            		<li><a href="register.jsp">注册</a></li>
	            					<li>|</li>
	            					<%
	            				}
	            			}
	            			%>
		            		<li><a href="/user?method=queryuser">我的个人信息</a></li>
		            		<li>|</li>
		            		<li><a href="/order?method=displayOrder">我的订单</a></li>
		            		<li>|</li>
	            		<li><a href='exit.jsp'>注销</a></li>
	            		</ul>
	            		<div class="gouwuche"><a href="/cart?method=displayCart">购物车</a></div>
	            	</div>
           		
           	</div>
        	
        </header>
            <div class="search">
                <input type="text" name="search_content">
                <input type="submit" value="搜索">
            </div>
         
            <div class="book-list" >
                <div class="book-content">
                    	书本目录
                </div>
                <%
      				PageBean<Product> product = null;
               		product = (PageBean<Product>)session.getAttribute("productinfo");//提取会话中商品的信息
               		if(product == null){
               			response.sendRedirect("/product?method=querypage&page=1");
               		}
               		else{
               			int curPage = product.getCurPage();
               			List<Product> productList = product.getBeanList();
               			//循环将商品的信息显示在页面上
               			for(int i = 0;i<productList.size();i++){
               				if(productList.get(i) != null){
               				%>
               					<div class="book" style="background: rgb(250,250,250);border:2px solid #fff;">
               						<a href="/product?method=queryproduct&bid=<%=productList.get(i).getBid() %>">
       	                				<div class="bookimg"> 
       	                					<img src=<%=productList.get(i).getImage() %>>
       	                				</div>
       	                				<div class="bookintro">
        	                				<span><%=productList.get(i).getBname() %></span><br>
        	                				<span>作者:<%=productList.get(i).getAuthor() %></span><br>
        	                				<span>￥<%=productList.get(i).getPrice() %></span><br>
       	                				</div>
       	                			</a>
       	                		</div>
       	                	<%		
               				}
   	                		
   	                	}
               		
               	%>
                
               	<div class="jumpPage">
               		第<%=curPage %>页/共<%=product.getTotalPage() %>页
               		<a href="/product?method=querypage&page=1">首页</a>
               		<%if(curPage>=2) {%>
	                <a href="/product?method=querypage&page=<%=(curPage-1)%>">上一页</a>
	                <%} %>
	                <a href="/product?method=querypage&page=1">1</a>
	                <a href="/product?method=querypage&page=2">2</a>
	                <a href="/product?method=querypage&page=3">3</a>
	                <a href="/product?method=querypage&page=4">4</a>
	                <%if(curPage<product.getTotalPage()) {%>
	                <a href="/product?method=querypage&page=<%=(curPage+1) %>">下一页</a>
	                <%} %>
	                <a href="/product?method=querypage&page=<%= product.getTotalPage() %>">尾页</a>
	                <form action="/product?method=querypage%>" method="post">
            			转到第：<input type="text" name="page" size=2>页
            			<input type="submit" value="Go">
            		</form>
           		</div>
                
                <%}
               		%>
            </div>
        </div>

	</body>
</html>