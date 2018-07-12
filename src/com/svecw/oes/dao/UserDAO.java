
package com.svecw.oes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.svecw.oes.dao.util.DAOUtility;
import com.svecw.oes.dto.User;
import com.svecw.oes.exception.OESException;

public class UserDAO {
	public UserDAO() {

	}

	public boolean insert(User user) {
		PreparedStatement pstmt = null;
		try {
			String qstr1 = "insert into users values (?,?,?,?,?)";
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getPhoneNumber());
			pstmt.setString(5, user.getEmailId());
			if (pstmt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pstmt)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public User getUser(String userId) throws OESException {
		PreparedStatement pstmt = null;
		User user = null;
		System.out.println("welcome");
		ResultSet rs = null;
		String qstr1 = "select * from users where user_id=?";

		try {
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhoneNumber(rs.getString(4));
				user.setEmailId(rs.getString(5));

			}

		} catch (SQLException e) {
			throw new OESException(e.toString());
		}

		finally {
			try {
				if (pstmt != null) {

					pstmt.close();
				}
				if (rs != null) {

					rs.close();
				}

			} catch (SQLException e) {
				throw new OESException(e.toString());
			}
		}
		return user;

	}

	public List<User> getUsers() {
		PreparedStatement pstmt = null;
		List<User> users = new ArrayList<>();
		User temp;
		try {
			String qstr1 = "select * from users";
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				temp = new User();
				temp.setUserId(rs.getString(1));
				temp.setName(rs.getString(2));
				temp.setPhoneNumber(rs.getString(4));
				temp.setEmailId(rs.getString(5));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pstmt) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

}
