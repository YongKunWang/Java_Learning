package pool_custom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * 1. 当理解了连接池的原理之后
 * 	定制一个连接池
 * @author asdw1
 *
 */
public class JdbcUtils {
	//1. 创建一个存放连接的容器
	private static LinkedList<Connection> pool = new LinkedList<Connection> ();
	//2. 初始化连接池
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for (int i = 0; i < 5; i++) {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDemo1_db","root","admin");
				pool.add(conn);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() {
		try {
			//如果连接池中有连接，取出一个
			if(! pool.isEmpty()){
				Connection conn = pool.removeFirst();
				return conn;
			}else {
				//如果连接池中没有连接，等待100ms 然后继续查询
				Thread.sleep(100);
				return getConnection();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void release(Connection conn, PreparedStatement ptsm,ResultSet rt) {
		
		try {
			if(conn != null) {
//				conn.close();
				pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(ptsm != null) {
				ptsm.close();
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

