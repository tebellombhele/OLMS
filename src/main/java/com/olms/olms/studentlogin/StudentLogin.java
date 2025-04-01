package com.olms.olms.studentlogin;


import com.olms.olms.bean.Book;
import com.olms.olms.databaseutility.BookDatabase;
import com.olms.olms.databaseutility.IssueDatabase;
import com.olms.olms.util.PasswordUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The type Student login.
 */
@WebServlet("/StudentLogin")

public class StudentLogin extends HttpServlet {
	@Override
	protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		String url = "/studentLogin.jsp";
		// get current action
		String action = request.getParameter("Action");
		// get current action
		String Action = request.getParameter("Action");

		if (Action == null) {
			Action = "Login";  // default action
		}
		else if (Action.equals("Login")) {
			String username=request.getParameter("username");
			String pass=request.getParameter("password");

			// check password strength requirements
			String message;
			try {
				PasswordUtility.checkPasswordStrength(pass);
				message = "";
			} catch (Exception e) {
				message = e.getMessage();
			}
			request.setAttribute("message", message);

			if(LoginDaoStudent.getName(username, pass) != null) {
				HttpSession session = request.getSession(true);
				ArrayList<Book> bookslist = new ArrayList<>();
				bookslist = BookDatabase.selectBooks();
				request.setAttribute("book", bookslist);
				url = "/studentDashboard.jsp";
			}

			else {
				PrintWriter out=response.getWriter();
				out.println("<script>window.location=\"studentLogin.jsp\";alert(\"Student Username Or Password Is Incorrect ...!\")</script>");
			}
			getServletContext().getRequestDispatcher(url).forward(request, response);

		}

		else if (Action.equals("view")){

			System.out.println("entered view");
			String username=request.getParameter("username");
			String pass=request.getParameter("password");

			HttpSession session = request.getSession(true);
			url = "/viewBooks.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		} else if (Action.equals("issue")){

			System.out.println("entered issue");
			String username=request.getParameter("username");
			String pass=request.getParameter("password");
			HttpSession session = request.getSession(true);
			String studentid = (String) session.getAttribute("studentid");
			System.out.println("student id is "+studentid);
			ArrayList<Book> issuelist = new ArrayList<>();
			issuelist=	IssueDatabase.issuedBooks(studentid);
			request.setAttribute("book", issuelist);
			System.out.println("Issued books are "+issuelist);
			url = "/viewIssuedBooks.jsp";

			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	}
}
