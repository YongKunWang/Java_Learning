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
