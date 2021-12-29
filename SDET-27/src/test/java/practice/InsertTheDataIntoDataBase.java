package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataIntoDataBase {
	public static void main(String[] args) throws SQLException {
		// register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
	    // establish the connection with database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");

		// issue the statement 
		Statement statement =connection.createStatement();
		
		//Execute Query 
		int result = statement.executeUpdate("insert into studentinfo(fname, lname,address) value ('ganesh1','s1','IND');");
		
		//  verificaton
		
		 if (result == 1)
		 {
			 System.out.println("PASS");
		 }else {
			 System.out.println("FAIL");
		 }
		 // close the database connection
		 connection.close();
	}

}
