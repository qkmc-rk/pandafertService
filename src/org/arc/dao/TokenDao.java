package org.arc.dao;

import java.util.List;

import org.arc.entity.Token;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月28日 下午5:19:44
 */
public interface TokenDao {
	
	int addOneToken(Token token);
	
	int deleteOneTokenByUserId(int userId);
	
	int updateOneToken(Token token);
	
	Token queryOneTokenByUserId(int uId);
	
	List<Token> queryAll();

	boolean deleteOneTokenByTokenId(int tokenId);
}