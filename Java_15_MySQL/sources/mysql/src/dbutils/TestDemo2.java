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
