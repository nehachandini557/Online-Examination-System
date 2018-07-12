package com.svecw.oes.dao;

import com.svecw.oes.dao.util.DAOUtility;
import com.svecw.oes.dto.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollmentDAO {
	public boolean insert(Enrollment enrollment) {
		PreparedStatement pstmt = null;
		try {
			String qstr1 = "insert into test_users values(?,?)";
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setString(1, enrollment.getUids());
			pstmt.setInt(2, enrollment.getTest());
			if (pstmt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
			if (null != pstmt)				
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;

	}

}
