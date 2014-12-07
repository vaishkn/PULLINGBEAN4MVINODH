package org.aricent.cloud.talkrds.service;

import java.sql.SQLException;

public interface TalkRdsService {

	public boolean validateUser(String username, String password) throws SQLException;
	public String getUsers() throws SQLException;	
	public String getRdsEndPoint();
}
