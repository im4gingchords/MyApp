package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
protected static Connection intializeConn() throws ClassNotFoundException, SQLException {
	String name = "05XyRxBcfa";
	String username = "05XyRxBcfa";
	String password = "C7MMoHmL97";
	String dbURL = "jdbc:mysql://localhost:3306/"; 
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(dbURL+name, username, password);
	return con;
}
}

