package com.easybuy.service.impl;

import java.sql.SQLException;

import com.easybuy.dao.impl.EUDaoImpl;
import com.easybuy.dbutils.DBUtil;
import com.easybuy.model.User;
import com.easybuy.service.EUService;

public class EUServiceImpl implements EUService {

	@Override
	public boolean save(String EUId, String pwd) throws SQLException {
		// TODO Auto-generated method stub

		// 注册添加用户到数据库
		return new EUDaoImpl().save(EUId, pwd);

	}

}
