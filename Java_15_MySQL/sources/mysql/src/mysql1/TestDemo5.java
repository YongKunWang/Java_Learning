package mysql1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 1. 实现MySql的工具类的使用
 * @author asdw1
 *
 */
class JDBCUtils_V1 {
	
	public static Connection getConnection() {
		Connection conn = null;
		//1.注册驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2. 获得连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDemo1_db","root","admin"); 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	public static void release(Connection conn, PreparedStatement ptst,ResultSet rt) {
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(ptst != null) {
				ptst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rt != null) {
				rt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class JDBCUtils_V2 {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		driver = bundle.getString("jdbc.driver");
		url = bundle.getString("jdbc.url");
		user = bundle.getString("jdbc.user");
		password = bundle.getString("jdbc.password");
		
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		//1.注册驱动程序
		try {
			Class.forName(driver);
			//2. 获得连接
			conn = DriverManager.getConnection(url,user,password); 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	public static void release(Connection conn, PreparedStatement ptst,ResultSet rt) {
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(ptst != null) {
				ptst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rt != null) {
				rt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class JDBCUtils_V3 {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try {
			//1.通过当前类获取类加载器
			ClassLoader classLoader = JDBCUtils_V3.class.getClassLoader();
			//2.通过类加载器的方法获得一个输入流
			InputStream is = classLoader.getResourceAsStream("db.properties");
			//3.创建一个对象
			Properties properties = new Properties();
			properties.load(is);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		driver = bundle.getString("jdbc.driver");
		url = bundle.getString("jdbc.url");
		user = bundle.getString("jdbc.user");
		password = bundle.getString("jdbc.password");
		
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		//1.注册驱动程序
		try {
			Class.forName(driver);
			//2. 获得连接
			conn = DriverManager.getConnection(url,user,password); 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	public static void release(Connection conn, PreparedStatement ptst,ResultSet rt) {
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(ptst != null) {
				ptst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rt != null) {
				rt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





public class TestDemo5 {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement ptst = null;
		ResultSet rt = null;
		
//		conn = JDBCUtils_V1.getConnection();
//		conn = JDBCUtils_V2.getConnection();
		conn = JDBCUtils_V3.getConnection();
		
		String sql = "select * from category where cid=? and cname=?";
		ptst = conn.prepareStatement(sql);
		ptst.setString(1, "c001");
		ptst.setString(2, "家电");
		
		rt = ptst.executeQuery();
		
		while(rt.next()) {
			System.out.println(rt.getString(1) + "  :  " + rt.getString(2) );
		}
//		JDBCUtils_V1.release(conn, ptst, rt);
//		JDBCUtils_V2.release(conn, ptst, rt);
		JDBCUtils_V3.release(conn, ptst, rt);
	}

}
