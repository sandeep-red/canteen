import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Details")
public class Details extends HttpServlet {

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
	    String sql2= "";
	    String sql23= "";
	    String sql24= "";
	    Statement pstmt;
	    String name = request.getParameter("name");
	    int num = Integer.parseInt(request.getParameter("num"));
	    String table = request.getParameter("table");
	    int tt = Integer.parseInt(request.getParameter("tt"));
	    
	    System.out.println(table);
	    
	    Connection conn = null;
	    
	    try { 
	        Class.forName(driver).newInstance(); 
	        conn = DriverManager.getConnection(url+dbName, user, password); 
	   //     PreparedStatement pstmt;
	        
	        
	        sql2 = "select Item from " + table;
	        Statement st= conn.createStatement(); 
			ResultSet rs; 
			rs=st.executeQuery(sql2);
			
			String food = "";
			
			while(rs.next()) {
				food += rs.getString(1)+"  ";
			}
			
			sql24 = "insert into allorders(Name, Number, Details, TotalCost) values('"+name+"','"+num+"','"+food+"','"+tt+"')";
			pstmt = conn.prepareStatement(sql24);
	        pstmt.executeUpdate(sql24);
	        
	        sql23="DROP TABLE "+table;
	        pstmt = conn.prepareStatement(sql23);
	        pstmt.executeUpdate(sql23);
	        
	        RequestDispatcher rds = request.getRequestDispatcher("index.html");
	        rds.include(request, response);
	       
	    } catch (Exception e) { 
	    	System.out.println("ERROR"+e);
  	 	        out.close(); 

}  }}
