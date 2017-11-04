package org.arc.dao;

import java.util.List;

import org.arc.entity.User;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月28日 下午4:54:25
 */
public interface UserDao {
	//add delete update query
	int addOneUser(User user);
	
	int deleteOneUserById(int uId);
	
	int updateOneUser(User user);
	
	User queryOneUserByAccount(String uAccount);
	
	User queryOneUserByUserId(int userId);
	
	List<User> queryAll();
}