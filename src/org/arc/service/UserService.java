package org.arc.service;

import java.util.List;

import org.arc.entity.Token;
import org.arc.entity.User;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��30�� ����12:38:08
 */
public interface UserService {
	
	User getUserByUserAccount(String uAccount);
	
	User getUserByUserId(int userId);
	
	Token getTokenByUserId(int uId);
	
	boolean saveUser(User user);
	
	boolean saveToken(Token token);
	
	boolean updateUser(User user);
	
	boolean updateToken(Token token);
	
	Token findToken(String token);
	
	List<User> querryAllUsers();
	
	List<Token> querryAllToken();
	
	boolean deleteUserById(int userId);
	
	boolean deleteTokenById(int tokenId);
}
