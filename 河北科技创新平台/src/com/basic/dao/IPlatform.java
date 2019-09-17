package com.basic.dao;

import java.util.List;

import com.basic.model.Platform;
import com.basic.util.Pager;

public interface IPlatform {
	public void addPlatform(Platform platform);
	public Platform loadPlatform(int id);
	public void updatePlatform(Platform platform);
    public Platform loadPlatformByUserid(int userid);
    public Platform loadPlatformByDeanid(int deanid);
    public Platform loadPlatformByOrganizationid(int organizationid);
    public Pager<Platform> loadPlatformComplex(String platform_name, String field, int gradeValue, String jjjgj,String platform_site_name,
			String dep_organization_name, String dep_organization_faren, String dean_name);
    //综合查询
    public Pager<Platform> loadPlatformClassification(String[] district);
    //分类浏览
    public List<Platform> loadPlatform(String condition[],String values[],String style[],String con[],String date1,String date2,int platform_grade);
}
