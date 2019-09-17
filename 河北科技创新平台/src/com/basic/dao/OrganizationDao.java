package com.basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.basic.model.Dean;
import com.basic.model.Organization;
import com.basic.model.User;
import com.basic.util.DBUtil;
import com.basic.util.Pager;
import com.basic.util.systemContext;

public class OrganizationDao implements IOrganization{

	@Override
	public int addOrganization(Organization organization) {
		Connection con = DBUtil.getConnection();
        String sql = "INSERT INTO organization (name, usci, faren_name, telephone, type) VALUES (?,?,?,?,?);";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,organization.getName());
            ps.setString(2,organization.getUsci());
            ps.setString(3,organization.getFarenName());
            ps.setString(4,organization.getTelephone());
            ps.setString(5,organization.getType());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return id;
	}

	@Override
	public Organization loadOrganization(int id) {
		Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM organization WHERE id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Organization organization = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                organization = new Organization();
                organization.setId(rs.getInt("id"));
                organization.setName(rs.getString("name"));
                organization.setUsci(rs.getString("usci"));
                organization.setFarenName(rs.getString("faren_name"));
                organization.setTelephone(rs.getString("telephone"));
                organization.setType(rs.getString("type"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return organization;
	}

	@Override
	public void updateOrganization(Organization organization) {
		Connection con = DBUtil.getConnection();
        String sql = "UPDATE organization SET name=?, usci=?, faren_name=?, telephone=?, type=? WHERE (id=?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,organization.getName());
            ps.setString(2,organization.getUsci());
            ps.setString(3,organization.getFarenName());
            ps.setString(4,organization.getTelephone());
            ps.setString(5,organization.getType());
            ps.setInt(6,organization.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
		
	}

	@Override
	public List<Organization> load() {
		Connection connection=DBUtil.getConnection();
		String sql="select * from organization";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Organization> organizations=new ArrayList<Organization>();
		Organization organization=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				organization = new Organization();
                organization.setId(resultSet.getInt("id"));
                organization.setName(resultSet.getString("name"));
                organization.setUsci(resultSet.getString("usci"));
                organization.setFarenName(resultSet.getString("faren_name"));
                organization.setTelephone(resultSet.getString("telephone"));
                organization.setType(resultSet.getString("type"));
                organizations.add(organization);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return organizations;
	}

	@Override
	public Pager<Organization> load(String content) {

		int pageSize = systemContext.getPageSize();
		int pageOffset = systemContext.getpageOffset();
		
		Pager<Organization> pager = new  Pager<Organization>();
		Connection connection = DBUtil.getConnection();
		//创建语句传输对象
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//准备sql语句
		String sql = "select * from (select \"ID\",\"NAME\",USCI,FAREN_NAME,TELEPHONE,\"TYPE\" ,rownum as num from \"ORGANIZATION\") ";
		//数据总条数
		String  sqlCount = "select count(*) from (select \"ID\",\"NAME\",USCI,FAREN_NAME,TELEPHONE,\"TYPE\" ,rownum as num from \"ORGANIZATION\") ";
		//集合中只能放入user对象
		List<Organization> organizations = new ArrayList<Organization>();
		Organization organization = null;
		try {

			
			if (content == null || "".equals(content)) {
				sql += "";
			}else {
				/*where username like '%" + content +"%'or nickname like '%" + content +"%'*/
				sql += " where name like '%" + content + "%' or faren_name like '%" + content + "%' ";
				
				sqlCount += " where name like '%" + content + "%' or faren_name like '%" + content + "%' ";
				
			}
			
			preparedStatement = connection.prepareStatement(sqlCount);
			resultSet = preparedStatement.executeQuery();
			
			//总记录数
			int totalRecord = 0;
			
			while(resultSet.next()) {
				totalRecord = resultSet.getInt(1);
			}	
			//总页数
			int totalPage = totalRecord%pageSize == 0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
			
			//加分页
			if(content==null||"".equals(content))
			{
				sql+=" where num between "+pageOffset +" and " + pageSize;	
			}else
			{
				sql+=" and num between "+pageOffset +" and " + pageSize;			
			}
			
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				organization = new Organization();
                organization.setId(resultSet.getInt("id"));
                organization.setName(resultSet.getString("name"));
                organization.setUsci(resultSet.getString("usci"));
                organization.setFarenName(resultSet.getString("faren_name"));
                organization.setTelephone(resultSet.getString("telephone"));
                organization.setType(resultSet.getString("type"));
                organizations.add(organization);
			}	
			//往分页对象里面设置数据
			pager.setDatas(organizations);
//			pager.setPageIndex(pageIndex);
			pager.setPageSize(pageSize);
			pager.setTotalPage(totalPage);
			pager.setTotalRecord(totalRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return pager;
	}

	@Override
	public Pager<Organization> load(String content, int pageIndex, int pageSize) {
		Pager<Organization> pager=new Pager<Organization>();
		Connection connection=DBUtil.getConnection();
		String sql="select * from (select \"ID\",\"NAME\",USCI,FAREN_NAME,TELEPHONE,\"TYPE\" ,rownum as num from \"ORGANIZATION\")";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Organization> organizations=new ArrayList<Organization>();
		Organization organization=null;
		String sqlCount="select count(*) from (select \"ID\",\"NAME\",USCI,FAREN_NAME,TELEPHONE,\"TYPE\" ,rownum as num from \"ORGANIZATION\")";
		if(pageIndex<=0)
		{
			pageIndex=1;
		}
		int start=(pageIndex-1)*pageSize;
		if(content==null||"".equals(content))
		{
			sql+="";
		}else
		{
			sql+="where name like '%'+content+'%'";
			
		}
		try {
			preparedStatement=connection.prepareStatement(sqlCount);
		    resultSet=preparedStatement.executeQuery();
		    //总记录数
		    int totalRecord=0;
		    while(resultSet.next())
		    {
		    	totalRecord=resultSet.getInt(1);
		    }
		    //总页数
		    int totalPage=totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
		  //加分页
		    if(content==null||"".equals(content))
			{
				sql+=" where num between "+start +" and " + pageSize;	
			}else
			{
				sql+=" and num between "+start+" and " + pageSize;			
			}
			
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				organization = new Organization();
                organization.setId(resultSet.getInt("id"));
                organization.setName(resultSet.getString("name"));
                organization.setUsci(resultSet.getString("usci"));
                organization.setFarenName(resultSet.getString("faren_name"));
                organization.setTelephone(resultSet.getString("telephone"));
                organization.setType(resultSet.getString("type"));
                organizations.add(organization);
			}	
			//往分页对象里面设置数据
			pager.setDatas(organizations);
			pager.setPageIndex(pageIndex);
			pager.setPageSize(pageSize);
			pager.setTotalPage(totalPage);
			pager.setTotalRecord(totalRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return pager;
	}

}
