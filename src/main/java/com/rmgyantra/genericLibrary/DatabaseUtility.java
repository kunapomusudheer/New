package com.rmgyantra.genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DatabaseUtility {
	Connection con = null;
	public void createConnection() throws Throwable {
		Driver dref=new Driver();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	public void closeConnection() throws Throwable {

		con.close();
	}
	public ResultSet executeQueryTest(String query) throws Throwable {
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(query);
		return result;

	}
}
