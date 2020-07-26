/**
 * 
 */
package cn.me.controller;

import cn.me.bean.User;
import cn.me.service.userService;
import cn.me.util.BaseServlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author WS
 *
 */
public class UserServlet extends BaseServlet {
	private userService userservice = new userService();
	public void adduser(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			request.setCharacterEncoding("GB2312");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String username = request.getParameter("username");
		String psw = request.getParameter("psw");
		String ageString = request.getParameter("age");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		Integer age=Integer.parseInt(ageString);
		User user = new User(username,psw,age,phone,address,city);
		System.out.println(username);
		boolean result = userservice.addUserService(user);
		if(result) {
			session.setAttribute("msg", "注册成功");
		}
		else {
			session.setAttribute("msg","注册失败");
		}
		try {
			response.sendRedirect("/login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verifyuser(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			request.setCharacterEncoding("GB2312");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String id = userservice.verifyUserService(username, password);
		if(id != "") {
			session.setAttribute("id", id);
			try {
				response.sendRedirect("/index.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void queryuser(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		User user = null;
		user = userservice.queryUser(id);
		if(user == null) {
			System.out.println("用户信息是空的哟");
		}
		else {
			System.out.println("用户信息没有空的哟");
			session.setAttribute("userinfo", user);
			try {
				response.sendRedirect("/displayinfo.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void updatepsw(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(); 
		String id = (String)session.getAttribute("id");
		String oldpsw = request.getParameter("oldpsw");
		String newpsw = request.getParameter("newpsw");
		boolean result = userservice.updatepswService(id, oldpsw, newpsw);
		if(result) {
			session.setAttribute("msg", "修改密码成功");
		}
		else {
			session.setAttribute("msg","修改密码失败");
		}
		try {
			response.sendRedirect("/displayinfo.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void updateinfo(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = new User();
		user.setId((String)session.getAttribute("id"));
		user.setName(request.getParameter("username"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setPhone(request.getParameter("phone"));
		user.setAddress(request.getParameter("address"));
		user.setCity(request.getParameter("city"));
		boolean result = userservice.updateinfoService(user);
		if(result) {
			session.setAttribute("msg", "修改用户信息成功");
		}
		else {
			session.setAttribute("msg","修改用户信息失败");
		}
		try {
			response.sendRedirect(request.getContextPath()+"/user?method=queryuser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
