import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.Random;

@WebServlet("/Tablename")

public class Tablename extends HttpServlet {
 
	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String url = "jdbc:mysql://localhost:3306/"; 
		String dbName = "menu"; 
		String driver = "com.mysql.cj.jdbc.Driver"; 
		String user = "root";  
		String password = "";
		Connection con = null;
		
		String table = "";
		String alphabet= "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        int randomLen = 1+random.nextInt(9);
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(26));
            table+=c;
        }
        
		try {
			Class.forName(driver).newInstance(); 
			con = DriverManager.getConnection(url+dbName, user, password); 
			
			Statement st= con.createStatement(); 
			ResultSet rs; 
			rs=st.executeQuery("select * from menu"); 
			
	        	Statement stmt = con.createStatement();
	            String sql = "create table "+table+" (Item VARCHAR(15) not null, Price INT not null);";
	            stmt.executeUpdate(sql);
		         
	           
	            
	            if(con!=null)
					try {
						con.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
	            
	            request.setAttribute("table", table);
	            getServletConfig().getServletContext().getRequestDispatcher("/orders.jsp").forward(request, response);
	            
		}
			  
		catch(SQLException e) {
			out.println("SQLException: " + e.getMessage() + "<BR>");
			while((e = e.getNextException()) != null)
			     out.println(e.getMessage() + "<BR>");
			}
			
		catch(ClassNotFoundException e) {
			  out.println("ClassNotFoundException: " + e.getMessage() + "<BR>");
			} 
		
		catch (InstantiationException e) {
			
			e.printStackTrace();
			} 
		catch (IllegalAccessException e) {
			
			e.printStackTrace();
			}  
    }  
}
