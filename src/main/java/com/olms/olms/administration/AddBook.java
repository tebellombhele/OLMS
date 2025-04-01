package com.olms.olms.administration;


import com.olms.olms.bean.Book;
import com.olms.olms.databaseutility.BookDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * The type Add book.
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {


	@Override
	protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.html";
		// get current action
		String action = request.getParameter("action");
		if (action == null) {
			action = "join";
		}

		if (action.equals("join")) {
			url = "/index.jsp";    // the "join" page
		}
		else if (action.equals("add")) {
			System.out.println("enetres add");
			// get parameters from the request
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String pubdate = request.getParameter("pubdate");
			String quantity = request.getParameter("quantity");
			String bookid = request.getParameter("bookid");
			HttpSession session = request.getSession(true);
			session.setAttribute("bookid",bookid);
			System.out.println("book id is "+ session.getAttribute("bookid"));

			// store data in User object
			Book book = new Book(bookid, title, author, pubdate, quantity);

			// validate the parameters
			String message;
			{
				message = "The book has been successfully added";
				url = "/result.jsp";
				BookDatabase.insert(book);
			}
			request.setAttribute("book", book);
			request.setAttribute("message", message);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}