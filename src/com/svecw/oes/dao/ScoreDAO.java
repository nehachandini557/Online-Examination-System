package com.svecw.oes.dao;

import com.svecw.oes.dao.util.DAOUtility;
import com.svecw.oes.dto.*;
import com.svecw.oes.exception.OESException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDAO {
	public int insertOptedAnswer(Score score) throws OESException {
		final String str = "insert into score values(?,?,?,?)";
		PreparedStatement ps = null;
		int rs = 0;
		try {
			ps = DAOUtility.getConnection().prepareStatement(str);
			ps.setString(1, score.getUserId());
			ps.setInt(2, score.getTestId());
			ps.setInt(3, score.getQuestionId());
			ps.setInt(4, score.getOptionSelected());
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) {
					ps.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new OESException(e.toString());
			}

		}
		return rs;
	}

	public int getScores(User user) throws OESException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int score = 0;
		String qstr1 = "select q.qid from score s, question q where s.user_id=? and s.qid = q.qid and s.answer = q.answers";
		try {
			pstmt = DAOUtility.getConnection().prepareStatement(qstr1);
			pstmt.setString(1, user.getUserId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				score++;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pstmt) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new OESException(e.toString());
			}
		}

		return score;
	}
}
