/**
 * 
 */
package cn.me.controller;

import cn.me.bean.PageBean;
import cn.me.bean.Product;
import cn.me.service.productService;
import cn.me.util.BaseServlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author WS
 *
 */
public class ProductServlet extends BaseServlet {
	private productService productservice = new productService();
	
	public void queryproduct(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String bid = request.getParameter("bid");
		Product product = productservice.queryProductService(bid);
		session.setAttribute("product", product);
		try {
			response.sendRedirect("/displayproduct.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void querypage(HttpServletRequest request,HttpServletResponse response) {
		/**
		 * 1、获取页面传递的curPage
		 * 2、给定pageSize，也就是每页显示的数据量
		 * 3、使用curPage和pageSize传递给service，得到pageBean，保存到session域中
		 * 4、转发到index.jsp
		 *
		 */
		HttpSession session = request.getSession();
		int curPage = getCurPage(request);
		int pageSize = 8;
		PageBean<Product> product= productservice.queryPageService(curPage,pageSize);
		session.setAttribute("productinfo", product);
		try {
			response.sendRedirect("/index.jsp");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 从请求参数获取当前的页码
	 * @param request
	 * @return
	 */
	private int getCurPage(HttpServletRequest request) {
		String stringPage = request.getParameter("page");
		if(stringPage == null || stringPage.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(stringPage);
	}
}
