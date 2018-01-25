package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import com.easybuy.dao.EUDao;
import com.easybuy.dbutils.DBUtil;
import com.easybuy.model.User;

public class EUDaoImpl implements EUDao {

	@Override
	public boolean save(String EUId,String pwd) throws SQLException {

		Connection conn = null;
		String sql = "INSERT INTO eu_user(eu_user_id,  eu_password) VALUES (?, ?)";
		conn = DBUtil.getConn();
		PreparedStatement pst = null;
		boolean flag = false;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, EUId);
			pst.setString(2, pwd);
			int a = pst.executeUpdate();
			if(a==1)
			{
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			DBUtil.DBclose(conn, pst,rs);
		}
		return flag;
	}

}
