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
					<a href="login.html">LOGOUT</a>
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
			<p><b>CURRENT MENU</b></p>
			
			<%
			String url = "jdbc:mysql://localhost:3306/"; 
			String dbName = "menu"; 
			String driver = "com.mysql.cj.jdbc.Driver"; 
			String user = "root";  
			String password = "";
			
			 
			try {
				Class.forName(driver).newInstance(); 
				Connection con = DriverManager.getConnection(url+dbName, user, password); 
				
				Statement st= con.createStatement(); 
				ResultSet rs; 
				rs=st.executeQuery("select * from menu"); 
				String f1,f2,f3;      
				
				out.println("<TABLE CELLSPACING=\"0\" CELLPADDING=\"3\" BORDER=\"1\">");
				out.println("<TR><TH>Item</TH><TH>Price</TH><TH>Availability</TH></TR>");

				while(rs.next()) { 
					out.println("<TR>");
					out.println("  <TD>" + rs.getString("Item") + "</TD>");
					out.println("  <TD>&#x20b9;" + rs.getString("Price") + "</TD>");
					out.println("  <TD>" + rs.getString("Availability") + "</TD>");
					out.println("</TR>");
				  }
				out.println("</TABLE>");
				
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
				<br><br>
			<div id="food">
				<a href="avail.html">Click here to add items to current menu</a><br><br><br><br>
				<a href="unavail.html">Click here to remove items from current menu</a>
			</div>
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
