package com.olms.olms.administration;


import com.olms.olms.bean.Book;
import com.olms.olms.databaseutility.BookDatabase;
import com.olms.olms.databaseutility.IssueDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * The type Delete book.
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {


	@Override
	protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.html";
		// get current action
		String action = request.getParameter("action");
		if (action == null) {
			action = "join";  // default action
		}
		// perform action and set URL to appropriate page
		if (action.equals("join")) {
			url = "/index.jsp";    // the "join" page
		}
		else if (action.equals("delete")) {
			System.out.println("enetres delete");
			// get parameters from the request
			String bookid = request.getParameter("bookid");
			System.out.println();
			// validate the parameters
			String message;
			{
				message = "The book has been successfully deleted";
				url = "/deleteBook.jsp";
				Book book= BookDatabase.selectBook(bookid);
				IssueDatabase.deleteWithBookId(bookid);
				assert book != null;
				BookDatabase.delete(book);
			}
			request.setAttribute("message", message);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}