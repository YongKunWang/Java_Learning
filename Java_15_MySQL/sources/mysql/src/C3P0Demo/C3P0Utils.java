package C3P0Demo;
/**
 * 1. 免费的连接池C3P0工具类
 * 2. 功能：
 * 		提供连接池的初始化操作
 * @author asdw1
 *
 */

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//自动加载xml文件
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//获得数据源
	//基本不使用，但是后面的DBCP需要传入数据源
	public static DataSource getDataSource() {
		return dataSource;
	}
	//获得连接池
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
