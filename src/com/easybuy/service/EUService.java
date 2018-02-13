package com.easybuy.service;

import java.sql.SQLException;

import com.easybuy.model.EUser;

public interface EUService {

	boolean save(String EUId, String pwd) throws SQLException;

	public Boolean checkEUId(String EUId);

	public Boolean checkEUId(String EUId, String EUPwd);
}
