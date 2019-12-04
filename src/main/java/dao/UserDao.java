package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import util.DBUtil;

public class UserDao {

	public boolean addUser(User user) {
		String sql = "INSERT INTO user(username,password,phone,address) VALUES(?,?,?,?)";
		return DBUtil.executeUpdate(sql, user.getUsername(), user.getPassword(), user.getPhone(),
				user.getAddress()) > 0;
	}

	public boolean queryByNameAndPwd(String username, String password) {
		String sql = "SELECT COUNT(*) FROM user WHERE username=? AND `password` = ?";
		Integer result = (Integer) DBUtil.executeQuery(sql, new DBUtil.ParseResultSet() {
			@Override
			public Object parse(ResultSet rs) {
				int result = 0;
				try {
					if (rs.next()) {
						result = rs.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return result;
			}
		}, username, password);
		return result > 0;
	}

	public boolean queryByName(String username) {
		String sql = "SELECT COUNT(*) FROM user WHERE username=?";
		Integer result = (Integer) DBUtil.executeQuery(sql, new DBUtil.ParseResultSet() {
			@Override
			public Object parse(ResultSet rs) {
				int result = 0;
				try {
					if (rs.next()) {
						result = rs.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return result;
			}
		}, username);
		return result > 0;
	}
}
