package mysql1;

import java.sql.*;


/**
 * 复习MySql的基本使用
 * @author asdw1
 *
 */
public class TestDemo3 {

	public static void main(String[] args) {
		//声明变量
		Connection cnn = null;
		Statement  st = null;
		ResultSet  rt = null;
		try {
			//1. 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得连接
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","admin");
			
			//3.创建语句执行
			st = cnn.createStatement();
			//4.设置sql语句
			String sql = "select * from category";
			
			//5.获得结果处理集合
			rt = st.executeQuery(sql);
			
			//6.处理执行结果
			while(rt.next()) {
				String cid = rt.getString(1);
				String cname = rt.getString(2);
				System.out.println(cid + " : " + cname);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				st.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				cnn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}

}
