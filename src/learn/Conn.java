package learn;

import java.sql.*; //for connection

//We will not run this class.
//We will just make this class object in other class.
public class Conn {
	
	Connection c; //need import statement
	Statement s;
	//It will only have the constructor
	Conn() {
		
		//mySQL is a external entity
		try {
			//JDBC = Java DataBase Connectivity
			//1.Register the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver"); //(Driver address)
			
			//2.Creating connection string and connect it with mySQL
			c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root", "Al@121003");
			s = c.createStatement();
			
		} catch(Exception e) {
	  		//Exception is printed
			e.printStackTrace();
		}	
	}
}
