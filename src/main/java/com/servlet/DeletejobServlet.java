package com.servlet;

import java.io.IOException;

import com.dao.JobDAO;
import com.database.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/delete")
public class DeletejobServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			
			JobDAO dao=new JobDAO(DBConnect.getConn());
			boolean f=dao.deleteJob(id);
			
            HttpSession session = req.getSession();
			if(f){
				session.setAttribute("succMsg", "Job delete successfully...");
				resp.sendRedirect("addjob.jsp");
			}
			else{
				session.setAttribute("succMsg", "Something wrong on server..");
				resp.sendRedirect("addjob.jsp");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
