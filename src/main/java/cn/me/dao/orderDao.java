/**
 * 
 */
package cn.me.dao;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import cn.me.bean.Cart;
import cn.me.bean.Order;
import cn.me.bean.User;
import cn.me.util.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



/**
 * @author WS
 *
 */
public class orderDao {
	
	private static QueryRunner qr = new TxQueryRunner();
	/**
	 * 根据用户信息和购物车信息生成订单信息
	 * @param user
	 * @param cart
	 * @return
	 */
	public static boolean addOrder(User user, Cart cart) {
		String sql = "INSERT INTO book_order VALUE(?,?,?,?,?,?,?,?,?,?)";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		/*随机产生四位数*/
		Random ran = new Random();
		int nums = ran.nextInt(9000)%(9000-1000+1) + 1000;
		/*利用时间戳得到8位不重复的随机数*/
		long nowDate = date.getTime();
		/*将上面产生的随机数拼接成用户id*/
		String oid = Integer.toHexString((int)nowDate) + Integer.toString(nums);
		Object[] params = {oid,user.getId(),cart.getBid(),cart.getBname(),user.getName(),
				user.getPhone(),user.getAddress(),cart.getAmount(),cart.getSum(),dateStr};
		int row = 0;
		try {
			row = qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		if(row>0) {
			return true;
		}
		return false;
	}
	/**
	 * 查询该id号的所有订单数
	 * @param id
	 * @return
	 */
	public static Long queryCount(String id) {
		String sql = "SELECT COUNT(*) record FROM book_order WHERE id=?";
		Object param =id;
		Long result;
		try {
			result = (Long)qr.query(sql, param, new ScalarHandler());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	/**
	 * 根据用户id查询所有订单
	 * @param id
	 * @return
	 */
	public static List<Order> queryorder(String id) {
		String sql = "SELECT * FROM book_order WHERE id=?";
		Object param = id;
		List<Order> orderList = null;
		try {
			orderList = qr.query(sql, param, new BeanListHandler<Order>(Order.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return orderList;
	}
}
