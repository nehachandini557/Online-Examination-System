
package com.svecw.oes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.svecw.oes.dao.util.DAOUtility;
import com.svecw.oes.dto.Administrator;
import com.svecw.oes.dto.User;
import com.svecw.oes.exception.OESException;

public class AdministratorDAO {	
	
	
	
	public boolean insert(Administrator administrator) {
		PreparedStatement pstmt = null;
		try {
			String qstr1 = "insert into administrators (admin_name,password,phonenumber,email_id) values (?,?,?,?)";
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setString(1, administrator.getName());
			pstmt.setString(2, administrator.getPassword());
			pstmt.setString(3, administrator.getPhoneNumber());
			pstmt.setString(4, administrator.getEmailId());
			if (pstmt.executeUpdate() > 0)
				return true;
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
		return false;
	}

	
	public Administrator getAdmin(int adminId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qstr1 = "select * from administrators where admin_id=?";
		Administrator administrator = null;
		try {
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setInt(1, adminId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				administrator = new Administrator();
				administrator.setname(rs.getString(2));
				administrator.setPassword(rs.getString(3));
				administrator.setPhoneNumber(rs.getString(4));
				administrator.setEmailId(rs.getString(5));
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null) {

					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return administrator;
	}

}
