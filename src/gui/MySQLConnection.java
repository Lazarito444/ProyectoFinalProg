package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQLConnection {

	static String user = "root", password = "admin";
	
	 MySQLConnection(String user, String password){
	 
	 }

	 static public Connection getConnection() {
		 
		Connection con = null;
		 try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", user, password);
			
		 } catch (SQLException e) {
			 
			 System.out.println("Error (SQLException): "+e);
			 
		 } catch (ClassNotFoundException e) {
			 
			 System.out.println("Error (ClassNotFoundException): "+e);
			 
		 }
		 
		 return con;
	 }
}
