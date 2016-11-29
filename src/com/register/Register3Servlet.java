package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.*;
import static com.googlecode.objectify.ObjectifyService.ofy;

import com.GoogleApp.User;
import com.googlecode.objectify.ObjectifyService;
@SuppressWarnings("serial")
public class Register3Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();				
		ObjectifyService.register(User.class);
		
		out.println("<head>"
				
				+ "</head>");
		
		out.println("<body>");
		resp.getWriter().println("<div class='listHeader'><center>Lista zarejestrowanych:</center></div>" + "<br> <br>");
		
		List<User> allUsers = ofy().load().type(User.class).list();

		int userIndex = 1;
		for(User element : allUsers)
		{
			if(element != null)
			{
				resp.getWriter().println("<center>User " + userIndex + ": " + element.getUsername() + "</center><br>");
				resp.getWriter().println("<center>Password: " + element.getPassword() + "</center><br> <br>");
				resp.getWriter().println("<center>Email: " + element.getEmail() + "</center><br> <br>");
			}
			userIndex++;
		}
		out.println("<center><a href='/index.html' class='backBtn'>Powrót</a></center>");
		out.println("</body>");
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ObjectifyService.register(User.class);
		 
		  
	    String guestbookName = req.getParameter("name");
	    String content = req.getParameter("password");
	    String email= req.getParameter("email");
	  
	    	User user;
	      user = new User(guestbookName, content,email);
	   
	  
	    ObjectifyService.ofy().save().entity(user).now();
	     
	    
	    resp.sendRedirect("/register3");
	}
}

