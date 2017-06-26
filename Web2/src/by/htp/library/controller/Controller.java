package by.htp.library.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.connection.pool.CPFactory;
import by.htp.connection.pool.ConPool;
import by.htp.connection.pool.ConnectionPoolException;
import by.htp.library.command.Command;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private static final CommandProvider provider=new CommandProvider();  
    
    public Controller() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		//DBResourceManager db=DBResourceManager.getInstance();
		CPFactory ObjectFactory = CPFactory.getInstance();
		ConPool cp =ObjectFactory.getConPool();
		try {
			cp.initPoolData();
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commandName=request.getParameter("command");
		
		Command command=provider.getCommand(commandName);
		command.execute(request, response);
		
	}
	public void destroy(){
		super.destroy();
		CPFactory ObjectFactory = CPFactory.getInstance();
		ConPool cp =ObjectFactory.getConPool();
		cp.dispose();
	}

}
