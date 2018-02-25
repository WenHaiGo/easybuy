package com.easybuy.dao.impl;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.Size2DSyntax;

import com.easybuy.dao.EProductDao;
import com.easybuy.dbutils.DBUtil;
import com.easybuy.model.ECartProduct;
import com.easybuy.model.EPCateg;
import com.easybuy.model.EProduct;

public class EProductDaoImpl implements EProductDao {

	@Override
	public List<EProduct> getSpecialSaleProduct(int isSpecialSale) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from e_product where is_special_price = ?";
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
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from e_product where ep_id = ?";
		EProduct ep = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, EPId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ep = new EProduct();
				ep = productAssign(ep, rs);

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

	EProduct productAssign(EProduct ep, ResultSet rs) {
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ep;
	}

	@Override
	public List<EPCateg> getCateg() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from e_category";

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
				DBUtil.DBclose(conn, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<EProduct> getHotProduct(int saleNum) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub
		// 定义热卖的多少是否支持改变还是写死？
		String sql = "select * from e_product where ep_sale_number >?";
		List<EProduct> list = new LinkedList<>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, saleNum);

			rs = pstm.executeQuery();
			while (rs.next()) {
				EProduct ep = new EProduct();
				ep = productAssign(ep, rs);

				list.add(ep);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public List<EProduct> getCategProduct(int EPCId) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub
		String sql = "select * from e_product where epc_child_id =?";
		List<EProduct> list = new LinkedList<>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, EPCId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				EProduct ep = new EProduct();
				ep = productAssign(ep, rs);
				list.add(ep);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public List<EProduct> getAllCartProduct(String EPUId) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub
		String sql = "select * from e_cart where user_id = ?";
		// SELECT * from e_product where ep_id = (select product_id from e_cart where
		// user_id = '123')
		List<EProduct> list = new LinkedList<>();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, EPUId);
			rs = pstm.executeQuery();
			System.out.println(EPUId);
			while (rs.next()) {
				System.out.println(rs.getInt("product_id"));
				EProduct ep = getProductById(rs.getInt("product_id"));
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
	public EProduct getProductById(int productId) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub
		String sql = "select * from e_product where ep_id = ?";
		EProduct ep = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, productId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ep = new EProduct();
				ep = productAssign(ep, rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ep;
	}

	@Override
	public List<ECartProduct> getCartProductInfo(String EPUId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		String sql = "select * from e_cart where user_id = ?";
		List<ECartProduct> list = new LinkedList<>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, EPUId);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				ECartProduct ecp = new ECartProduct();
				ecp.setPNum(rs.getInt("product_num"));
				ecp.setEUId(rs.getString("user_id"));
				ecp.setCreateTime(rs.getDate("create_time"));
				ecp.setPId(rs.getInt(rs.getInt("product_id")));
				ecp.setC_id(rs.getInt("cart_id"));

				list.add(ecp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Boolean deleCartProductByPid(int EPId) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		String sql = "delete from e_cart where product_id =?";
		boolean isDelete = false;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, EPId);
			int rs = pstm.executeUpdate();
			while (rs > 0) {
				isDelete = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isDelete;
	}

	@Override
	public Boolean cartSave(String EUId, int EPId, int productNum) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		boolean isSave = false;
		String sql = "select * from e_cart where user_id = ? and product_id =?";
		try {
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, EUId);
			pstm.setInt(2, EPId);
			ResultSet rs = pstm.executeQuery();
			// 如果存在
			if (rs.next()) {
				isSave = cartChangeProductNum(EUId, EPId, productNum);
			}

			// 如果不存在
			else {
				isSave = cartNewProduct(EUId, EPId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSave;
	}

	// 服务于cartSave
	private Boolean cartNewProduct(String EUId, int EPId) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		String sql = "insert into e_cart(user_id,product_id,create_time,product_num) values(?,?,?,?)";
		boolean isSave = false;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, EUId);
			pstm.setInt(2, EPId);
			Date time = new Date(System.currentTimeMillis());
			// 不知道这样保存到数据库是否会起作用
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// String current = sdf.format(time);
			pstm.setDate(3, time);
			// 默认添加一件是否应该出现常数 还是应直接使用参数，重构上说尽量少使用参数所以这里用了常量
			pstm.setInt(4, 1);
			int temp = pstm.executeUpdate();
			if (temp > 0) {
				isSave = true;
			}
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

		return isSave;
	}

	// 服务于cartSave
	private Boolean cartChangeProductNum(String EUId, int EPId, int productNum) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		String sql = "update e_cart set product_num = ? where user_id = ? and product_id =?";
		boolean isUpdate = false;
		try {
			pstm = conn.prepareStatement(sql);
			int tempNum = getCurrentCartProductNum(EPId);
			pstm.setInt(1, tempNum + productNum);
			pstm.setString(2, EUId);
			pstm.setInt(3, EPId);
			int temp = pstm.executeUpdate();
			if (temp > 0) {
				isUpdate = true;
			}
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
		return isUpdate;
	}

	// 服务于cartChangeProductNum
	private int getCurrentCartProductNum(int EPId) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		// 是否可以直接查询product_num 就是不知道如何转为int处理
		String sql = "select * from e_cart where product_id = ?";
		int currentNum = 0;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, EPId);
			rs = pstm.executeQuery();
			if (rs.next()) {
				currentNum = rs.getInt("product_num");
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

		return currentNum;
	}

}
