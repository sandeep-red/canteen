import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Avail")
public class Avail extends HttpServlet {

  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
	  response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter(); 
	    
	     String url = "jdbc:mysql://localhost:3306/"; 
	    String dbName = "menu"; 
	    String driver = "com.mysql.cj.jdbc.Driver"; 
	    String user = "root";  
	    String password = ""; 
	    String food= request.getParameter("f"); //change the name of the parameter accordingly//
	    Statement pstmt;
	    
	    try { 
	        Class.forName(driver).newInstance(); 
	        Connection conn = DriverManager.getConnection(url+dbName, user, password); 
	   //     PreparedStatement pstmt; 
	      
	        String sql2="UPDATE menu SET Availability='Available' WHERE Item='"+food+"'";
	        pstmt = conn.prepareStatement(sql2);
	        int count = pstmt.executeUpdate(sql2);
            RequestDispatcher rs = request.getRequestDispatcher("avail.html");
            rs.include(request, response);
  
	    } catch (Exception e) { 
	    	System.out.println("ERROR"+e);
  	 	        out.close(); 

}  }}