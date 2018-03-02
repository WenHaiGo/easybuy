package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.easybuy.dao.ENDao;
import com.easybuy.dbutils.DBUtil;
import com.easybuy.model.ENews;

public class ENDaoImpl implements ENDao {

	Connection conn = DBUtil.getConn();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql = null;

	@Override
	public List<ENews> newsTitle() {
		// TODO Auto-generated method stub
		List<ENews> newsTitle = null;
		sql = "select * from en_news";
		try {
			newsTitle = new LinkedList<ENews>();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ENews e = new ENews();
				e.setENId(rs.getInt("en_id"));
				e.setENTitle(rs.getString("en_title"));
				e.setENContent(rs.getString("en_content"));
				e.setENTime(rs.getDate("en_create_time"));
				newsTitle.add(e);
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
		return newsTitle;

	}

	public ENews newsContent(String newsTitle) {
		sql = "select * from en_news where en_title = ?";
		ENews e = new ENews();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, newsTitle);
			rs = pstm.executeQuery();
			while (rs.next()) {

				e.setENId(rs.getInt("en_id"));
				e.setENTitle(rs.getString("en_title"));
				e.setENContent(rs.getString("en_content"));
				e.setENTime(rs.getDate("en_create_time"));

			}
			System.out.println("在数据库李曼是" + e.getENContent());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		finally {
			try {
				DBUtil.DBclose(conn, pstm, rs);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return e;
	}

}
