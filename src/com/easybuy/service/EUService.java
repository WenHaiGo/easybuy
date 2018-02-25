package com.easybuy.service;

import java.sql.SQLException;

import com.easybuy.model.EUser;

public interface EUService {

	// 用于注册使用
	boolean save(String EUId, String pwd) throws SQLException;

	// 用于注册查询
	public Boolean checkEUId(String EUId);

	// 用于登陆使用
	public Boolean checkEUId(String EUId, String EUPwd);
}
