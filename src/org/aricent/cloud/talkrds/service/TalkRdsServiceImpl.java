package org.aricent.cloud.talkrds.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.aricent.cloud.talkrds.dao.UsersDao;
import org.aricent.cloud.talkrds.db.DbConnection;
import org.aricent.cloud.talkrds.vo.UserVO;

public class TalkRdsServiceImpl implements TalkRdsService{

	UsersDao userDetails;
	
	@Override
	public boolean validateUser(String username, String password)
			throws SQLException {
		
		boolean userStatus = false;
		userDetails = new UsersDao();
		
		List<UserVO> userList = userDetails.getAppsUsers();
		
		if(userList != null && userList.size() > 0){
			
			Iterator<UserVO> userIterator = userList.iterator();
			while(userIterator.hasNext() ){
				
				UserVO userDetailsInDB = (UserVO) userIterator.next();
				
				System.out.println(userDetailsInDB.getUsername() + " -- "+userDetailsInDB.getPassword());
				if(username.equals(userDetailsInDB.getUsername()) && 
						password.equals(userDetailsInDB.getPassword())){
					
					userStatus = true;
					break;
				}
			}
		}
		
		return userStatus;
	}
	

	@Override
	public String getUsers() throws SQLException {
		
		List<UserVO> userList = userDetails.getAppsUsers();
		
		String strUser = "";
		if(userList != null && userList.size() > 0){
		
			Iterator<UserVO> userIterator = userList.iterator();
			while(userIterator.hasNext() ){
				
				UserVO userDetailsInDB = (UserVO) userIterator.next();
					
				strUser += userDetailsInDB.getUsername() +",";
			}
			
		}
		return strUser;
	}
	

	@Override
	public String getRdsEndPoint() {
		
		return DbConnection.getEndpointAddress();
	}

	
}
