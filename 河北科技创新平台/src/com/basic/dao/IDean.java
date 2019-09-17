package com.basic.dao;

import java.util.List;

import com.basic.model.Dean;
import com.basic.util.Pager;

public interface IDean {
	public int addDean(Dean dean);
	public Dean loadDean(int id);
	public void updateDean(Dean dean);
	public List<Dean> load();
	//查询名字得到列表
	public Pager<Dean> load(String content);
	public Pager<Dean> load(String content,int pageIndex,int pageSize);
}
