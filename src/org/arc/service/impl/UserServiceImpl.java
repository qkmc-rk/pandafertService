package org.arc.service.impl;

import java.util.List;

import org.arc.dao.TokenDao;
import org.arc.dao.UserDao;
import org.arc.dao.impl.TokenDaoImpl;
import org.arc.dao.impl.UserDaoImpl;
import org.arc.entity.Token;
import org.arc.entity.User;
import org.arc.service.UserService;
import org.arc.util.TokenGenerator;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月30日 下午12:40:49
 */
public class UserServiceImpl implements UserService{

	UserDao ud = new UserDaoImpl();
	TokenDao td = new TokenDaoImpl();
	
	@Override
	public Token getTokenByUserId(int uId) {
		Token token = td.queryOneTokenByUserId(uId);
		return token;
	}

	@Override
	public boolean saveUser(User user) {
		int add = ud.addOneUser(user);
		if(add > 0){
			//用户注册后，一定要生成其对应的令牌，不然手机端无法登陆
			Token token = new Token();
			int userid = getUserByUserAccount(user.getuAccount()).getuId();
			token.setToken(TokenGenerator.tokenGenerate(user.getuPassword()));
			token.setUserId(userid);
			td.addOneToken(token);
			return true;
		}
		return false;
	}

	@Override
	public User getUserByUserAccount(String uAccount) {
		User user = ud.queryOneUserByAccount(uAccount);
		return user;
	}

	@Override
	public Token findToken(String token) {
		List<Token> tokenList = td.queryAll();
		for(Token t: tokenList){
			if(t.getToken().equals(token)){
				return t;
			}
		}
		return null;
	}

	@Override
	public User getUserByUserId(int userId) {
		User user = ud.queryOneUserByUserId(userId);
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		if(ud.updateOneUser(user) < 1)
			return false;
		return true;
	}

	@Override
	public boolean updateToken(Token token) {
		if(td.updateOneToken(token) < 1){
			return false;
		}
		return true;
	}

	@Override
	public List<User> querryAllUsers() {
		return ud.queryAll();
	}

	@Override
	public List<Token> querryAllToken() {
		List<Token> tokens = td.queryAll();
		return tokens;
	}

	@Override
	public boolean saveToken(Token token) {
		if(td.addOneToken(token) < 1)
			return false;
		return true;
	}

	@Override
	public boolean deleteUserById(int userId) {
		if(ud.deleteOneUserById(userId) < 1)
			return false;
		return true;
	}

	@Override
	public boolean deleteTokenById(int tokenId) {
		if(td.deleteOneTokenByTokenId(tokenId))
			return true;
		return false;
	}

}
