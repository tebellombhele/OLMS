package com.olms.olms.administration;

import com.olms.olms.bean.Book;
import com.olms.olms.databaseutility.BookDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * The type Update book.
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	@Override
	protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.html";
		String action = request.getParameter("action");
		if (action == null) {
			action = "join";
		}
		if (action.equals("join")) {
			url = "/index.jsp";    // the "join" page
		}
		else if (action.equals("update")) {
			System.out.println("enetres add");
			// get parameters from the request
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String pubdate = request.getParameter("pubdate");
			String quantity = request.getParameter("quantity");
			String bookid = request.getParameter("bookid");


			// store data in User object
			Book book = new Book(bookid, title, author, pubdate, quantity);
			System.out.println("look for" + book);

			// validate the parameters
			String message;

			{
			    message = "The book has been successfully updated";
			    url = "/updateBook.jsp";
			    BookDatabase.update(book);
			}
			request.setAttribute("book", book);
			request.setAttribute("message", message);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}