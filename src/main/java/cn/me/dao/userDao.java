/**
 * 
 */
package cn.me.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import cn.me.bean.User;
import cn.me.util.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



/**
 * @author WS
 *
 */
public class userDao {
	private static QueryRunner qr = new TxQueryRunner();
	/**
	 * 添加用户数据
	 * @param user
	 * @return
	 */
	public static boolean insertUser(User user) {
		String sql = "insert into myuser values(?,?,?,?,?,?,?);";
		/*随机产生两位数*/
		Random ran = new Random();
		int nums = ran.nextInt(100);
		/*利用时间戳得到8位不重复的随机数*/
		Date date = new Date();
		long nowDate = date.getTime();
		/*将上面产生的随机数拼接成用户id*/
		String id = Integer.toHexString((int)nowDate) + Integer.toString(nums);
		Object[] params = {id,user.getName(),user.getPsw(),user.getAge(),user.getPhone(),user.getAddress(),user.getCity()};
		int row = 0 ;
		try {
			row = qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		if(row > 0)
			return true;
		return false;
	}
	/**
	 * 验证用户的用户名和密码
	 * @param username
	 * @param psw
	 * @return
	 */
	public static String verifyUser(String username,String psw) {
		String sql = "select id from myuser where name=? and psw=?;";
		Object[] params = {username,psw};
		String result = "";
		try {
			result = (String)qr.query(sql, new ScalarHandler(), params);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
		
	}
	/**
	 * 查询该用户的基本信息
	 * @param id
	 * @return
	 */
	public static User queryUser(String id) {
		String sql = "SELECT * FROM myuser WHERE id=?";
		Object params = id;
		User user = null;
		try {
			user = qr.query(sql, params, new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	
	/**
	 * 修改用户密码
	 * @param id
	 * @param psw
	 * @return
	 */
	public static boolean updatepsw(String id,String psw) {
		String sql = "UPDATE myuser SET psw=? WHERE id=?";
		Object[] params = {psw,id};
		int row = 0;
		try {
			row = qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		if(row>0)
			return true;
		return false;
	}
	
	/**
	 * 修改用户的基本信息
	 * @param user
	 * @return
	 */
	public static boolean updateinfo(User user) {
		String sql = "update myuser set name=?,age=?,phone=?,address=?,city=? where id=?";
		Object[] params = {user.getName(),user.getAge(),user.getPhone(),user.getAddress(),user.getCity(),user.getId()};
		int row = 0;
		try {
			row = qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		if(row>0)
			return true;
		return false;
	}
}
