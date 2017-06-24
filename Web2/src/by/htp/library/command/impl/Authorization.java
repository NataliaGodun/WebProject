package by.htp.library.command.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.command.Command;
import by.htp.library.domain.User;
import by.htp.library.service.ServiceFactory;
import by.htp.library.service.UserService;
import by.rdtc.service.exception.ServiceException;

public class Authorization implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		
		login=request.getParameter("login");
		password=request.getParameter("password");
		
		ServiceFactory factory=ServiceFactory.getInstance();
		UserService userService=factory.getUserService();
		
		User user = null;
		try {
			user = userService.authorization(login, password);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		String page;
		if (user!=null){
			request.setAttribute("user", user);
			page="WEB-INF/jsp/main.jsp";
		}else{
			request.setAttribute("errorMessage", "wrong login or password");
			page="index.jsp";
			
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(page);
		
			dispatcher.forward(request, response);
		
		
	}

}
