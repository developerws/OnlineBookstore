/**
 * 
 */
package cn.me.dao;

import java.sql.SQLException;
import java.util.List;

import cn.me.bean.Cart;

import cn.me.util.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



/**
 * @author WS
 *
 */
public class cartDao {
	private static QueryRunner qr = new TxQueryRunner();
	
	/**
	 * 查询用户id在购物车表中的记录数（也就是用户加入购物车的商品有多少个）
	 */
	public static Long queryCount(String id) {
		String sql = "SELECT COUNT(*) record FROM shop_cart WHERE id=?";
		Object param = id;
		Long result;
		try {
			result = (Long)qr.query(sql, param, new ScalarHandler());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
		
		
	}
	/**
	 * 查询出用户id在购物车表中的每条记录，并用HashMap数组存储数据
	 * @param id
	 * @return
	 */
	public static List<Cart> queryCart(String id) {
		String sql = "SELECT * FROM shop_cart WHERE id=?";
		Object param = id;
		List<Cart> cartList = null;
		try {
			cartList = qr.query(sql, param, new BeanListHandler<Cart>(Cart.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cartList;
	}
	/**
	 * 根据用户id和商品bid查询对应的商品信息
	 * @param id
	 * @param bid
	 * @return
	 */
	public static Cart queryProduct(String id,String bid) {
		String sql = "SELECT * FROM shop_cart WHERE id=? and bid=?";
		Object[] params = {id,bid};
		Cart cart = null;
		try {
			cart = qr.query(sql, params, new BeanHandler<Cart>(Cart.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		cart.setId(id);
		cart.setBid(bid);
		return cart;
	}
	
	/**
	 * 判断购物车中是否有该商品
	 * @param cart
	 * @return
	 */
	public static Long isHaveProduct(Cart cart) {
		String sql = "SELECT COUNT(*) record FROM shop_cart WHERE id=? and bid=?;";
		Object[] params = {cart.getId(),cart.getBid()};
		Long result;
		try {
			result = (Long)qr.query(sql, params, new ScalarHandler());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	/**
	 * 因为购物车表中已有商品记录，现在是更新商品的数量和总金额
	 * @param cart
	 * @return
	 */
	public static boolean updateProduct(Cart cart) {
		String sql = "UPDATE shop_cart SET amount=amount+1,sum=(sum/(amount-1))*amount WHERE id=? AND bid=?";
		Object[] params = {cart.getId(),cart.getBid()};
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
	 * 向购物车表插入商品记录
	 * @param cart
	 * @return
	 */
	public static boolean insertProduct(Cart cart) {
		
		String sql = "INSERT INTO shop_cart VALUES(?,?,?,?,?,?)";		
		Object[] params= {cart.getId(),cart.getBid(),cart.getBname(),cart.getAuthor(),cart.getAmount(),cart.getSum()};
		int row = 0 ;
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
	 * 删除购物车表中的商品记录
	 * @param id
	 * @param bid
	 * @return
	 */
	public static boolean deleteProduct(String id,String bid) {
		String sql = "DELETE FROM shop_cart WHERE id=? and bid=?";
		Object[] params= {id,bid};
		int row = 0 ;
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
	
}
