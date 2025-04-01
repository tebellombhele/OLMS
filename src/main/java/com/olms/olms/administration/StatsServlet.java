package com.olms.olms.administration;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * The type Stats servlet.
 */
@WebServlet("/StatsServlet")
public class StatsServlet extends HttpServlet {
    @Override
    public void log(String message, Throwable t) {
        super.log(message, t);
    }

    /**
     * Instantiates a new Stats servlet.
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO CLASS METHOD


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
