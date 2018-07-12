package com.svecw.oes.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.svecw.oes.dao.QuestionDAO;
import com.svecw.oes.dao.UserDAO;
import com.svecw.oes.dto.Data;
import com.svecw.oes.dto.Question;
import com.svecw.oes.dto.User;

public class UserUtility {

	
	public List<User> buildUsers(String fileName){
		List<User> users = new ArrayList<User>();
		CSVReader reader = null;
		String[] line;
		try {
			reader = new CSVReader(new FileReader(fileName));
			while ((line = reader.readNext()) != null) {
				users.add(buildUser(line));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	
	public User buildUser(String[] cells) {
		User user = new User();
		UserDAO userDAO = new UserDAO();
		//Data data = new Data();
		//List<Data> options = new ArrayList<>();
		//question.setTitle(cells[0]);
		user.setUserId(cells[0]);
		user.setName(cells[1]);
		user.setPassword(cells[2]);
		user.setPhoneNumber(cells[3]);
		user.setEmailId(cells[4]);
		//data.setImage(Boolean.valueOf(cells[1]));
		//data.setText(cells[2]);
		//question.setDescription(data);
	/*	int j = 3;
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
		question.setAnswer(Integer.parseInt(cells[++j]));*/
		return user;
	}
	
}
