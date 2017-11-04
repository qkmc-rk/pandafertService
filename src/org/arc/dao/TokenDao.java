package org.arc.dao;

import java.util.List;

import org.arc.entity.Token;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��28�� ����5:19:44
 */
public interface TokenDao {
	
	int addOneToken(Token token);
	
	int deleteOneTokenByUserId(int userId);
	
	int updateOneToken(Token token);
	
	Token queryOneTokenByUserId(int uId);
	
	List<Token> queryAll();

	boolean deleteOneTokenByTokenId(int tokenId);
}