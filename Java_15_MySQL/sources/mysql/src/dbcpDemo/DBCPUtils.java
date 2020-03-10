package dbcpDemo;
/*
 * DBCP的工具类
 */

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
//只有这个是特别的！！！
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource dataSource;
	
	static {
		try {
			//1.加载找properties文件输入流
			InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
			//2.加载输入流
			Properties props = new Properties();
			props.load(is);
			System.out.println(props);
			//3.创建数据源
			dataSource = BasicDataSourceFactory.createDataSource(props);
			System.out.println("error...");
		}catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
