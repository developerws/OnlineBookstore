/**
 * 
 */
package cn.me.service;

//import java.math.BigDecimal;
import cn.me.bean.Cart;
import cn.me.bean.Product;
import cn.me.dao.cartDao;
import cn.me.dao.productDao;
import java.util.List;


/**
 * @author WS
 *
 */
public class cartService {
	/**
	 * 根据用户id查询购物车的信息
	 * @param id
	 * @return
	 */
	public List<Cart> displayCartService(String id) {
		return cartDao.queryCart(id);
	}
	/**
	 * 向购物车添加商品
	 * 先通过商品id查询该商品的其他信息
	 * 接着根据id和bid查询购物车表是否已有该商品的信息
	 * 如果有，就在原来的基础上更新
	 * 如果没有，就插入数据
	 * @param id
	 * @param bid
	 * @return
	 */
	public boolean AddCartService(String id,String bid) {
		Product product = productDao.query(bid);	//查询bid对应的商品信息
		Cart cart = new Cart(id,bid,product.getBname(),product.getAuthor(),1,product.getPrice()); //生成购物车对象
		Long record = cartDao.isHaveProduct(cart);	// 查询该商品是否已加入购物车
		if(record == 0) {
			return cartDao.insertProduct(cart);	//如果没有，插入数据
		}
		else {
			return cartDao.updateProduct(cart);	//如果有，更新其中的数量和总金额
		}
	}
	/**
	 * 根据用户id和商品bid删除购物车表中对应的记录
	 * @param id
	 * @param bid
	 * @return
	 */
	public boolean deleteFromCartService(String id,String bid) {
		return cartDao.deleteProduct(id, bid);
	}
}
