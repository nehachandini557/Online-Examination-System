package com.svecw.oes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.svecw.oes.dao.util.DAOUtility;
import com.svecw.oes.util.JSONUtility;
import com.svecw.oes.dto.Question;
import com.svecw.oes.exception.OESException;

public class QuestionDAO {
	public int add(Question question) throws OESException {
		PreparedStatement ps = null;
		final String query = "insert into question values(?,?,?,?,?,?,?,?)";
		JSONUtility obj = new JSONUtility();
		int n = 0;
		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setInt(1, question.getQuestionId());
			ps.setString(2, obj.convertJavatoJSON(question.getDescription()));
			ps.setString(3, obj.convertJavaListtoJSON(question.getOptions()));
			ps.setInt(4, question.getDifficultyId());
			ps.setInt(5, question.getSubjectId());
			ps.setInt(6, question.getChapterId());
			ps.setInt(7, question.getAnswer());
			ps.setString(8, question.getTitle());
			n = ps.executeUpdate();
			if (n > 0){
				List<Question> questionsList = getQuestions();
				int size = questionsList.size();
				return questionsList.get(size-1).getQuestionId();
			}
				} catch (SQLException e) {
			// TODO Auto-generated catch block
					throw new OESException(e.toString());
		}
		return -1;

	}
	
	
	public List<Question> getQuestions(int testId) throws OESException {
		String query = "select Q.* from question Q, test_question T where Q.qid = T.qid and T.test_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		;
		List<Question> list = null;
		Question temp = null;
		JSONUtility json = null;
		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setInt(1, testId);
			rs = ps.executeQuery();
			if (rs.next()) {
				list = new ArrayList<>();
				json = new JSONUtility();
				do {
					temp = new Question();

					temp.setQuestionId(rs.getInt(1));
					temp.setDifficultyId(rs.getInt(4));
					temp.setSubjectId(rs.getInt(5));
					temp.setChapterId(rs.getInt(6));
					temp.setAnswer(rs.getInt(7));
					temp.setDescription(json.convertJSONtoJava(rs.getString(2)));
					temp.setOptions(json.convertJSONtoJavaList(rs.getString(3)));
					temp.setTitle(rs.getString(8));
					list.add(temp);

				} while (rs.next());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();

		} finally {
			try {
				if (null != ps)
					ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new OESException(e.toString());
			}
		}

		return list;

	}
	public List<Question> getQuestions() throws OESException {
		String query = "select * from question ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		;
		List<Question> list = null;
		Question temp = null;
		JSONUtility json = null;
		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				list = new ArrayList<>();
				json = new JSONUtility();
				do {
					temp = new Question();

					temp.setQuestionId(rs.getInt(1));
					temp.setDifficultyId(rs.getInt(4));
					temp.setSubjectId(rs.getInt(5));
					temp.setChapterId(rs.getInt(6));
					temp.setAnswer(rs.getInt(7));
					temp.setDescription(json.convertJSONtoJava(rs.getString(2)));
					temp.setOptions(json.convertJSONtoJavaList(rs.getString(3)));
					temp.setTitle(rs.getString(8));
					list.add(temp);

				} while (rs.next());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();

		} finally {
			try {
				if (null != ps)
					ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new OESException(e.toString());
			}
		}

		return list;

	}

}
