package com.basic.dao;

import java.util.List;

import com.basic.model.Dean;
import com.basic.model.Organization;
import com.basic.util.Pager;

public interface IOrganization {
	public int addOrganization(Organization organization);
	public Organization loadOrganization(int id);
	public void updateOrganization(Organization organization);
	public List<Organization> load();
	public Pager<Organization> load(String content);
	public Pager<Organization> load(String content,int pageIndex,int pageSize);
}
