/**
 * 
 */
package cn.me.util;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WS
 *
 */
public abstract class BaseServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String methodName = request.getParameter("method");
		if(methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("您没有传递method参数");
		}
		Class current_class = this.getClass();
		Method method = null;
		try {
			method = current_class.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		}catch(Exception e) {
			throw new RuntimeException("你需要调用的方法："+ methodName+",它不存在！");
		}
		
		try {
			method.invoke(this, request,response); //this.addUser(request,response)->method(this,req,res)
		}catch(Exception e) {
			System.out.println("调用的方法"+methodName+"内部出现错误");
			throw new RuntimeException(e);
		}
		
		
		
	}
	
}
