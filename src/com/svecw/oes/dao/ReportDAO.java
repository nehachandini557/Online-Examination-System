package com.svecw.oes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.svecw.oes.dao.util.DAOUtility;
import com.svecw.oes.dto.User;
import com.svecw.oes.exception.OESException;
public class ReportDAO {
	public  List<User> getTestUsers(int testId) throws OESException{
		PreparedStatement pstmt = null;
		String qstr1 = "select distinct u.user_id,u.user_name from users u ,test_users tu,score s where tu.test_id=? and u.user_id=tu.user_id and tu.user_id=s.user_id";
		List<User> users = new ArrayList<>();
		User temp;
		try {
			pstmt =  DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setInt(1,testId);
			ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            temp = new User();
            temp.setUserId(rs.getString(1));
            temp.setName(rs.getString(2));
            users.add(temp);
		
       }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				if(null != pstmt)
				pstmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new OESException(e.toString());
			}
		}
		return users;	
	}

	}
