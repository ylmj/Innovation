package com.basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.basic.model.User;
import com.basic.util.DBUtil;
import com.basic.util.Pager;
import com.basic.util.UserException;
import com.basic.util.systemContext;

public class UserDao implements IUser{

	@Override
	public void addUser(User user) {
		//������Ӷ���
		Connection connection=DBUtil.getConnection();
		String sql="select count(*) from user1 where username=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet =null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			//���ս����
			resultSet=preparedStatement.executeQuery();
			//���������
			while(resultSet.next())
			{
				if(resultSet.getInt(1)>0)
				{
					throw new UserException("�û��Ѵ���");
				}
			}
			sql="insert into user1(username,password,platform_name,platform_no,approval_date,approval_number,field) VALUES (?,?,?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2,user.getPassword());
			preparedStatement.setString(3,user.getPlatformName());
			preparedStatement.setString(4,user.getPlatformNo());
			preparedStatement.setString(5,user.getApprovalDate());
			preparedStatement.setString(6,user.getApprovalNum());
			preparedStatement.setString(7,user.getField());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public User loadUser(String username, String password) {
		Connection connection=DBUtil.getConnection();
		String sql="select * from user1 where username= ? and password= ?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		User user=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user=new User();
				user.setId(resultSet.getInt("ID"));
				user.setUsername(resultSet.getString("username"));
				user.setPlatformName(resultSet.getString("platform_name"));
                user.setPlatformNo(resultSet.getString("platform_no"));
                user.setApprovalDate(resultSet.getString("approval_date"));
                user.setApprovalNum(resultSet.getString("approval_number"));
                user.setPassword(resultSet.getString("password"));
                user.setField(resultSet.getString("field"));
                return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ѯʧ��
		return user;
	}

	@Override
	public List<User> loadUser(String username) {
		Connection connection=DBUtil.getConnection();
		String sql="select * from user1 where username = ?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<User> users=new ArrayList<User>();
		User user=new User();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPlatformName(resultSet.getString("platform_name"));
                user.setPlatformNo(resultSet.getString("platform_no"));
                user.setApprovalDate(resultSet.getString("approval_date"));
                user.setApprovalNum(resultSet.getString("approval_number"));
                user.setPassword(resultSet.getString("password"));
                user.setField(resultSet.getString("field"));
                users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User loadUser(int id) {
		Connection connection=DBUtil.getConnection();
		String sql="select * from user1 where ID = ?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		User user=null;
		user=new User();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user.setUsername(resultSet.getString("username"));
				user.setPlatformName(resultSet.getString("platform_name"));
                user.setPlatformNo(resultSet.getString("platform_no"));
                user.setApprovalDate(resultSet.getString("approval_date"));
                user.setApprovalNum(resultSet.getString("approval_number"));
                user.setPassword(resultSet.getString("password"));
                user.setField(resultSet.getString("field"));
                return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return user;
	}

	@Override
	public Pager<User> load(String content) {
//		int pageIndex = systemContext.getPageIndex();
		int pageSize = systemContext.getPageSize();
		int pageOffset = systemContext.getpageOffset();
		
		Pager<User> pager = new  Pager<User>();
		Connection connection = DBUtil.getConnection();
		//������䴫�����
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//׼��sql���
		String sql = "select * from (select ID,USERNAME,\"PASSWORD\" ,PLATFORM_NAME,PLATFORM_NO,APPROVAL_DATE,APPROVAL_NUMBER,FIELD, rownum as num from user1)  ";
		//����������
		String  sqlCount = "select count(*) from (select ID,USERNAME,\"PASSWORD\" ,PLATFORM_NAME,PLATFORM_NO,APPROVAL_DATE,APPROVAL_NUMBER,FIELD, rownum as num from user1) ";
		//������ֻ�ܷ���user����
		List<User> users = new ArrayList<User>();
		User user = null;
		try {
//			if (pageIndex <= 0) {
//				pageIndex = 1;
//			}
//			
//			int start = (pageIndex-1)*pageSize;
			
			if (content == null || "".equals(content)) {
				sql += "";
			}else {
				/*where username like '%" + content +"%'or nickname like '%" + content +"%'*/
				sql += " where username like '%" + content + "%' or platform_name like '%" + content + "%' ";
				
				sqlCount += " where username like '%" + content + "%' or platform_name like '%" + content + "%' ";
				
			}
			
			preparedStatement = connection.prepareStatement(sqlCount);
			resultSet = preparedStatement.executeQuery();
			
			//�ܼ�¼��
			int totalRecord = 0;
			
			while(resultSet.next()) {
				totalRecord = resultSet.getInt(1);
			}	
			//��ҳ��
			int totalPage = totalRecord%pageSize == 0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
			
			//�ӷ�ҳ
			if(content==null||"".equals(content))
			{
				sql+=" where num between "+pageOffset +" and " + pageSize;	
			}else
			{
				sql+=" and num between "+pageOffset +" and " + pageSize;			
			}
			
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
/*			preparedStatement.setInt(1, pageOffset);
			preparedStatement.setInt(2, pageSize);*/
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user=new User();
				user.setId(resultSet.getInt("ID"));
				user.setUsername(resultSet.getString("username"));
				user.setPlatformName(resultSet.getString("platform_name"));
                user.setPlatformNo(resultSet.getString("platform_no"));
                user.setApprovalDate(resultSet.getString("approval_date"));
                user.setApprovalNum(resultSet.getString("approval_number"));
                user.setPassword(resultSet.getString("password"));
                user.setField(resultSet.getString("field"));
                users.add(user);
			}	
			//����ҳ����������������
			pager.setDatas(users);
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
	public Pager<User> load(String content, int pageIndex, int pageSize) {
		Pager<User> pager=new Pager<User>();
		Connection connection=DBUtil.getConnection();
		String sql="select * from (select ID,USERNAME,\"PASSWORD\" ,PLATFORM_NAME,PLATFORM_NO,APPROVAL_DATE,APPROVAL_NUMBER,FIELD, rownum as num from user1)";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String sqlCount="select count(*) from (select ID,USERNAME,\"PASSWORD\" ,PLATFORM_NAME,PLATFORM_NO,APPROVAL_DATE,APPROVAL_NUMBER,FIELD, rownum as num from user1)";
		List <User> users=new ArrayList<User>();
		User user=null;
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
			/*where username like '%" + content +"%' or platform_name like '%' + content + '%'*/
			sql+="where username like '%' + content + '%' ";		
		}
		try {
			preparedStatement=connection.prepareStatement(sqlCount);
		    resultSet=preparedStatement.executeQuery();
		    //�ܼ�¼��
		    int totalRecord=0;
		    while(resultSet.next())
		    {
		    	totalRecord=resultSet.getInt(1);
		    }
		    //��ҳ��
		    int totalPage=totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
		  //�ӷ�ҳ
		    if(content==null||"".equals(content))
			{
				sql+=" where num between ? and ? ";
			}else
			{
				sql+=" and num between ? and ?";			
			}
			
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user=new User();
				user.setId(resultSet.getInt("ID"));
				user.setUsername(resultSet.getString("username"));
				user.setPlatformName(resultSet.getString("platform_name"));
                user.setPlatformNo(resultSet.getString("platform_no"));
                user.setApprovalDate(resultSet.getString("approval_date"));
                user.setApprovalNum(resultSet.getString("approval_number"));
                user.setPassword(resultSet.getString("password"));
                user.setField(resultSet.getString("field"));
			    users.add(user);
			}	
			//����ҳ����������������
			pager.setDatas(users);
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

	@Override
	public List<User> load() {
		Connection connection=DBUtil.getConnection();
		String sql="select * from user1 ";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List <User> users=new ArrayList<User>();
		User user=null;
		try {
		    preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user=new User();
				user.setUsername(resultSet.getString("username"));
				user.setPlatformName(resultSet.getString("platform_name"));
                user.setPlatformNo(resultSet.getString("platform_no"));
                user.setApprovalDate(resultSet.getString("approval_date"));
                user.setApprovalNum(resultSet.getString("approval_number"));
                user.setPassword(resultSet.getString("password"));
                user.setField(resultSet.getString("field"));
			    users.add(user);
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.close(resultSet);
				DBUtil.close(preparedStatement);
				DBUtil.close(connection);
			}
			return users;
	}

}
