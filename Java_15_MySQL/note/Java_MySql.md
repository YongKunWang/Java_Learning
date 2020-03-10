# MySql操作

- MySql的安装过程

  1. 有一个doc文档，里面的东西进行参考
  2. 使用定制模式进行配置
  3. 需要设置字符集为utf-8 
  4. 必须设置密码

  

- 使用经过管理员授权的cmd窗口

```
net start/stop mysql 开启/停止 MySql数据库服务
```

- 输入账号密码

```
mysql -uroot -padmin
```

## 数据库操作

### 数据库操作

- 创建数据库

  ```
  create database  databaseName; 一定要添加分号
  ```

- 查看数据库

  ```
  show database databaseName;
  ```

- 删除数据库

  ```
  drop database databaseName;
  ```

- 使用数据库

  ```
  use databaseName;
  ```

- 查看正在使用的数据库

  ```
  select database();
  ```

### 数据库表操作

- 创建表

  ```sql
  create table name(字段名称 字段类型 [字段约束]);
  ```

- 查看表

  ```sql
  show tables;
  ```

- 查看表结构

  ```sql
  desc tableName;
  ```

- 删除表

  ```sql
  drop table name;
  ```

- 修改表

  ```sql
  alter table name add 列名 类型 约束；
  alter table name change 旧列名 新列名 类型 约束；
  alter table name modify 列名 类型 约束；
  alter table name drop 列名；
  rename table name to new name;
  alert table name character set utf-8;
  ```





## 单元测试

```java
package mysql1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 1. 单元测试的内容
 * 		在使用单元测试试，会自动引入Junit4的包，直接鼠标添加即可
 * 		在进行程序调试的时候直接调试@Test的函数即可
 * @author asdw1
 *
 */
public class TestDemo1 {

	public static void main(String[] args) {
		System.out.println("主函数输出语句...");
	}
	@Test
	public void testJunit() {
		System.out.println("Test输出...");
	}
	@Before
	public void testBefore() {
		System.out.println("TestBefore输出...");
	}
	@After
	public void testAfter() {
		System.out.println("TestAfter输出...");
	}
}

```

## JDBC编程基础

### 导入驱动到Java项目中

1. 需要设置工作空间的编码为UTF-8的格式

2. 导入驱动jar包

   2.1 新建lib文件

   2.2 复制jar文件到lib文件中

   2.3 点击Add to Build path成功  

### 程序代码

```java
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
            //Driver.jdbc.mysql.com
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
//Driver.jdbc.mysql.com
//jdbc.mysql://localhost:3306/xxx
```

### SQL语句注入的问题

#### SQL开启/关闭日志文件

1. 查看LOG功能

   首先，查看是否已经开启实时SQL语句记录。 

   ```
   mysql> SHOW VARIABLES LIKE "general_log%";
   ```

2. 临时开启日志文件

   ```
   mysql> SET GLOBAL general_log = 'ON';
   mysql> SET GLOBAL general_log_file = '/var/log/mysql/general_log.log';
   ```

   

```java
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

```

## 多表操作

```sql
# 一对多实现
# 创建分类表
CREATE TABLE category (

	cid VARCHAR(32) primary key,
	cname	varchar(100)
);

#创建商品表 使用反单引号的作用是为了与系统关键字区分
create table `product` (
	`pid` varchar(32) primary key,
	`name` varchar(40),
	`price` double

);

#添加外键字段
alter table product add column category_id VARCHAR(32);
#添加主键和外键约束
alter table product add CONSTRAINT product_fk FOREIGN KEY (category_id) references category(cid);

# 上述为一对多约束

#建立订单表
create table `orders` (
`oid` varchar(32) primary key,
`totalprice` double

);

#订单项表
create table orderitem (

	oid varchar(50),
	pid VARCHAR(50)
);

# 多对多
alter table orderitem add constraint orderitem_orders_fk foreign key(oid) references orders(oid);
alter table orderitem add constraint orderitem_product_fk foreign key(pid) references product(pid);

```

### mysql工具类版本

- 版本一：抽离相同功能
- 版本二：使用properties的ResourceBundle读取类
- 版本三：使用properties的自己的功能类

```java
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

```

## JDBC连接池&DBUtils

### 自定义第一版本的连接池

```java
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



```

