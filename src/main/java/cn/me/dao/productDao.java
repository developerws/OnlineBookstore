/**
 * 
 */
package cn.me.dao;

import java.sql.SQLException;
import java.util.List;


import cn.me.bean.PageBean;
import cn.me.bean.Product;
import cn.me.util.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



/**
 * @author WS
 *
 */
public class productDao {
	private static QueryRunner qr = new TxQueryRunner();
	/**
	 * 根据bid查询商品信息
	 * @param bid
	 * @return
	 */
	public static Product query(String bid) {
		String sql = "SELECT * FROM book WHERE bid=?";
		Object param = bid;
		Product product = null;
		try {
			product = qr.query(sql, param, new BeanHandler<Product>(Product.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return product;
	}
	
	/**
	 * 根据页数显示对应的商品内容
	 * @param curPage
	 * @return
	 */
	public static PageBean<Product> queryPage(int curPage,int pageSize) {
		/**
		 *1、创建PageBean对象product
		 *2、设置product的curPage和pageSize
		 *3、得出总页数，设置给product
		 *4、得到beanList ，设置给product
		 *5、返回product
		 */
		PageBean<Product> product = new PageBean<>();
		product.setCurPage(curPage);
		product.setPageSize(pageSize);
		String sql = "SELECT COUNT(*) FROM book;";
		Number count;
		try {
			count = (Number)qr.query(sql, new ScalarHandler());
		} catch (SQLException e1) {
			throw new RuntimeException(e1);
		}
		int totalRecord = count.intValue();
		product.setTotalRecord(totalRecord);
		sql = "SELECT * FROM book LIMIT ? OFFSET ?;";
		Object[] params = {pageSize,(curPage-1)*pageSize};
		List<Product> productList;
		try {
			productList = qr.query(sql, params, new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		product.setBeanList(productList);
		return product;
	}
}
