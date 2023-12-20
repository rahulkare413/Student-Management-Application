package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Service {
private	static int count ;
	static Connection connection;
	
	public static Connection getConnection() {
		if (count==0) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				try {
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		count++;
		return connection;
		
	}

}
