package com.svecw.oes.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.svecw.oes.dao.QuestionDAO;
import com.svecw.oes.dto.Data;
import com.svecw.oes.dto.Question;
import com.svecw.oes.exception.OESException;

public class QuestionFileUtility {

/*	public static void main(String[] args) {
		QuestionFileUtility obj = new QuestionFileUtility();
		List<Question> questions = obj.buildQuestions("/home/user/Desktop/questions1.csv");
		System.out.println(questions);
	}*/

	public List<Question> buildQuestions(String fileName) {
		List<Question> questions = new ArrayList<Question>();
		CSVReader reader = null;
		String[] line;
		try {
			reader = new CSVReader(new FileReader(fileName));
			while ((line = reader.readNext()) != null) {
				questions.add(buildQuestion(line));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}

	public Question buildQuestion(String[] cells) {
		Question question = new Question();
		QuestionDAO questionDao = new QuestionDAO();
		Data data = new Data();
		List<Data> options = new ArrayList<>();
		question.setTitle(cells[0]);
		data.setImage(Boolean.valueOf(cells[1]));
		data.setText(cells[2]);
		question.setDescription(data);
		int j = 3;
		while (cells[j].equals("TRUE") ||cells[j].equals("FALSE") ) {
			data = new Data();
			data.setImage(Boolean.valueOf(cells[j]));
			data.setText(cells[++j]);
			options.add(data);
			j++;
		}
		question.setOptions(options);
		question.setDifficultyId(Integer.parseInt(cells[j]));
		question.setSubjectId(Integer.parseInt(cells[++j]));
		question.setChapterId(Integer.parseInt(cells[++j]));
		question.setAnswer(Integer.parseInt(cells[++j]));
		return question;
	}
}
