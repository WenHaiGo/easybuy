package com.easybuy.dao;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.model.ENews;
import com.easybuy.model.EUser;

public interface EUDao {
	/**
	 * 传入一个User对象，成功返回true，失败返回false
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	boolean save(String EUId, String pwd) throws SQLException;

	public Boolean CheckEUId(String eUId);
	
	
}
