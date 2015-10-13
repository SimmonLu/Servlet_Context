package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by simon on 10/13/15.
 */
@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        Integer hits = (Integer)context.getAttribute("hits");

        if(hits == null) {
            hits = 0;
        }
        else {
            hits++;
        }

        context.setAttribute("hits", hits);

        PrintWriter out = response.getWriter();

        out.println("Hits: " + hits);

    }
}
