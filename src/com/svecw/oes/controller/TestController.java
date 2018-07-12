package com.svecw.oes.controller;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.svecw.oes.dao.QuestionDAO;
import com.svecw.oes.dao.ScoreDAO;
import com.svecw.oes.dao.TestDAO;
import com.svecw.oes.dto.Question;
import com.svecw.oes.dto.Report;
import com.svecw.oes.dto.Score;
import com.svecw.oes.dto.Test;
import com.svecw.oes.exception.OESException;
import com.svecw.oes.util.OptionUtility;
import com.svecw.oes.util.QuestionFileUtility;

@WebServlet("/TestController")
/**
 * Servlet implementation class demo
 */
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, String> answerMap = new HashMap<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession httpSession = request.getSession();
		if (action.equals("take_test")) {
			int testID = Integer.parseInt(request.getParameter("testId"));
			httpSession.setAttribute("testId", testID);
			List<Question> questions;
			try {
				questions = new QuestionDAO().getQuestions(testID);
				httpSession.setAttribute("questionsList", questions);
				int j = 1;
				if (questions != null) {
					for (Question question : questions) {
						question.setSelectedAnswer(0);
						if (question.getAnswer() == 8 || question.getAnswer() == 4 || question.getAnswer() == 2
								|| question.getAnswer() == 1) {
							question.setMultiAnswered(false);
						} else {
							question.setMultiAnswered(true);
						}
						String str = "";
						for (int i = 0; i < question.getOptions().size(); i++) {
							str += "0";
						}
						answerMap.put(Integer.toString(j), str);
						j++;
					}
					httpSession.setAttribute("current_qno", 1);
					httpSession.setAttribute("map", answerMap);
					response.sendRedirect("TestDisplay.jsp");
					// request.getRequestDispatcher("TestDisplay.jsp").forward(request,
					// response);
					

				} else {
					httpSession.setAttribute("errorMessage", "No questions");
					response.sendRedirect("UserTests.jsp");
					// request.getRequestDispatcher("UserTests.jsp").forward(request,
					// response);

				}
			} catch (OESException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("view_tests")) {

			if (httpSession.getAttribute("loggedUser") != null) {
				TestDAO testDAO = new TestDAO();
				List<Test> tests = testDAO.getPendingTests((String) httpSession.getAttribute("loggedUserID"));
				if (tests != null && tests.size() != 0) {
					httpSession.setAttribute("tes", tests);
					response.sendRedirect("UserTests.jsp");
				} else {
					response.sendRedirect("UserTests.jsp");
				}

			}
		} else if (action.equals("view_reports")) {
			try {
				if (httpSession.getAttribute("loggedUser") != null) {
					TestDAO testDAO = new TestDAO();
					List<Test> test = testDAO.getTakenTests((String) httpSession.getAttribute("loggedUserID"));
					HashMap results = new HashMap<>();
					if (test != null && test.size() != 0) {
						System.out.println("Reports exists");
						for (Test takentests : test) {
							int scores = testDAO.getResult((String) httpSession.getAttribute("loggedUserID"),
									takentests.getTestId());
							results.put(takentests.getName(), scores);
						}
						httpSession.setAttribute("results", results);
						response.sendRedirect("UserReports.jsp");
					} else {
						response.sendRedirect("UserReports.jsp");
						
					}

				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else if (action.equals("create_test")) {
			// response.sendRedirect("createTest.jsp");
			request.getRequestDispatcher("createTest.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		HttpSession httpSession = request.getSession();
		if (isMultipart) {
			DiskFileItemFactory dis = new DiskFileItemFactory();
			ServletFileUpload sfd = new ServletFileUpload(dis);
			try {
				List<FileItem> list = sfd.parseRequest(request);
				Test test = new Test();
				String imagePath = "";
				for (FileItem fileItem : list) {
					if (!fileItem.isFormField()) {
						imagePath = "/home/user/oes/workspace/" + getServletContext().getContextPath()
								+ "/WebContent/csvs/" + fileItem.getName();
						fileItem.write(new File(imagePath));
						httpSession.setAttribute("success", "FileLoaded successfully");
						
					} else {
						if (fileItem.getFieldName().equals("name")) {
							test.setName(fileItem.getString());
						} else if (fileItem.getFieldName().equals("startDate")) {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							test.setStartDate(format.parse(fileItem.getString()));
						} else if (fileItem.getFieldName().equals("endDate")) {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							test.setEndDate(format.parse(fileItem.getString()));

						} else if (fileItem.getFieldName().equals("duration")) {
							test.setDuration(Integer.parseInt(fileItem.getString()));
						}
					}
				}
				int testId = new TestDAO().add(test);
				List<Question> questions = new QuestionFileUtility().buildQuestions(imagePath);
				for (Question question : questions) {
					int questionId = new QuestionDAO().add(question);
					new TestDAO().markQuestionsToTest(testId, questionId);
				}
				
				response.sendRedirect("AdminHomePage.jsp");
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			 httpSession = request.getSession();
			int val = 0;
			if (httpSession.getAttribute("current_qno") != null)
				val = (int) httpSession.getAttribute("current_qno");
			List<Question> questions = (List<Question>) httpSession.getAttribute("questionsList");
			Map<String, String> answers = (Map<String, String>) httpSession.getAttribute("map");
			String str3 = "";
			for (int i = 0; i < questions.get(val - 1).getOptions().size(); i++) {
				str3 += "0";
			}
			String str2 = "";
			StringBuilder str = new StringBuilder(str3);
			int[] arr;
			String[] checked = request.getParameterValues("c" + Integer.toString(val));
			if (checked != null) {
				for (int j = 0; j < checked.length; j++) {
					str.setCharAt(Integer.parseInt(checked[j]), '1');
				}
				str2 = str.toString();
			}
			String str1 = "";
			String checked1 = request.getParameter("r" + Integer.toString(val));
			if (checked1 != null) {
				for (int j = 0; j < str3.length(); j++) {
					if (Integer.toString(j).equals(checked1)) {
						str1 += "1";
					} else {
						str1 += "0";
					}
				}
				str2 = str1;
			}
			if (str2.equals("")) {
				str2 = str3;
			}
			OptionUtility ou = new OptionUtility();
			int dec = ou.binaryToDecimal(str2);
			questions.get(val - 1).setSelectedAnswer(dec);
			httpSession.setAttribute("questionsList", questions);
			answers.put(Integer.toString(val), str2);
			httpSession.setAttribute("map", answers);
			String value1 = request.getParameter("link");
			if ("<-prev".equals(value1)) {
				httpSession.setAttribute("current_qno", val - 1);
				response.sendRedirect("TestDisplay.jsp");
			} else if ("next->".equals(value1)) {
				httpSession.setAttribute("current_qno", val + 1);
				response.sendRedirect("TestDisplay.jsp");
			} else if ("Finish".equals(value1)) {
				ScoreDAO obj = new ScoreDAO();
				String userId = (String) httpSession.getAttribute("loggedUserID");
				int testId = (int) httpSession.getAttribute("testId");
				for (Question question : questions) {
					Score score = new Score(userId, testId, question.getQuestionId(), question.getSelectedAnswer());
					try {
						int k = obj.insertOptedAnswer(score);
					} catch (OESException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				TestDAO testDAO = new TestDAO();

				int score = testDAO.getResult((String) httpSession.getAttribute("loggedUserID"),
						(int) httpSession.getAttribute("testId"));
				httpSession.removeAttribute("testId");
				httpSession.setAttribute("scores", score);
				response.sendRedirect("score.jsp");
			} else {
				httpSession.setAttribute("current_qno", Integer.parseInt(value1));
				response.sendRedirect("TestDisplay.jsp");
			}
		}
	}
}
