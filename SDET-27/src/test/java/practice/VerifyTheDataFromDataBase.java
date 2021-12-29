package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataFromDataBase {
	public static void main(String[] args) throws SQLException  {
		String expected = "IND" ;
		// register the database
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
			    // establish the connection with database
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");

				// issue the statement 
				Statement statement =connection.createStatement();
				
				//Execute Query 
				ResultSet result = statement.executeQuery("select * from studentinfo");
				
						
				 while(result.next()) {
					 if(result.getString(4).equals(expected)) {
					 System.out.println("PASS");
					 }
				 }
				 		 
			
			// close the database connection
				 connection.close();
				 }

	}
	



