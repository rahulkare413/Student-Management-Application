package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.StudentDao;
import Model.StudentDto1;
@WebServlet("/deleteLink")
public class Delete extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		deleteData(req,resp);
	}
	
	void deleteData(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("deleteEmail");
		
		StudentDto1 s3 = new StudentDto1();
		s3.setEmailId(email);
		
		StudentDao dao = new StudentDao();
		boolean delete = dao.deleteData(s3);
		
		req.setAttribute("DELETE", delete);
		
	try {
		req.getRequestDispatcher("delete.jsp").forward(req, resp);
	} catch (ServletException | IOException e) {
		
		e.printStackTrace();
	}
		
	}
}
