package org.arc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.arc.dao.TokenDao;
import org.arc.entity.Token;
import org.arc.util.JdbcUtilC3p0;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 下午12:38:04
 */
public class TokenDaoImpl implements TokenDao {

	@Override
	public int addOneToken(Token token) {
		//创建qr对象
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		//准备sql
		String sql = "insert into t_token(token,user_id)values(?,?)";
		try {
			int update = qr.update(sql, token.getToken(),token.getUserId());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteOneTokenByUserId(int userId) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "delete from t_token where user_id = ?";
		try {
			int update = qr.update(sql, userId);
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateOneToken(Token token) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "update t_token set token = ?,user_id = ? where token_id=?";
		try {
			int update = qr.update(sql, token.getToken(),token.getUserId(),token.getTokenId());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Token queryOneTokenByUserId(int uId) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_token where user_id = ?";
		try {
			List<Token> tokenlist = qr.query(sql, new TokenHandler(),uId);
			Token token = tokenlist.get(0);
			return token;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Token> queryAll() {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_token";
		try {
			List<Token> tokenlist = qr.query(sql, new TokenHandler());
			return tokenlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteOneTokenByTokenId(int tokenId) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "delete from t_token where token_id = ?";
		try {
			qr.update(sql, tokenId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
