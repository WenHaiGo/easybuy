package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.easybuy.dao.EProductDao;
import com.easybuy.dbutils.DBUtil;
import com.easybuy.model.EPCateg;
import com.easybuy.model.EProduct;

public class EProductDaoImpl implements EProductDao {

	Connection conn = DBUtil.getConn();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql = null;

	@Override
	public List<EProduct> getSpecialSaleProduct(int isSpecialSale) {
		// TODO Auto-generated method stub

		sql = "select * from e_product where is_special_price = ?";
		List<EProduct> list = null;
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, isSpecialSale);
			rs = pstm.executeQuery();
			list = new LinkedList<>();
			while (rs.next()) {
				EProduct ep = new EProduct();
				ep.setEPCChildId(rs.getInt("epc_child_id"));
				ep.setEPCId(rs.getInt("epc_id"));
				ep.setEPDesc(rs.getString("ep_description"));
				ep.setEPFile(rs.getString("ep_file_name"));
				ep.setEPId(rs.getInt("ep_id"));
				ep.setEPPrice(rs.getInt("ep_price"));
				ep.setEPName(rs.getString("ep_name"));
				ep.setEPStock(rs.getInt("ep_stock"));
				ep.setIsSpecialPrice(rs.getInt("is_special_price"));

				list.add(ep);
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

	@Override
	public EProduct getDetailProduct(int EPId) {

		sql = "select * from e_product where ep_id = ?";
		EProduct ep = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, EPId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ep = new EProduct();
				ep.setEPCChildId(rs.getInt("epc_child_id"));
				ep.setEPCId(rs.getInt("epc_id"));
				ep.setEPDesc(rs.getString("ep_description"));
				ep.setEPFile(rs.getString("ep_file_name"));
				ep.setEPId(rs.getInt("ep_id"));
				ep.setEPPrice(rs.getInt("ep_price"));
				ep.setEPName(rs.getString("ep_name"));
				ep.setEPStock(rs.getInt("ep_stock"));
				ep.setIsSpecialPrice(rs.getInt("is_special_price"));
				ep.setEPSaleNum(rs.getInt("ep_sale_number"));

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

		return ep;
		// TODO Auto-generated method stub

	}

	@Override
	public List<EPCateg> getCateg() {
		// TODO Auto-generated method stub

		sql = "select * from e_category";
		
		List<EPCateg> list = new LinkedList<>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				EPCateg epc = new EPCateg();
				// ep.setEPCChildId(rs.getInt(columnIndex));
				epc.setEPCId(rs.getInt("epc_id"));
				epc.setEPCIsOften(rs.getInt("is_often"));
				epc.setEPCIsTop(rs.getInt("is_top"));
				epc.setEPCName(rs.getString("epc_name"));
				epc.setEPCParentId(rs.getInt("epc_parent_id"));
				list.add(epc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				DBUtil.DBclose(conn, pstm,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
