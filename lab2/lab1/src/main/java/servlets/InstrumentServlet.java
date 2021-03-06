package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import Instruments.instrument;
import crud.Lab2CrudInterface;

/**
 * Servlet implementation class InstrumentServlet
 */
@WebServlet("/InstrumentServlet")
public class InstrumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletConfigInterface servletConfig;
	Lab2CrudInterface lab2Crud;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        this.servletConfig = new ServletConfig();
        this.lab2Crud = servletConfig.getCrud();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out = response.getWriter();
		out.println("["+lab2Crud.readInstrument()+"]");
	}
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String info = request.getParameter("info");
		int price = Integer.parseInt(request.getParameter("price"));
		
		lab2Crud.updateInstrument(new instrument(title, info, price));
	}

}
