package com.rmgyantra.genericLibrary;

import org.junit.Test;
import org.junit.runners.Suite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIUtility {
	public DatabaseUtility db=new DatabaseUtility();
	@BeforeSuite
public void connectToDB() throws Throwable {
		db.createConnection();
	
}
	@AfterSuite
	public void closeConnection() throws Throwable {
		db.closeConnection();
	}
}
