package org.arc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.arc.entity.Token;
/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 下午12:45:37
 */
public class TokenHandler implements ResultSetHandler<List<Token>> {

	@Override
	public List<Token> handle(ResultSet rs) throws SQLException {
		List<Token> tokenList= new ArrayList<>();
		Token token;
		while(rs.next()){
			token = new Token();
			token.setTokenId(rs.getInt(1));
			token.setToken(rs.getString(2));
			token.setUserId(rs.getInt(3));
			tokenList.add(token);
			token = null;
		}
		return tokenList;
	}

}