```java
package pool_custom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class TestJdbcUtils {
	
	@Test
	public void testJunit()  {
		Connection conn = null;
		PreparedStatement ptst = null;
		ResultSet rt = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from category where cid=? and cname=?";
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, "c001");
			ptst.setString(2, "家电");
			
			rt = ptst.executeQuery();
			while(rt.next()) {
				System.out.println(rt.getString(1) + " : " + rt.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		}finally {
//			JdbcUtils.release(conn, ptst, rt);
//		}
	}
}

```

### 自定义第二版本的连接池

- 修改了使用close进行添加连接池

```java
/*
	增强Connection的功能
*/
package pool_custom2;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
/**
 * 1. 使用装饰器模式增强
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 1. 当理解了连接池的原理之后
 * 	定制一个连接池
 * @author asdw1
 * connection 是个接口
 */
public class MyJdbcConnection implements Connection {
	
	private Connection conn = null;
	//1. 创建一个存放连接的容器
	private LinkedList<Connection> pool = null;
	
	MyJdbcConnection(Connection conn, LinkedList<Connection> pool){
		this.conn = conn;
		this.pool = pool;
	}
	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		
		return conn.prepareStatement(sql);
	}
	@Override
	public void close() throws SQLException {
		pool.add(conn);
		
	}
	
	
	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void abort(Executor executor) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCatalog() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSchema() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSchema(String schema) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	


}


```

```java
package pool_custom2;

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
				MyJdbcConnection myconn = new MyJdbcConnection(conn, pool);
				pool.add(myconn);
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
				conn.close();
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


```

```java
package pool_custom2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class TestJdbcUtils {
	
	@Test
	public void testJunit()  {
		Connection conn = null;
		PreparedStatement ptst = null;
		ResultSet rt = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from category where cid=? and cname=?";
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, "c001");
			ptst.setString(2, "家电");
			
			rt = ptst.executeQuery();
			while(rt.next()) {
				System.out.println(rt.getString(1) + " : " + rt.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		}finally {
//			JdbcUtils.release(conn, ptst, rt);
//		}
	}
}

```

### C3P0连接池

需要的配置文件：

1. XML文件
2. `c3p0-0.9.1.2.jar`工具包
3. 自己写的C3P0的工具类

- C3P0的工具类

  ```java
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
  
  ```

### DBCP连接池

- 需要的配置文件：

  - 引入jar包：

    - commons-dbcp-1.4.jar
    - commons-pool-1.5.6.jar

  - 引入*.properties文件

    ```
    driver=com.mysql.jdbc.Driver
    url=jdbc:mysql://localhost:3306/testDemo1_db?useUnicode=true&characterEncoding=utf8
    username=root
    password=admin
    ```

    - 键一定要是这四个
    - 与上面的properties文件不一样！！！
    - 现在的错误就是这个问题！

```java
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

```

### DBUtils工具

```java
package dbutils;


import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import C3P0Demo.C3P0Utils;

/*
 * 测试DBUtils工具的增删改操作
 */


public class testDemo1 {

	public static void main(String[] args) {
		

	}
	
	@Test
	public void testAdd() {
		try {
			//得到数据源
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			String sql = "insert into person values(?,?)";
			Object[] params = {"001","aaa"};
			int rows = qr.update(sql,params);
			if(rows > 0) {
				System.out.println("添加成功...");
			}else {
				System.out.println("添加失败...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 通过id来修改
	 */
	@Test 
	public void testUpdateById() {
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			String sql = "update person set cname=? where cid=?";
			Object[] params = {"bbb","001"};
			int rows = qr.update(sql,params);
			if(rows > 0) {
				System.out.println("更新成功...");
			}else {
				System.out.println("更新失败...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testDeleteUserById() {
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			String sql = "delete from person where cid=?";
			Object[] params = {"001"};
			int rows = qr.update(sql,params);
			if(rows > 0) {
				System.out.println("删除成功...");
			}else {
				System.out.println("删除失败...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
```

```java
package dbutils;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import C3P0Demo.C3P0Utils;
import domain.Person;

public class TestDemo2 {

	public static void main(String[] args) {
		

	}
	
	@Test 
	public void testQueryAll() {
		try {
			// 1.获取核心类queryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.编写sql语句
			String sql = "select * from person";
			List<Person> persons = qr.query(sql,new BeanListHandler<Person>(Person.class));
			for(Person person : persons) {
				System.out.println(person.getCid() + " : " + person.getCname());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

```

