package com.olms.olms.administration;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * The type Admin login.
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("adminName");
		String pass=request.getParameter("password");
		PrintWriter out=response.getWriter();
		if(name.equals("admin") && pass.equals("admin123")) {
			HttpSession adminSession=request.getSession(true);
			adminSession.setAttribute("adminName", "Admin");
			request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
		}
		else {
			out.println("<script>window.location=\"adminLogin.jsp\";alert(\"Admin Name Or Password Is Incorrect ...!\")</script>");
		}
		out.close();
	}
}
