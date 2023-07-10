package by.htp.ex.controller;

import java.io.IOException;

import by.htp.ex.dao.conPool.ConnectionPool;
import by.htp.ex.dao.conPool.ConnectionPoolException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider provider = new CommandProvider();
    private final ConnectionPool pool = ConnectionPool.getInstance();
	
    public FrontController() {
        super();
    }
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			pool.initPoolData();
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			 throw new ServletException("class not founf");
		} catch (ConnectionPoolException e) {
			
			throw new ServletException("Connection pool not initialized");
		}
	}


	

		
		

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
				
		System.out.println("Pool died");
		pool.dispose();
		
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String commandName = request.getParameter("command");

		Command command = provider.getCommand(commandName);
		command.execute(request, response);
	
	
	}
	
}