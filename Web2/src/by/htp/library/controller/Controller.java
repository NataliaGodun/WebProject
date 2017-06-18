package by.htp.library.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println(request.getParameter("login"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("command"));*/
		String commandName=request.getParameter("command");
		Command command=provider.getCommand(commandName);
		command.execute(request, response);
		
	}

}
