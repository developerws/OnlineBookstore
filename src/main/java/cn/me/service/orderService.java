
/**
 * 
 */
package cn.me.service;

import cn.me.bean.Cart;
import cn.me.bean.Order;
import cn.me.bean.User;
import cn.me.dao.cartDao;
import cn.me.dao.orderDao;
import cn.me.dao.userDao;
import cn.me.util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;



/**
 * @author WS
 *
 */
public class orderService {
	/**
	 * 完成付款业务，在增加订单和删除购物车时需要使用到业务
	 * @param id
	 * @param bid
	 * @return
	 * @throws SQLException
	 */
	public boolean payForOrderService(String id,String bid){
		User user = userDao.queryUser(id);
		Cart cart = cartDao.queryProduct(id, bid);
		boolean result = false;
		try {
			JdbcUtils.beginTransaction();
			cartDao.deleteProduct(id, bid);
			result = orderDao.addOrder(user, cart);
			JdbcUtils.commitTransaction();
		}catch(SQLException e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	
	}
	
	public List<Order> displayOrderService(String id) {
		return orderDao.queryorder(id);
	}
}
