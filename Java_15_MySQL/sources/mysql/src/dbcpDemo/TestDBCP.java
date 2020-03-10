package dbcpDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import pool_custom.JdbcUtils;

public class TestDBCP {

	
	@Test
	public void Test() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rt = null;
		try {
			conn = DBCPUtils.getConnection();
			String sql = "select * from category where cid=? and cname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "c001");
			pstmt.setString(2, "家电");
			
			rt = pstmt.executeQuery();
			while(rt.next()) {
				System.out.println(rt.getString(1) + " : " + rt.getString(2));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.release(conn, pstmt, rt);
		}
		
		
		
		
	}
}
