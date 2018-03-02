package com.easybuy.service.impl;

import java.util.List;

import com.easybuy.dao.impl.ENDaoImpl;
import com.easybuy.model.ENews;
import com.easybuy.service.ENewsService;

public class ENewsServiceImpl implements ENewsService {

	@Override
	public List<ENews> newsTitle() {
		// TODO Auto-generated method stub
		return new ENDaoImpl().newsTitle();
	}

	
	public ENews newsContent(String newsTitle) {
		// TODO Auto-generated method stub
		return new ENDaoImpl().newsContent(newsTitle);
	}

}
