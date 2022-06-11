package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import entity.instruments;

/**
 * Servlet implementation class servlet1
 */

@WebServlet("/servlet1")

public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/json");	
		PrintWriter out = response.getWriter();
		
		instruments entity = new instruments("Guitar", "Epiphone Blue Electric Guitar", 1249.5f);
		
		out.println("["+entity+"]");
	}

}
