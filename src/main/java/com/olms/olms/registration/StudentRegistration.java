package com.olms.olms.registration;


import com.olms.olms.bean.Student;
import com.olms.olms.databaseutility.StudentDatabase;
import com.olms.olms.util.PasswordUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * The type Student register.
 */
@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {


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
		else if (action.equals("add")) {
			// get parameters from the request
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String sid = request.getParameter("sid");
			HttpSession session = request.getSession(true);
			session.setAttribute("studentid",sid);
			System.out.println("student id is "+ session.getAttribute("studentid"));

			// check strength requirements
			String message1;
			try {
				PasswordUtility.checkPasswordStrength(password);
				message1 = "";
			} catch (Exception e) {
				message1 = e.getMessage();
			}
			request.setAttribute("message", message1);

			// hash and salt password
			String hashedPassword;
			String salt = "";
			String saltedAndHashedPassword;
			try {
				hashedPassword = PasswordUtility.hashPassword(password);
				salt = PasswordUtility.getSalt();
				saltedAndHashedPassword = PasswordUtility.hashAndSaltPassword(password);

			} catch (NoSuchAlgorithmException ex) {
				hashedPassword = ex.getMessage();
				saltedAndHashedPassword = ex.getMessage();
			}
			request.setAttribute("hashedPassword", hashedPassword);
			request.setAttribute("salt", salt);
			request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);

			// store data in User object
			Student user = new Student(sid, username, saltedAndHashedPassword, firstName, lastName, email,salt);
			System.out.println("salting details before saving " + user);
			// validate the parameters
			String message;

			{
				message = "";
				url = "/thanks.jsp";
				StudentDatabase.insert(user);
			}
			request.setAttribute("user", user);
			request.setAttribute("message", message);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}