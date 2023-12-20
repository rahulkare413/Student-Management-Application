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

@WebServlet("/stud")
public class Display extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
			displayData(req,resp);

		}
		
		void displayData(HttpServletRequest req, HttpServletResponse resp) {
			StudentDao dao = new StudentDao();
			ArrayList<StudentDto1> studentData= dao.displayData();
			
			
			req.setAttribute("STUDENT", studentData);
			try {
				req.getRequestDispatcher("show.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				
				e.printStackTrace();
			}
			
			}

}
