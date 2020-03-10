package mysql1;
//这个地方也要注意
//引入的是java.sql.*的包
import java.sql.*;


public class TestDemo2 {

	public static void main(String[] args) {
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. 注册驱动
			//此时使用的是字节码文件 采用全类名的方法
			//此时类还没有加载进入内存
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 获得连接
			conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","admin");
			
			//3. 获得语句执行者
			stmt = conn.createStatement();
			
			//4.编写sql语句
			String sql = "select * from category";
			
			//5. 执行sql语句
			rs = stmt.executeQuery(sql);
			//6. 处理结果
			//此时rs内部有一个游标进行指向
			//一开始指向头部
			//rs.next指向第一行
			while(rs.next()) {
				//getxxx(index);
				//xxx表示要获得的数据类型变量
				// index表示列数
				String cid = rs.getString(1);
				String cname = rs.getString(2);
				System.out.println(cid +" : "+ cname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
