import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Statement;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Add")
public class Add extends HttpServlet {

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
	    String t = request.getParameter("t");
	    
	    System.out.println(t);
	    
	    int p = 0;
	    
	    Connection conn = null;
	    
	    try { 
	        Class.forName(driver).newInstance(); 
	        conn = DriverManager.getConnection(url+dbName, user, password); 
	   //     PreparedStatement pstmt; 
	         
	       if(f.equals("Masala Dosa")) { p=40;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Idli")) { p=30;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Idli Vada")) { p=40;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Meals")) { p=40;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Roti Curry")) { p=35;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Kerala Parota")) { p=35;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Butter Naan")) { p=50;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Bisi Bele Bath")) { p=30;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Rice Bath")) { p=30;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Noodles")) { p=35;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       if(f.equals("Gobi Manchurian")) { p=35;
	       sql2="INSERT INTO "+t+" (Item, Price) VALUES ('"+f+"',"+p+")";}
	       
	        pstmt = conn.prepareStatement(sql2);
	        pstmt.executeUpdate(sql2);
	        
	        request.setAttribute("table", t);
            getServletConfig().getServletContext().getRequestDispatcher("/orders.jsp").forward(request, response);
	    
	    } catch (Exception e) { 
	    	System.out.println("ERROR"+e);
  	 	        out.close(); 
	    	}
	   
	    }}
