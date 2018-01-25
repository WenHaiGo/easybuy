package com.easybuy.service;

import java.sql.SQLException;

import com.easybuy.model.User;

public interface EUService {

	boolean save(String EUId, String pwd) throws SQLException;
}
