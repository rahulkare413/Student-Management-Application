package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.StudentDao;
import Model.StudentDto1;
@WebServlet("/updateLink")
public class Update extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		updateData(req,resp);
		
	}
	void updateData(HttpServletRequest req, HttpServletResponse resp) {
	String email = req.getParameter("emailId");
		int totalMarks = Integer.parseInt(req.getParameter("gainmarks"));
		
		StudentDto1 s2 = new StudentDto1();
		s2.setEmailId(email);
		s2.setTotalMarks(totalMarks);
		
		StudentDao dao = new StudentDao();
		boolean update = dao.updateData(s2);
		
		req.setAttribute("UPDATE", update);
		
		try {
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
