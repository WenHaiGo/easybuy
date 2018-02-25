package com.easybuy.service.impl;

import java.util.List;

import com.easybuy.dao.impl.EProductDaoImpl;
import com.easybuy.model.ECartProduct;
import com.easybuy.model.EPCateg;
import com.easybuy.model.EProduct;
import com.easybuy.service.EProductService;

public class EProductServiceImpl implements EProductService {

	@Override
	public List<EProduct> getSpecialSaleProduct(int isSpecialSale) {
		// TODO Auto-generated method stub
		return new EProductDaoImpl().getSpecialSaleProduct(isSpecialSale);
	}

	public EProduct getDetailProduct(int EPId) {
		return new EProductDaoImpl().getDetailProduct(EPId);
	}

	@Override
	public List<EPCateg> getCateg() {
		// TODO Auto-generated method stub
		return new EProductDaoImpl().getCateg();
	}

	public List<EProduct> getHotProduct(int saleNum) {
		return new EProductDaoImpl().getHotProduct(saleNum);
	}

	@Override
	public List<EProduct> getCategProduct(int EPCId) {
		// TODO Auto-generated method stub
		return new EProductDaoImpl().getCategProduct(EPCId);
	}

	@Override
	public List<EProduct> getAllCartProduct(String EPUId) {
		// TODO Auto-generated method stub
		return new EProductDaoImpl().getAllCartProduct(EPUId);
	}

	@Override
	public List<ECartProduct> getCartProductInfo(String EPUId) {
		// TODO Auto-generated method stub
		return new EProductDaoImpl().getCartProductInfo(EPUId);
	}

	@Override
	public Boolean deleCartProductByPid(int EPId) {
		// TODO Auto-generated method stub
		return new EProductDaoImpl().deleCartProductByPid(EPId);
	}

	@Override
	public Boolean cartSave(String EUId, int EPId, int productNum) {
		// TODO Auto-generated method stub
		return new EProductDaoImpl().cartSave(EUId, EPId, productNum);
	}

}
