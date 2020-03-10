package mysql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * SQL语句注入的问题
 * @author asdw1
 *
 */
public class TestDemo4 {

	public static void main(String[] args) {
		try {
			//正常的查询操作
			login1("c005","家电5");
			//不正常的查询操作，主要使用了单引号的问题
			login1("c005' or 'c006","家电5");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			//正常的查询操作
			login2("c005","家电5");
			//不正常的查询操作，主要使用了单引号的问题
			login2("c005' or 'c006","家电5");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//1.常规操作 抛出异常
	public static void login1(String cid, String cname) throws ClassNotFoundException, SQLException {
		
		Connection cnn = null;
		Statement st = null;
		ResultSet rt = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","admin");
		
		st = cnn.createStatement();
		
		String sql = "select * from category where " + "cid= '" + cid + "' and cname='" + cname +"'";
		rt = st.executeQuery(sql);
		
		if(rt.next()) {
			System.out.println(rt.getString(1) + " : " + rt.getString(2));
		}else {
			System.out.println("查询失败！");
		}
		rt.close();
		st.close();
		cnn.close();
	}
	
	//2.使用预编译来操作sql
		public static void login2(String cid, String cname) throws ClassNotFoundException, SQLException {
			
			Connection cnn = null;
			PreparedStatement pst = null;
			ResultSet rt = null;
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得连接
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","admin");
			//3.书写sql语句
			String sql = "select * from category where cid= ? and cname= ? ";
			//4.创建预编译对象
			pst = cnn.prepareStatement(sql);
			//5.设置编译参数
			pst.setString(1, cid);
			pst.setString(2, cname);
		
			//!!!!!!!!!!这个地方绝对不能使用参数！！！！！！
			//因为这个地方调试错误2个小时！！！！！！
			rt = pst.executeQuery();
			
			if(rt.next()) {
				System.out.println(rt.getString(1) + " : " + rt.getString(2));
			}else {
				System.out.println("查询失败！");
			}
			
			rt.close();
			pst.close();
			cnn.close();
		}

}
