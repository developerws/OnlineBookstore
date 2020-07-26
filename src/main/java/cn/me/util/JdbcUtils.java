/**
 * 
 */
package cn.me.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author WS
 *
 */
public class JdbcUtils {
	//配置文件的默认配置，声明对象时会自动加载
	private final static ComboPooledDataSource dataSource = new ComboPooledDataSource("javaWeb");
	//事务专用连接，加上static 全局使用，private不能外部使用
	private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
	/**
	 * 使用连接池返回一个连接对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		//从线程获取一个连接对象
		Connection conn = t1.get();
		//如果存在事务专用连接，则直接返回
		if(conn != null) return conn;
		conn = dataSource.getConnection();
		return conn;

	}
	/**
	 * 返回连接池对象
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 开启事务
	 * 1、获取一个connection，设置开启事务的操作
	 * 2、把connection这个对象给dao 
	 * @throws SQLException 
	 */
	public static void beginTransaction() throws SQLException {
		Connection conn = t1.get();
		if(conn != null) throw new SQLException("事务已经开启了！");
		conn = getConnection();
		conn.setAutoCommit(false);
		//开启事务，修改里面的事务专用连接
		t1.set(conn);
	}
	/**
	 * 提交事务
	 * 1、获取提交事务的connection对象，调用commit方法
	 * @throws SQLException 
	 */
	public static void commitTransaction() throws SQLException {
		Connection conn = t1.get();
		if(conn == null) throw new SQLException("还没有开启事务，不能提交！");
		conn.commit();
		conn.close();	//释放连接
		//conn = null;   //表示事务已经结束，保证下次调用getConnection获取对象就不会再获取到原来的conn对象
		t1.remove();  //从t1中移除连接
	}
	/**
	 * 回滚事务
	 * 1、获取提交事务的connection对象，调用rollback方法
	 * @throws SQLException 
	 */
	public static void rollbackTransaction() throws SQLException {
		Connection conn = t1.get();
		if(conn == null) throw new SQLException("还没有开启事务，不能回滚！");
		conn.rollback();
		conn.close();
		t1.remove();
	}
	/**
	 * 释放连接
	 * @param connection
	 * @throws SQLException 
	 */
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection conn = t1.get();
		/**
		 * 判断传递过来的参数是不是事务连接，如果是，就不关闭
		 * 如果不是，就关闭
		 */
		//如果conn=null,则说明没有事务，则关闭传递进来的连接
		if(conn == null) connection.close();
		//如果conn不为空，则说明有事务，但是又不与connection相同，则说明传递进来的连接不是事务专用连接，则关闭connection
		if(conn != connection) connection.close();
	}
}
