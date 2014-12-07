package org.aricent.cloud.talkrds.action;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

import org.aricent.cloud.talkrds.service.TalkRdsService;
import org.aricent.cloud.talkrds.service.TalkRdsServiceImpl;
import org.aricent.cloud.talkrds.vo.UserVO;

import java.io.PrintWriter; 
import java.sql.SQLException;
import java.util.List;

public class LoginAction extends HttpServlet 
{ 
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		// reading the user input 
		String admin= request.getParameter("userName"); 	
		String pass= request.getParameter("userPass"); 	
		
		response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
	   
	    out.println("This site has been accessed " + admin + " times.");
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		// reading the user input 
		String admin= request.getParameter("userName"); 	   	   
		String pass= request.getParameter("userPass");
		
	    response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
	   
	    
	    TalkRdsService talkToRds = new TalkRdsServiceImpl();
	    
	    boolean isUserValid;
		try {
			isUserValid = talkToRds.validateUser(admin, pass);
			
			if(isUserValid){
		    	 
				 HttpSession session = request.getSession(true); 
				 session.setAttribute("currentSessionUser",admin);
				 
				 String users = "List of users in database : ";
				 String rdsEndPoint = "RDS Endpoint : ";
				 if(admin.equals("admin")){
					 
					 users += talkToRds.getUsers();
					 request.setAttribute("userList", users);
					 
					 rdsEndPoint += talkToRds.getRdsEndPoint();
					 request.setAttribute("rdsEndPoint", rdsEndPoint);
				 }
				 
				 RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.jsp");
			     rd.forward(request, response);
		    }
			
			else{
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/failure.jsp");
	            out.println("<font color=red>Either user name or password is wrong.</font>");
	            rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	    
	   out.close();
	} 
}
