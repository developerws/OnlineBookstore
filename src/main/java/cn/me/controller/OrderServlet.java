/**
 * 
 */
package cn.me.controller;

import cn.me.bean.Order;
import cn.me.service.orderService;
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
public class OrderServlet extends BaseServlet {
	private orderService orderservice = new orderService();

	public void payForOrder(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String bid = request.getParameter("bid");
		boolean result = orderservice.payForOrderService(id, bid);
		if(result) {
			session.setAttribute("msg","付款成功");
		}
		else {
			session.setAttribute("msg", "付款失败");
		}
		try {
			response.sendRedirect("/cart?method=displayCart");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void displayOrder(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		List<Order> order = null;
		order = orderservice.displayOrderService(id);
		session.setAttribute("bookorder", order);
		try {
			response.sendRedirect("/displayorder.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
		
	}
}
