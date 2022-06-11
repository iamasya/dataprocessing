package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Instruments.instrument;
import crud.Lab2CrudInterface;
import Instruments.Mock;

/**
 * Servlet implementation class InstrumentServlet
 */
@WebServlet("/InstrumentServlet/*")
public class InstrumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<instrument> lu = new Mock().getInstrumentList();
       
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
		
		setAccessControlHeaders(response);
		response.setContentType("application/json");
		response.getWriter().println(lu);
		
	}
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		setAccessControlHeaders(response);
		instrument instrument = Helpers.instrumentParse(request);
		instrument.setId(Helpers.getNextId(lu));
		lu.add(instrument);
		doGet(request, response);
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		instrument instrument = Helpers.instrumentParse(request);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		System.out.println(id);
		response.setContentType("application/json");
		int index = Helpers.getIndexByinstrumentId(id, lu);
		lu.set(index,instrument);
		doGet(request, response);
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		setAccessControlHeaders(response);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		System.out.println(id);
		response.setContentType("application/json");
		int index = Helpers.getIndexByinstrumentId(id, lu);
		lu.remove(index);
		doGet(request, response);
		
	}
	
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setStatus(HttpServletResponse.SC_OK);

	}
	
	private void setAccessControlHeaders(HttpServletResponse resp) {
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "*");
		resp.setHeader("Access-Control-Allow-Headers", "*");
	
	}

}
