package com.easybuy.service;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.dbutils.CategUtils;
import com.easybuy.model.EPCateg;
import com.google.gson.annotations.Until;

public interface CategService {
	// 通过pid获取
	List<EPCateg> getByPid(int pid) throws SQLException;

	List<CategUtils> getCategoryOfTree() throws SQLException;

	boolean delCateg(int id) throws SQLException;

	// 通过id获取分类
	EPCateg getByCid(int cid) throws SQLException;
}
