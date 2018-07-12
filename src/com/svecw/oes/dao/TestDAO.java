package com.svecw.oes.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.svecw.oes.dao.util.DAOUtility;
import com.svecw.oes.dto.*;
import com.svecw.oes.exception.OESException;

public class TestDAO {
	public List<Test> getTests() throws OESException {
		PreparedStatement pstmt = null;
		List<Test> tests = new ArrayList<>();
		Test temp;
		ResultSet rs = null;
		try {
			String qstr1 = "select * from test";
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = new Test();
				temp.setTestId(rs.getInt(1));
				temp.setName(rs.getString(2));
				Timestamp stimestamp = rs.getTimestamp(3);
				java.util.Date uStartDate = new java.sql.Date(stimestamp.getTime());
				temp.setStartDate(uStartDate);
				Timestamp etimestamp = rs.getTimestamp(4);
				java.util.Date uEndDate = new java.sql.Date(etimestamp.getTime());
				temp.setEndDate(uEndDate);
				temp.setDuration(rs.getInt(4));
				tests.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pstmt) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new OESException(e.toString());
			}
		}
		return tests;
	}

	public int add(Test test) {
		PreparedStatement ps = null;
		int n = 0;
		final String query = "insert into test(test_name,start_time,end_time,duration) values(?,?,?,?)";

		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setString(1, test.getName());
			ps.setDate(2, new java.sql.Date(test.getStartDate().getTime()));
			ps.setDate(3, new java.sql.Date(test.getEndDate().getTime()));
			ps.setInt(4, test.getDuration());
			if (ps.executeUpdate() > 0) {
				List<Test> testsList = getTests();
				int size = testsList.size();
				return testsList.get(size - 1).getTestId();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OESException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (null != ps)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;

	}

	public List<Test> getPendingTests(String user) {
		PreparedStatement pstmt = null;
		List<Test> tests = new ArrayList<>();
		Test temp = null;
		String qstr1 = "select distinct t.test_id,t.test_name from test t, test_users tu where t.test_id = tu.test_id and tu.user_id = ? and t.test_id not in (select distinct test_id from score where user_id = ?)";
		try {
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setString(1, user);
			pstmt.setString(2, user);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = new Test();
				temp.setTestId(rs.getInt(1));
				temp.setName(rs.getString(2));
				tests.add(temp);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pstmt)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("From dao "+ tests);

		return tests;

	}

	/*public List<Report> getTestScores(String user) {
		PreparedStatement pstmt = null;
		List<Report> reports = new ArrayList<>();
		Report temp = new Report();
		int score = 0;
		ResultSet rs = null;
		String qstr1 = "select q.qid,t.test_name from score s,question q,test t where q.qid=s.qid and t.test_id=s.test_id and q.answers=s.answer and s.user_id=?";
		try {
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();
			if(rs.next()){
				temp.setTestName(rs.getString(2));
			while(rs.next()) {
				++score;
				
			}
			temp.setScore(score);
			
			reports.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pstmt)
					pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return reports;

	}*/
	
	
	
	public int getResult(String user,int testId) {
		PreparedStatement pstmt = null;
		int score = 0;
		ResultSet rs = null;
		String qstr1 = "select q.qid from score s,question q,test t where q.qid=s.qid and t.test_id=s.test_id and q.answers=s.answer and s.user_id=? and s.test_id=?";
		try {
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setString(1, user);
			pstmt.setInt(2, testId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				score++;					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pstmt)
					pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return score;

	}
	

	public boolean markQuestionsToTest(int test_id, int question_id) {
		PreparedStatement ps = null;
		int n = 0;
		final String query = "insert into test_question values(?,?)";

		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setInt(1, test_id);
			ps.setInt(2, question_id);
			n = ps.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (null != ps)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;
	}
	
	
	
	
	public List<Test> getTakenTests(String user) {
		PreparedStatement pstmt = null;
		List<Test> test = new ArrayList<>();
		Test temp;
		try {
			String qstr1 = "select t.test_id,t.test_name from test t where t.test_id in (select distinct s.test_id from score s where s.user_id=?)";
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setString(1,user);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				temp = new Test();
				temp.setTestId(rs.getInt(1));
				temp.setName(rs.getString(2));
				test.add(temp);
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
		return test;
	}
}