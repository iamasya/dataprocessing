package servlets;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.SqlCRUD;

import Instruments.instrument;


/**
 * Servlet implementation class InstrumentServlet
 */

@WebServlet("/InstrumentServlet/*")
public class InstrumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LabCRUDInterface<instrument> crud = new SqlCRUD();
       
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub	
		
		crud = new SqlCRUD();
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			((SqlCRUD) crud).getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		setAccessControlHeaders(response);
		response.setContentType("application/json");
		//System.out.println(((SqlCRUD) crud).getConnection());
		response.getWriter().println(crud.read());
		
	}
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		setAccessControlHeaders(response);
		instrument instrument = Helpers.instrumentParse(request);
	
		crud.create(instrument);
		doGet(request, response);
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		instrument instrument = Helpers.instrumentParse(request);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		
		//System.out.println(id);
		response.setContentType("application/json");
		
		crud.update(id,instrument);
		doGet(request, response);
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		setAccessControlHeaders(response);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		//System.out.println(id);
		response.setContentType("application/json");
		
		crud.delete(id);
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
