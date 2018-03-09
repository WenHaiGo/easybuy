package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.CategDao;
import com.easybuy.dbutils.DBUtil;
import com.easybuy.model.EPCateg;

public class CategDaoImpl implements CategDao {

	// 通过pid得到所有分类
	@Override
	public List<EPCateg> getByPid(int pid) throws SQLException {
		// TODO Auto-generated method stub
		List<EPCateg> list = new ArrayList<EPCateg>();
		String sql = "select epc_id,epc_name,epc_parent_id from e_category  where epc_parent_id = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, pid);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			EPCateg c = new EPCateg();
			c.setEPCId(rs.getInt("epc_id"));
			c.setEPCName(rs.getString("epc_name"));
			c.setEPCParentId(rs.getInt("epc_parent_id"));
			list.add(c);
		}
		return list;
	}

	@Override
	public boolean delCateg(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from e_category where epc_id=?";
		boolean isDel = false;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		int a = pstm.executeUpdate();
		if (a > 0) {
			isDel = true;
		}
		return isDel;
	}

	@Override
	public EPCateg getByCid(int cid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select epc_id,epc_name,epc_parent_id from e_category  where epc_id = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, cid);
		ResultSet rs = pstm.executeQuery();
		EPCateg c = null;
		while (rs.next()) {
			c = new EPCateg();
			c.setEPCId(rs.getInt("epc_id"));
			c.setEPCName(rs.getString("epc_name"));
			c.setEPCParentId(rs.getInt("epc_parent_id"));
		}
		return c;
	}

}
