<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@page import="java.util.*" %>
<%@page import="cn.me.bean.Product" %>
<%@page import="cn.me.bean.PageBean" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="GB2312">
		<title>�������</title>
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
	            					<li><a href="login.jsp">��¼</a></li>
				            		<li>|</li>
				            		<li><a href="register.jsp">ע��</a></li>
	            					<li>|</li>
	            					<%
	            				}
	            			}
	            			%>
		            		<li><a href="/user?method=queryuser">�ҵĸ�����Ϣ</a></li>
		            		<li>|</li>
		            		<li><a href="/order?method=displayOrder">�ҵĶ���</a></li>
		            		<li>|</li>
	            		<li><a href='exit.jsp'>ע��</a></li>
	            		</ul>
	            		<div class="gouwuche"><a href="/cart?method=displayCart">���ﳵ</a></div>
	            	</div>
           		
           	</div>
        	
        </header>
            <div class="search">
                <input type="text" name="search_content">
                <input type="submit" value="����">
            </div>
         
            <div class="book-list" >
                <div class="book-content">
                    	�鱾Ŀ¼
                </div>
                <%
      				PageBean<Product> product = null;
               		product = (PageBean<Product>)session.getAttribute("productinfo");//��ȡ�Ự����Ʒ����Ϣ
               		if(product == null){
               			response.sendRedirect("/product?method=querypage&page=1");
               		}
               		else{
               			int curPage = product.getCurPage();
               			List<Product> productList = product.getBeanList();
               			//ѭ������Ʒ����Ϣ��ʾ��ҳ����
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
        	                				<span>����:<%=productList.get(i).getAuthor() %></span><br>
        	                				<span>��<%=productList.get(i).getPrice() %></span><br>
       	                				</div>
       	                			</a>
       	                		</div>
       	                	<%		
               				}
   	                		
   	                	}
               		
               	%>
                
               	<div class="jumpPage">
               		��<%=curPage %>ҳ/��<%=product.getTotalPage() %>ҳ
               		<a href="/product?method=querypage&page=1">��ҳ</a>
               		<%if(curPage>=2) {%>
	                <a href="/product?method=querypage&page=<%=(curPage-1)%>">��һҳ</a>
	                <%} %>
	                <a href="/product?method=querypage&page=1">1</a>
	                <a href="/product?method=querypage&page=2">2</a>
	                <a href="/product?method=querypage&page=3">3</a>
	                <a href="/product?method=querypage&page=4">4</a>
	                <%if(curPage<product.getTotalPage()) {%>
	                <a href="/product?method=querypage&page=<%=(curPage+1) %>">��һҳ</a>
	                <%} %>
	                <a href="/product?method=querypage&page=<%= product.getTotalPage() %>">βҳ</a>
	                <form action="/product?method=querypage%>" method="post">
            			ת���ڣ�<input type="text" name="page" size=2>ҳ
            			<input type="submit" value="Go">
            		</form>
           		</div>
                
                <%}
               		%>
            </div>
        </div>

	</body>
</html>