package org.aricent.cloud.talkrds.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static String endpointAddress = "";
	private String dbName = "";
	private String dbUserName = "";
	private String dbPassword  = "";
	
	public static DbConnection dbCon;
	public Connection con;
	
	public DbConnection() throws SQLException {
		
		String url = "jdbc:mysql://" + endpointAddress + "/" + dbName;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,dbUserName,dbPassword);
			System.out.println("**Connection Successfull");
		
		}	
		catch(Exception ex){
			
			System.out.println("**ERROR : Connection NOT Successfull");
			ex.printStackTrace();
		}		
	}
	
	public static synchronized DbConnection getRdsConnection() throws SQLException{
		
		if(dbCon == null){
			dbCon = new DbConnection();
		}
		
		return dbCon;
	}

	public static String getEndpointAddress() {
		return endpointAddress;
	}

}
