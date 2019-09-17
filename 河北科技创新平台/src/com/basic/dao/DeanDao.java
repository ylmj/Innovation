package com.basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.basic.model.Dean;
import com.basic.model.User;
import com.basic.util.DBUtil;
import com.basic.util.Pager;
import com.basic.util.systemContext;


public class DeanDao implements IDean{

	@Override
	public int addDean(Dean dean) {
		Connection con = DBUtil.getConnection();
        String sql = "INSERT INTO dean('name','sex','date','job_title','major','education','degree','telephone','mobilephone','email') VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,dean.getName());
            ps.setString(2,dean.getSex());
            ps.setString(3,dean.getDate());
            ps.setString(4,dean.getJobTitle());
            ps.setString(5,dean.getMajor());
            ps.setString(6,dean.getEducation());
            ps.setString(7,dean.getDegree());
            ps.setString(8,dean.getTelephone());
            ps.setString(9,dean.getMobilephone());
            ps.setString(10,dean.getEmail());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while (rs.next()){
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
	public Dean loadDean(int id) {
		Connection connection =DBUtil.getConnection();
		String sql="select * from dean where id= ? ";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Dean dean=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				dean=new Dean();
				dean.setId(resultSet.getInt("id"));
				dean.setName(resultSet.getString("name"));
				dean.setSex(resultSet.getString("sex"));
				dean.setDate(resultSet.getString("date"));
				dean.setJobTitle(resultSet.getString("job_title"));
				dean.setMajor(resultSet.getString("major"));
				dean.setEducation(resultSet.getString("education"));
				dean.setDegree(resultSet.getString("degree"));
                dean.setTelephone(resultSet.getString("telephone"));
                dean.setMobilephone(resultSet.getString("mobilephone"));
                dean.setEmail(resultSet.getString("email"));
			}
			return dean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
		return dean;
	}

	@Override
	public void updateDean(Dean dean) {
		Connection connection =DBUtil.getConnection();
	    String sql="UPDATE dean set 'name'=?,'sex'=?,'date'=?,'job_title'=?,'major'=?,'education'=?,'degree'=?,'telephone'=?,'mobilephone'=?,'email'=? where ('id'=?)";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			//创建一个默认PreparedStatement对象，该对象能获取自动生成的键，适合insert语句
			//该语句可以自动生成键值，指示是否返回自动生成键的标志
			preparedStatement.setString(1, dean.getName());
			preparedStatement.setString(2, dean.getSex());
			preparedStatement.setString(3, dean.getDate());
			preparedStatement.setString(4, dean.getJobTitle());
			preparedStatement.setString(5, dean.getMajor());
			preparedStatement.setString(6, dean.getEducation());
			preparedStatement.setString(7, dean.getDegree());
			preparedStatement.setString(8, dean.getTelephone());
			preparedStatement.setString(9, dean.getMobilephone());
			preparedStatement.setString(10, dean.getEmail());
			preparedStatement.setInt(11, dean.getId());
			System.out.println(preparedStatement.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}	
	}

	@Override
	public List<Dean> load() {
		Connection connection=DBUtil.getConnection();
		String sql="select * from dean";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List <Dean> deans=new ArrayList<Dean>();
		Dean dean=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				dean=new Dean();
				dean.setId(resultSet.getInt("id"));
				dean.setName(resultSet.getString("name"));
				dean.setSex(resultSet.getString("sex"));
				dean.setDate(resultSet.getString("date"));
				dean.setJobTitle(resultSet.getString("job_title"));
				dean.setMajor(resultSet.getString("major"));
				dean.setEducation(resultSet.getString("education"));
				dean.setDegree(resultSet.getString("degree"));
				dean.setTelephone(resultSet.getString("telephone"));
				dean.setMobilephone(resultSet.getString("mobilephone"));
				dean.setEmail(resultSet.getString("email"));
				deans.add(dean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return deans;
	}

	@Override
	//按名字查询平台
	public Pager<Dean> load(String content) {
		int pageSize = systemContext.getPageSize();
		int pageOffset = systemContext.getpageOffset();
		
		Pager<Dean> pager = new  Pager<Dean>();
		Connection connection = DBUtil.getConnection();
		//创建语句传输对象
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//准备sql语句
		String sql = "select * from (select ID,NAME,SEX ,\"DATE\",JOB_TITLE,MAJOR,EDUCATION,\"DEGREE\",TELEPHONE,MOBILEPHONE,EMAIL, rownum as num from dean) ";
		//数据总条数
		String  sqlCount = "select count(*) from (select ID,NAME,SEX ,\"DATE\",JOB_TITLE,MAJOR,EDUCATION,\"DEGREE\",TELEPHONE,MOBILEPHONE,EMAIL, rownum as num from dean) ";
		//集合中只能放入user对象
		List<Dean> deans = new ArrayList<Dean>();
		Dean dean = null;
		try {
	
			if (content == null || "".equals(content)) {
				sql += "";
			}else {
				 /*where name like '%" + content + "%' or faren_name like '%" + content + "%' */
				sql += " where name like '%" + content + "%' ";
				
				sqlCount += " where name like '%" + content + "%' ";
				
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
				dean=new Dean();
				dean.setId(resultSet.getInt("id"));
				dean.setName(resultSet.getString("name"));
				dean.setSex(resultSet.getString("sex"));
				dean.setDate(resultSet.getString("date"));
				dean.setJobTitle(resultSet.getString("job_title"));
				dean.setMajor(resultSet.getString("major"));
				dean.setEducation(resultSet.getString("education"));
				dean.setDegree(resultSet.getString("degree"));
				dean.setTelephone(resultSet.getString("telephone"));
				dean.setMobilephone(resultSet.getString("mobilephone"));
				dean.setEmail(resultSet.getString("email"));
				deans.add(dean);
			}	
			//往分页对象里面设置数据
			pager.setDatas(deans);

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


	public Pager<Dean> load(String content, int pageIndex, int pageSize) {
		Pager<Dean> pager=new Pager<Dean>();
		Connection connection=DBUtil.getConnection();
		String sql="select * from (select ID,NAME,SEX ,\"DATE\",JOB_TITLE,MAJOR,EDUCATION,\"DEGREE\",TELEPHONE,MOBILEPHONE,EMAIL, rownum as num from dean) ";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String sqlCount="select count(*) from (select ID,NAME,SEX ,\"DATE\",JOB_TITLE,MAJOR,EDUCATION,\"DEGREE\",TELEPHONE,MOBILEPHONE,EMAIL, rownum as num from dean) ";
		List <Dean> deans=new ArrayList<Dean>();
		Dean dean=null;
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
				sql+=" and num between "+pageSize +" and " + pageSize;			
			}
			
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				dean=new Dean();
				dean.setId(resultSet.getInt("id"));
				dean.setName(resultSet.getString("name"));
				dean.setSex(resultSet.getString("sex"));
				dean.setDate(resultSet.getString("date"));
				dean.setJobTitle(resultSet.getString("job_title"));
				dean.setMajor(resultSet.getString("major"));
				dean.setEducation(resultSet.getString("education"));
				dean.setDegree(resultSet.getString("degree"));
				dean.setTelephone(resultSet.getString("telephone"));
				dean.setMobilephone(resultSet.getString("mobilephone"));
				dean.setEmail(resultSet.getString("email"));
				deans.add(dean);
			}	
			//往分页对象里面设置数据
			pager.setDatas(deans);
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
