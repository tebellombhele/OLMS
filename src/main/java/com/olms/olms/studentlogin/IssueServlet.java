package com.olms.olms.studentlogin;


import com.olms.olms.bean.Issue;
import com.olms.olms.databaseutility.IssueDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * The type Issue servlet.
 */
@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {


	@Override
	protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.html";

		// get current action
		boolean issue = request.getParameter("issue") != null;
		boolean remove = request.getParameter("remove") != null;
		HttpSession session = request.getSession(true);

		if (issue) {
			String bookid = request.getParameter("bookid");
			System.out.println("My book"+ bookid);
			String studentid = (String) session.getAttribute("studentid");
			Issue issue1 = new Issue(bookid,studentid);
			url = "/viewBooks.jsp";
			IssueDatabase.insert(issue1);

		} else if (remove) {
			String bookid = request.getParameter("bookid");
			String studentid = (String) session.getAttribute("studentid");
			Issue issue1 = new Issue(bookid,studentid);
			url = "/viewBooks.jsp";
			IssueDatabase.delete(issue1);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}