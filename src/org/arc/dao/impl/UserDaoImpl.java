package org.arc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.arc.dao.UserDao;
import org.arc.entity.User;
import org.arc.util.JdbcUtilC3p0;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 上午11:38:06
 */
public class UserDaoImpl implements UserDao {

	@Override
	public int addOneUser(User user) {
		//创建qr对象
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		//准备sql
		String sql = "insert into t_userinfo(u_neckname,u_account,u_password,u_oldpwd,u_phone,u_mail)"
				+ "values(?,?,?,?,?,?)";
		try {
			int update = qr.update(sql, user.getuNeckName(),user.getuAccount(),user.getuPassword()
					,user.getuOldPwd(),user.getuPhone(),user.getuMail());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteOneUserById(int uId) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "delete from t_userinfo where u_id = ?";
		try {
			int update = qr.update(sql, uId);
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateOneUser(User user) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "update t_userinfo set u_neckname=?,u_account=?,u_password=?,u_oldpwd=?,u_phone=?"
				+ ",u_mail=? where u_id=?";
		try {
			int update = qr.update(sql, user.getuNeckName(),user.getuAccount(),user.getuPassword()
					,user.getuOldPwd(),user.getuPhone(),user.getuMail(),user.getuId());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User queryOneUserByAccount(String uAccount) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_userinfo where u_account = ?";
		try {
			List<User> userlist = qr.query(sql, new UserHandler(),uAccount);
			if(!userlist.isEmpty()){
				User user = userlist.get(0);
				return user;
			}else{
				return null;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> queryAll() {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_userinfo";
		try {
			List<User> userlist = qr.query(sql, new UserHandler());
			return userlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User queryOneUserByUserId(int userId) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_userinfo where u_id = ?";
		try {
			List<User> userlist = qr.query(sql, new UserHandler(),userId);
			User user = userlist.get(0);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
