import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Delete")
public class Delete extends HttpServlet {

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
	    Statement pstmt;
	    String f = request.getParameter("f");
	    String t = request.getParameter("table");
	    
	    System.out.println(t);
	    
	    int p = 0;
	    
	    Connection conn = null;
	    
	    try { 
	        Class.forName(driver).newInstance(); 
	        conn = DriverManager.getConnection(url+dbName, user, password); 
	   //     PreparedStatement pstmt; 
	        sql2="DELETE FROM "+t+" WHERE item=\'"+f+"\' LIMIT 1";
	        pstmt = conn.prepareStatement(sql2);
	        pstmt.executeUpdate(sql2);
	        
	        request.setAttribute("table", t);
            getServletConfig().getServletContext().getRequestDispatcher("/cartremove.jsp").forward(request, response);
	       
	    } catch (Exception e) { 
	    	System.out.println("ERROR"+e);
  	 	        out.close(); 

}  }}
