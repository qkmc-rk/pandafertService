package org.arc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.arc.entity.User;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 下午12:22:51
 */
public class UserHandler implements ResultSetHandler<List<User>>{

	@Override
	public List<User> handle(ResultSet rs) throws SQLException {
		List<User> userList= new ArrayList<>();
		User user;
		while(rs.next()){
			user = new User();
			user.setuId(rs.getInt(1));
			user.setuNeckName(rs.getString(2));
			user.setuAccount(rs.getString(3));
			user.setuPassword(rs.getString(4));
			user.setuOldPwd(rs.getString(5));
			user.setuPhone(rs.getInt(6));
			user.setuMail(rs.getString(7));
			userList.add(user);
			user = null;
		}
		return userList;
	}

}
