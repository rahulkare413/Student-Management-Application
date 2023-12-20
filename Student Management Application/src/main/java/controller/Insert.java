package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.StudentDao;
import Model.StudentDto1;

@WebServlet("/mvcLink3")
//@WebServlet("/updateLink")
public class Insert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String action = req.getServletPath();
	        
	      addData(req, resp);
		
	}
	
	
	
	void addData(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");
		String yop = req.getParameter("yop");
		int totalMarks = Integer.parseInt(req.getParameter("totalMarks"));
		int outOfMarks = Integer.parseInt(req.getParameter("outmarks"));
		
		StudentDto1 s1 = new StudentDto1();
		s1.setEmailId(email);
		s1.setContactNumber(contact);
		s1.setYearOfPassOut(yop);
		s1.setTotalMarks(totalMarks);
		s1.setOutOfMarks(outOfMarks);
		
		StudentDao dao = new StudentDao();
		boolean output = dao.addData(s1);
		

	}
	
}
		


