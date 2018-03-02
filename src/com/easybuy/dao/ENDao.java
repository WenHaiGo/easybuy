package com.easybuy.dao;

import java.util.List;

import com.easybuy.model.ENews;

public interface ENDao {
	public List<ENews> newsTitle();
	//根据标题获取内容
	public ENews  newsContent(String newsTitle);
}
