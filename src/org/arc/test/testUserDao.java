package org.arc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.arc.dao.UserDao;
import org.arc.dao.impl.UserDaoImpl;
import org.arc.entity.User;
import org.junit.Test;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 上午11:47:06
 */
public class testUserDao {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void m1(){
		UserDao ud = new UserDaoImpl();
		User user = new User(0, "ruan", "31445437", "1314", "1413", 1393935127, "qkmc@outlook.com");
		int a = ud.addOneUser(user);
		System.out.println(a);
	}
	@Test
	public void m2(){
		UserDao ud = new UserDaoImpl();
		System.out.println(ud.deleteOneUserById(1));
	}
	@Test
	public void m3(){
		UserDao ud = new UserDaoImpl();
		User user = new User(1, "ruan", "31445437", "1413", "1413", 1393935127, "qkmc@outlook.com");
		int a = ud.updateOneUser(user);
		System.out.println(a);
	}
	@Test
	public void m4(){
		UserDao ud = new UserDaoImpl();
		User user = ud.queryOneUserByAccount("31445437");
		System.out.println(user.getuMail());
	}
	@Test
	public void m5(){
		UserDao ud = new UserDaoImpl();
		List<User> list = ud.queryAll();
		System.out.println(list.get(0).getuMail());
	}
}
