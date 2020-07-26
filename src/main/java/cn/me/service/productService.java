/**
 * 
 */
package cn.me.service;

import cn.me.bean.PageBean;
import cn.me.bean.Product;
import cn.me.dao.productDao;

/**
 * @author WS
 *
 */
public class productService {
	
	public Product queryProductService(String bid) {
		return productDao.query(bid);
	}
	
	public PageBean<Product> queryPageService(int curPage, int pageSize) {
		return productDao.queryPage(curPage,pageSize);
	}
}
