package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.PortableInterceptor.INACTIVE;

import com.easybuy.dao.EUDao;
import com.easybuy.dbutils.DBUtil;
import com.easybuy.model.EUser;

public class EUDaoImpl implements EUDao {

	@Override
	public boolean save(String EUId, String pwd) throws SQLException {

		String sql = "INSERT INTO eu_user(eu_user_id,  eu_password) VALUES (?, ?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean flag = false;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, EUId);
			pstm.setString(2, pwd);
			int a = pstm.executeUpdate();
			if (a == 1) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			DBUtil.DBclose(conn, pstm, rs);
		}
		return flag;
	}

	public Boolean CheckEUId(String EUId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select count(*)  from eu_user where  eu_user_id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, EUId);
			rs = pstm.executeQuery();
			int a = 0;
			if (rs.next()) {
				a = rs.getInt(1);
			}
			if (a > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				DBUtil.DBclose(conn, pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Boolean checkEUId(String EUId, String EUPwd) {
		// TODO Auto-generated method stub
		String sql = "select * from eu_user where eu_user_id = ? and eu_password = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean isExist = false;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, EUId);
			pstm.setString(2, EUPwd);
			rs = pstm.executeQuery();
			while (rs.next()) {
				isExist = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				DBUtil.DBclose(conn, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isExist;
	}

	@Override
	public List<EUser> showAllUser() {
		// TODO Auto-generated method stub
		String sql = "select * from eu_user";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<EUser> list = new LinkedList<>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				EUser user = new EUser();
				user.setEUAddress(rs.getString("eu_address"));
				user.setEUBirthday(rs.getDate("eu_birthday"));
				user.setEUEmail(rs.getString("eu_email"));
				user.setEUId(rs.getString("eu_user_id"));
				user.setEUIdentyCode("eu_identity_code");
				user.setEUMoible(rs.getString("eu_mobile"));
				user.setEUName(rs.getString("eu_user_name"));
				user.setEUPwd(rs.getString("eu_password"));
				user.setEUSex(rs.getString("eu_sex"));
				user.setEUStatus(rs.getInt("eu_status"));
				user.setId(rs.getInt("id"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				DBUtil.DBclose(conn, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
