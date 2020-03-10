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
