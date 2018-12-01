import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AdLogin")

public class AdLogin extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String uid = request.getParameter("uid");
        String pw = request.getParameter("pw");
        
        if(pw.equals("team1"))
        {
            RequestDispatcher rs = request.getRequestDispatcher("admin.html");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("login.html");
           rs.include(request, response);
        }
    }  
}
