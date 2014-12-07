package org.aricent.cloud.talkrds.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.aricent.cloud.talkrds.db.DbConnection;
import org.aricent.cloud.talkrds.vo.UserVO;

public class UsersDao {
	
	private String userQuery = "select * from AppUsers";
	
	private Connection con;
	
	public UsersDao() throws SQLException{
		
		try{
			con = DbConnection.getRdsConnection().con;
		}
		catch(SQLException e){
			
			e.printStackTrace();
		}
	}
	
	public List<UserVO> getAppsUsers() throws SQLException{
		
		Statement stmtSelect = null;
		ResultSet userResult = null;
		
		List<UserVO> userList = new ArrayList<UserVO>();
		try{
			
			stmtSelect = con.createStatement();
			userResult = stmtSelect.executeQuery(userQuery);
			
			while(userResult.next()) {
				
				UserVO user = new UserVO();
				
				if(userResult.getString("username") != null){
					user.setUsername(userResult.getString("username"));
				}
				
				if(userResult.getString("password") != null){
					user.setPassword(userResult.getString("password"));
				}
				
				userList.add(user);
			}
		}finally{
			
			if(userResult!=null)
				userResult.close();
			if(stmtSelect!=null)
				stmtSelect.close();
			if(con!=null)
				con.close();
		}
		
		return userList;
	}

}
