package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;



@WebServlet("/UserServlet")
public class UserDAO extends HttpServlet
{
  @Override
  protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
  {
	  PrintWriter out = resp.getWriter();
	  
	  String myname = req.getParameter("name");
	  String myemail = req.getParameter("email");
	  String mypassword = req.getParameter("password");
	  String myrole = req.getParameter("role");
	  String myid = req.getParameter("id");
	  
	  try
	  {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_db","root","756126");
		 
		 PreparedStatement ps = con.prepareStatement("insert into users value(?,?,?,?,?)");
		 ps.setString(1, myid);
		 ps.setString(2, myname);
		 ps.setString(3, myemail);
		 ps.setString(4, mypassword);
		 ps.setString(5, myrole);
		 
		 int count = ps.executeUpdate();
		 if(count > 0)
		 {
			  resp.setContentType("text/html");
			  out.print("<h3 style='color:green'> User registered successfully </h3>");
			  
			 RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
			 rd.include(req, resp);
		 }
		 else
		 {
			 resp.setContentType("text/html");
			  out.print("<h3 style='color:red'> User not registered doe to some error </h3>");
			  
			 RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
			 rd.include(req, resp); 
		 }
		 
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  
		  resp.setContentType("text/html");
		  out.print("<h3 style='color:red'> Exception Occured :"+e.getMessage()+" </h3>");
		  
		 RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
		 rd.include(req, resp); 
	  }
  }
  
}
