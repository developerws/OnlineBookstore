/**
 * 
 */
package cn.me.controller;

import cn.me.bean.Cart;
import cn.me.service.cartService;
import cn.me.util.BaseServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * @author WS
 *
 */
public class CartServlet extends BaseServlet {
	private cartService cartservice = new cartService();
	
	public void addToCart(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String bid = request.getParameter("bid");
		boolean result = cartservice.AddCartService(id, bid);
		if(result) {
			session.setAttribute("msg", "成功加入购物车");
		}
		else {
			session.setAttribute("msg","加入购物车失败");
		}
		try {
			response.sendRedirect("/displayproduct.jsp?bid="+bid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.sendRedirect("displayproduct.jsp");
	}
	
	public void displayCart(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(); 
		String id = (String)session.getAttribute("id");
		List<Cart> cart =cartservice.displayCartService(id);
		session.setAttribute("shopcart", cart);
		try {
			response.sendRedirect("/shoppingcart.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public void deleteFromCart(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String bid = request.getParameter("bid");
		boolean result = cartservice.deleteFromCartService(id, bid);
		if(result) {
			try {
				response.sendRedirect("/cart?method=displayCart");  //是否可以使用dispancher
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
