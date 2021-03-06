package com.easybuy.dbutils;

import java.util.List;

//处理分页的工具类
public class PageUtil<T> {
	// 第几页
	int pageNo;
	// 每一页显示多少数据
	int pageSize;
	// 总页数
	int totalPage;
	// 每一页的数据
	List<T> list;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
