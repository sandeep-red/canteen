<%@ page language="java" contentType="text/html" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="user-scalable=0, width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>RIT Canteen Buddy</title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css">

</head>
<body>
	<div id="header">
		<img src="rit3.png" alt="RIT">
		<h1><a href="index.html">RIT CANTEEN BUDDY <span>Canteen Management System</span></a></h1>
			<ul id="menu">
				<li>
					<a href="index.html">HOME</a>
				</li>
				<li>
					<a href="login.html">ADMIN LOGIN</a>
				</li>
				<li>
					<a href="Tablename">ORDER NOW</a>
				</li>
				<li>
					<a href="help.html">HELP</a>
				</li>
			</ul>
	</div>
	
	<div id="body">
		<div id="info">
			<p><b>WELCOME STUDENT! </b></p>
			<p><b>TODAY'S MENU </b></p>
			
			<%
			String url = "jdbc:mysql://localhost:3306/"; 
			String dbName = "menu"; 
			String driver = "com.mysql.cj.jdbc.Driver"; 
			String user = "root";  
			String password = "";
			
			String table = (String) request.getAttribute("table"); 
			 
			try {
				Class.forName(driver).newInstance(); 
				Connection con = DriverManager.getConnection(url+dbName, user, password); 
				
				Statement st= con.createStatement(); 
				ResultSet rs; 
				rs=st.executeQuery("select * from menu"); 
				
		     	out.println("<TABLE CELLSPACING=\"0\" CELLPADDING=\"3\" BORDER=\"1\">");
				out.println("<TR><TH>Item</TH><TH>Price</TH><TH>Click to order</TH></TR>");

				while(rs.next()) { 
					
					if(rs.getString("Availability").equals("Available")) {
						out.println("<TR>");
						out.println("  <TD>" + rs.getString("Item") + "</TD>");
						out.println("  <TD>&#x20b9;" + rs.getString("Price") + "</TD>");
						out.println("  <TD><form action=\"Add\" method=\"get\"><input type=\"submit\" value=\""+rs.getString("Item")+"\" name=\"f\" onclick=\"alert('Added to cart')\"><input type=\"hidden\" name=\"t\" value=\""+table+"\"></form></TD>");
						out.println("</TR>");
					}
				  }
				out.println("</TABLE>");
				out.println("<br><br><br>");
				out.println("<form action=\"cartremove.jsp\" method=\"get\"><input type=\"hidden\" name=\"table\" value= \""+table+"\" ><input type=\"submit\" value=\"VIEW CART\"></form><br>");
				out.println("<form action=\"placeorder.jsp\" method=\"get\"><input type=\"hidden\" name=\"table\" value= \""+table+"\" ><input type=\"submit\" value=\"PLACE ORDER\"></form><br><br>");
				}
				  
			catch(SQLException e) {
				out.println("SQLException: " + e.getMessage() + "<BR>");
				while((e = e.getNextException()) != null)
				     out.println(e.getMessage() + "<BR>");
				}
				
			catch(ClassNotFoundException e) {
				  out.println("ClassNotFoundException: " + e.getMessage() + "<BR>");
				}
			
				 %>
		</div>	
	</div>
	
	<div id="footer">
		<address> 
			RAMAIAH INSTITUTE OF TECHNOLOGY<br>
			(Autonomous Institute, Affiliated to VTU)<br>
			BANGALORE – 54
		</address>
	</div>
</body>
</html>
