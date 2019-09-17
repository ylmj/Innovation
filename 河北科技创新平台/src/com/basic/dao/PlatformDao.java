package com.basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.basic.model.Dean;
import com.basic.model.Organization;
import com.basic.model.Platform;
import com.basic.model.User;
import com.basic.util.DBUtil;
import com.basic.util.Pager;
import com.basic.util.systemContext;

public class PlatformDao implements IPlatform{

	@Override
	public void addPlatform(Platform platform) {
		 //保存成员类数据
        DeanDao deanDao = new DeanDao();
        OrganizationDao organizationDao = new OrganizationDao();
        platform.getDean().setId(deanDao.addDean(platform.getDean()));
        platform.getOrganization().setId(organizationDao.addOrganization(platform.getOrganization()));

        Connection con = DBUtil.getConnection();
        String sql = "INSERT INTO PLATFORM_INFO (Puserid, Porganizationid, Pdeanid, Pgrade, Pdistrict, Pform, Punite, Pjjjgj, Pindustry, Psubject, Pgjdw, Pwebsite, Pweburl, Paddress, Ppostcode,Pstatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,platform.getUser().getId());
            ps.setInt(2,platform.getOrganization().getId());
            ps.setInt(3,platform.getDean().getId());
            ps.setInt(4,platform.getGrade());
            ps.setString(5,platform.getDistrict());
            ps.setInt(6,platform.getForm());
            ps.setBoolean(7,platform.isUnite());
            ps.setBoolean(8,platform.isJjjgj());
            ps.setString(9,platform.getIndustry());
            ps.setString(10,platform.getSubject());
            //将共建单位数组用分号连接
            String gjdw = ";";
            if (platform.getGjdw() != null) {
            	gjdw="";
                for (String g : platform.getGjdw()) {
                    gjdw += (g + ";");
                }
            }
            ps.setString(11,gjdw);
            ps.setString(12,platform.getSitename());
            ps.setString(13,platform.getWebsite());
            ps.setString(14,platform.getAddr());
            ps.setString(15,platform.getPostcode());
            ps.setInt(16,platform.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
		
	}

	@Override
	public Platform loadPlatform(int id) {
		UserDao userDao = new UserDao();
        DeanDao deanDao = new DeanDao();
        OrganizationDao organizationDao = new OrganizationDao();

        Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM platform_info WHERE id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Platform platform = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {

                platform = new Platform();

                User user = userDao.loadUser(rs.getInt("Puserid"));
                Dean dean = deanDao.loadDean(rs.getInt("Pdeanid"));
                Organization organization = organizationDao.loadOrganization(rs.getInt("Porganizationid"));

                platform.setId(rs.getInt("id"));
                platform.setUser(user);
                platform.setDean(dean);
                platform.setOrganization(organization);
                platform.setGrade(rs.getInt("Pgrade"));
                platform.setDistrict(rs.getString("Pdistrict"));
                platform.setId(rs.getInt("Pform"));
                platform.setUnite(rs.getBoolean("Punite"));
                platform.setJjjgj(rs.getBoolean("Pjjjgj"));
                platform.setIndustry(rs.getString("Pindustry"));
                platform.setSubject(rs.getString("Psubject"));
                platform.setGjdw(rs.getString("Pgjdw").split(";"));
                platform.setSitename(rs.getString("Psitename"));
                platform.setWebsite(rs.getString("Pweburl"));
                platform.setAddr(rs.getString("Paddr"));
                platform.setPostcode(rs.getString("Ppostcode"));
                platform.setStatus(rs.getInt("Pstatus"));
                System.out.println("dsaf adsf dsfa");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("dsaf adsf dsfa");
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return platform;
	}

	@Override
	public void updatePlatform(Platform platform) {
		DeanDao deanDao = new DeanDao();
        OrganizationDao organizationDao = new OrganizationDao();
        deanDao.updateDean(platform.getDean());
        organizationDao.updateOrganization(platform.getOrganization());
        
        Connection con = DBUtil.getConnection();
        String sql = "UPDATE platform_info SET Pgrade=?, Pdistrict=?, Pform=?, Punite=?, Pjjjgj=?, Pindustry=?, Psubject=?, Pgjdw=?, Pwebsite=?, Pweburl=?, Paddress =?, Ppostcode =?, Pstatus =? WHERE (id=?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,platform.getGrade());
            ps.setString(2,platform.getDistrict());
            ps.setInt(3,platform.getForm());
            ps.setBoolean(4,platform.isUnite());
            ps.setBoolean(5,platform.isJjjgj());
            ps.setString(6,platform.getIndustry());
            ps.setString(7,platform.getSubject());
            //将共建单位数组用分号连接
            String gjdw = "";
            if (platform.getGjdw() != null) {
                for (String g : platform.getGjdw()) {
                    gjdw += (g + ";");
                }
            }
            ps.setString(8,gjdw);
            ps.setString(9,platform.getSitename());
            ps.setString(10,platform.getWebsite());
            ps.setString(11,platform.getAddr());
            ps.setString(12,platform.getPostcode());
            ps.setInt(13,platform.getStatus());
            ps.setInt(14,platform.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
		
	}

	@Override
	public Platform loadPlatformByUserid(int userid) {
		UserDao userDao = new UserDao();
        DeanDao deanDao = new DeanDao();
        OrganizationDao organizationDao = new OrganizationDao();

        Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM platform_info WHERE Puserid = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Platform platform = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,userid);
            rs = ps.executeQuery();
            while (rs.next()) {

                platform = new Platform();

                User user = userDao.loadUser(rs.getInt(userid));
                Dean dean = deanDao.loadDean(rs.getInt("Pdeanid"));
                Organization organization = organizationDao.loadOrganization(rs.getInt("Porganizationid"));

                platform.setId(rs.getInt("id"));
                platform.setUser(user);
                platform.setDean(dean);
                platform.setOrganization(organization);
                platform.setGrade(rs.getInt("Pgrade"));
                platform.setDistrict(rs.getString("Pdistrict"));
                platform.setForm(rs.getInt("Pform"));
                platform.setUnite(rs.getBoolean("Punite"));
                platform.setJjjgj(rs.getBoolean("Pjjjgj"));
                platform.setIndustry(rs.getString("Pindustry"));
                platform.setSubject(rs.getString("Psubject"));
                platform.setGjdw(rs.getString("Pgjdw").split(";"));
                platform.setSitename(rs.getString("Pwebsite"));
                platform.setWebsite(rs.getString("Pweburl"));
                platform.setAddr(rs.getString("Paddress"));
                platform.setPostcode(rs.getString("Ppostcode"));
                platform.setStatus(rs.getInt("Pstatus"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return platform;
	}

	@Override
	public Platform loadPlatformByDeanid(int deanid) {
		UserDao userDao = new UserDao();
        DeanDao deanDao = new DeanDao();
        OrganizationDao organizationDao = new OrganizationDao();

        Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM platform_info WHERE Pdeanid = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Platform platform = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,deanid);
            rs = ps.executeQuery();
            while (rs.next()) {

                platform = new Platform();

                User user = userDao.loadUser(rs.getInt("Puserid"));
                Dean dean = deanDao.loadDean(deanid);
                Organization organization = organizationDao.loadOrganization(rs.getInt("Porganizationid"));

                platform.setId(rs.getInt("id"));
                platform.setUser(user);
                platform.setDean(dean);
                platform.setOrganization(organization);
                platform.setGrade(rs.getInt("Pgrade"));
                platform.setDistrict(rs.getString("Pdistrict"));
                platform.setForm(rs.getInt("Pform"));
                platform.setUnite(rs.getBoolean("Punite"));
                platform.setJjjgj(rs.getBoolean("Pjjjgj"));
                platform.setIndustry(rs.getString("Pindustry"));
                platform.setSubject(rs.getString("Psubject"));
                platform.setGjdw(rs.getString("Pgjdw").split(";"));
                platform.setSitename(rs.getString("Pwebsite"));
                platform.setWebsite(rs.getString("Pweburl"));
                platform.setAddr(rs.getString("Paddress"));
                platform.setPostcode(rs.getString("Ppostcode"));
                platform.setStatus(rs.getInt("Pstatus"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return platform;
	}

	@Override
	public Platform loadPlatformByOrganizationid(int organizationid) {
		UserDao userDao = new UserDao();
        DeanDao deanDao = new DeanDao();
        OrganizationDao organizationDao = new OrganizationDao();

        Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM platform_info WHERE Porganizationid = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Platform platform = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,organizationid);
            rs = ps.executeQuery();
            while (rs.next()) {

                platform = new Platform();

                User user = userDao.loadUser(rs.getInt("Puserid"));
                Dean dean = deanDao.loadDean(rs.getInt("Pdeanid"));
                Organization organization = organizationDao.loadOrganization(organizationid);

                platform.setId(rs.getInt("id"));
                platform.setUser(user);
                platform.setDean(dean);
                platform.setOrganization(organization);
                platform.setGrade(rs.getInt("Pgrade"));
                platform.setDistrict(rs.getString("Pdistrict"));
                platform.setForm(rs.getInt("Pform"));
                platform.setUnite(rs.getBoolean("Punite"));
                platform.setJjjgj(rs.getBoolean("Pjjjgj"));
                platform.setIndustry(rs.getString("Pindustry"));
                platform.setSubject(rs.getString("Psubject"));
                platform.setGjdw(rs.getString("Pgjdw").split(";"));
                platform.setSitename(rs.getString("Pwebsite"));
                platform.setWebsite(rs.getString("Pweburl"));
                platform.setAddr(rs.getString("Paddress"));
                platform.setPostcode(rs.getString("Ppostcode"));
                platform.setStatus(rs.getInt("Pstatus"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return platform;
	}

	public Pager<Platform> loadPlatformComplex(String platform_name, String field, int gradeValue, String jjjgj,String platform_site_name,
			String dep_organization_name, String dep_organization_faren, String dean_name) {        
        int pageSize = systemContext.getPageSize();
		int pageOffset = systemContext.getpageOffset();
		UserDao userDao = new UserDao();
        DeanDao deanDao = new DeanDao();
        OrganizationDao organizationDao = new OrganizationDao();
		Pager<Platform> pager = new  Pager<Platform>();
		Connection connection = DBUtil.getConnection();
		//创建语句传输对象
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//准备sql语句
		String sql = "SELECT \"ID\",PUSERID,PDEANID,PORGANIZATIONID,PDISTRICT,PFORM,PUNITE,PJJJGJ, " + 
				"PINDUSTRY,PGJDW,PWEBSITE,PADDRESS,PPOSTCODE,PSTATUS from (SELECT a.\"ID\",PUSERID,PDEANID,PORGANIZATIONID,PDISTRICT,PFORM,PUNITE,PJJJGJ, " + 
				"PINDUSTRY,PGJDW,PWEBSITE,PADDRESS,PPOSTCODE,PSTATUS,USER1.USERNAME,USER1.\"PASSWORD\",USER1.PLATFORM_NAME, " + 
				"USER1.PLATFORM_NO,USER1.APPROVAL_DATE," + 
				"USER1.APPROVAL_NUMBER,USER1.FIELD,DEAN.\"NAME\",DEAN.\"DATE\",DEAN.\"DEGREE\",DEAN.EDUCATION,DEAN.EMAIL,DEAN.JOB_TITLE,DEAN.MAJOR, " + 
				"DEAN.MOBILEPHONE,DEAN.TELEPHONE,DEAN.SEX,\"ORGANIZATION\".\"NAME\",\"ORGANIZATION\".USCI,\"ORGANIZATION\".FAREN_NAME,\"ORGANIZATION\".TELEPHONE, " + 
				"\"ORGANIZATION\".\"TYPE\", " + 
				"ROWNUM AS NUM from PLATFORM_INFO a " + 
				"inner join dean on a.Pdeanid = dean.ID  " + 
				"join \"ORGANIZATION\" on a.PorganizationID=\"ORGANIZATION\".ID " + 
				"join USER1 on a.Puserid=USER1.ID ) where"; 
		//数据总条数
		String  sqlCount ="SELECT count(*) from (SELECT a.\"ID\",PUSERID,PDEANID,PORGANIZATIONID,PDISTRICT,PFORM,PUNITE,PJJJGJ, " + 
				"PINDUSTRY,PGJDW,PWEBSITE,PADDRESS,PPOSTCODE,PSTATUS,USER1.USERNAME,USER1.\"PASSWORD\",USER1.PLATFORM_NAME, " + 
				"USER1.PLATFORM_NO,USER1.APPROVAL_DATE," + 
				"USER1.APPROVAL_NUMBER,USER1.FIELD,DEAN.\"NAME\",DEAN.\"DATE\",DEAN.\"DEGREE\",DEAN.EDUCATION,DEAN.EMAIL,DEAN.JOB_TITLE,DEAN.MAJOR, " + 
				"DEAN.MOBILEPHONE,DEAN.TELEPHONE,DEAN.SEX,\"ORGANIZATION\".\"NAME\",\"ORGANIZATION\".USCI,\"ORGANIZATION\".FAREN_NAME,\"ORGANIZATION\".TELEPHONE, " + 
				"\"ORGANIZATION\".\"TYPE\", " + 
				"ROWNUM AS NUM from PLATFORM_INFO a " + 
				"inner join dean on a.Pdeanid = dean.ID  " + 
				"join \"ORGANIZATION\" on a.PorganizationID=\"ORGANIZATION\".ID " + 
				"join USER1 on a.Puserid=USER1.ID ) where"; 
		//集合中只能放入user对象
		List<Platform> platforms = new ArrayList<Platform>();
		Platform platform = null;
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0;
		/*" where name like '%" + content + "%' or faren_name like '%" + content + "%' "*/
				
			if ((platform_name == null&&field==null&&gradeValue==0&&jjjgj==null&&platform_site_name==null&&dep_organization_name==null&&dep_organization_faren==null&&dean_name==null) 
		    || ("".equals(platform_name) && "".equals(field) && "".equals(gradeValue)&& "".equals(jjjgj)&&"".equals(platform_site_name)&&"".equals(dep_organization_name)&&"".equals(dep_organization_faren)&&"".equals(dean_name)))
			{
				sql += "";
				sqlCount+="";
			}else {
				if(platform_name!=null&&!"".equals(platform_name))
				{
					sql +="user1.platform_name like '%" + platform_name + "%' ";
					sqlCount +="user1.platform_name like '%" + platform_name + "%' ";
					a=1;
				}
				if(field!=null&&!"".equals(field))
				{
					if (a==1)
					{
						sql+=" and ";
						sqlCount+=" and ";
					}
					sql +=" user1.field like '%" + field + "%' ";
					sqlCount +="user1.field like '%" +field + "%' ";
					b=1;
				}
				if(gradeValue!=0)
				{
					if(!(a==0&&b==0))
					{
						sql+=" and ";
						sqlCount+=" and ";
					}
					sql+="  a.Pgrade like '%" + gradeValue + "%' ";
					sqlCount+=" a.Pgrade like '%" + gradeValue + "%' ";
					c=1;
				}
				if(jjjgj!=null&&!"".equals(jjjgj))
				{
					/*前面一个都没有的时候不需要加and 但凡有一个就需要加and
					 * */
					if(!(a==0&&b==0&&c==0))
					{
						sql+=" and ";
						sqlCount+=" and ";
					}
					sql+="  a.Pjjjgj like '%" + jjjgj + "%' ";
					sqlCount+=" a.Pjjjgj like '%" + jjjgj + "%' ";
					d=1;
				}
				if(platform_site_name!=null&&!"".equals(platform_site_name))
				{
					if(!(a==0&&b==0&&c==0&&d==0))
					{
						sql+=" and ";
						sqlCount+=" and ";
					}
					sql+=" a.Pwebsite like '%" + platform_site_name + "%' ";
					sqlCount+=" a.Pwebsite like '%" + platform_site_name + "%' ";
					e=1;
				}
				if(dep_organization_name!=null&&!"".equals(dep_organization_name))
				{
					if(!(a==0&&b==0&&c==0&&d==0&&e==0))
					{
						sql+=" and ";
						sqlCount+=" and ";
					}
					sql+=" organization.name like '%" + dep_organization_name + "%' ";
					sqlCount+=" organization.name like '%" +dep_organization_name + "%' ";
					f=1;
				}
				if(dep_organization_faren!=null&&!"".equals(dep_organization_faren))
				{
					if(!(a==0&&b==0&&c==0&&d==0&&e==0&&f==0))
					{
						sql+=" and ";
						sqlCount+=" and ";
					}
					sql+=" organization.faren_name like '%" + dep_organization_faren + "%' ";
					sqlCount+="organization.faren_name like '%" +dep_organization_faren + "%' ";
					g=1;
				}
				if(dean_name!=null&&!"".equals(dean_name))
				{
					if(!(a==0&&b==0&&c==0&&d==0&&e==0&&f==0&&g==0))
					{
						sql+=" and ";
						sqlCount+=" and ";
					}
					sql+=" dean.name like '%" +dean_name + "%' ";
					sqlCount+=" dean.name like '%" +dean_name + "%' ";
				}
			}
			
			try {
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
			if(!(a==0&&b==0&&c==0&&d==0&&e==0&&f==0&&g==0))
			{
				sql+=" and num between "+pageOffset +" and " + pageSize;	
			}else
			{
				sql+=" num between "+pageOffset +" and " + pageSize;			
			}
			
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				platform = new Platform();

                User user = userDao.loadUser(resultSet.getInt("Puserid"));
                Dean dean = deanDao.loadDean(resultSet.getInt("Pdeanid"));
                Organization organization = organizationDao.loadOrganization(resultSet.getInt("Porganizationid"));

                platform.setId(resultSet.getInt("id"));
                platform.setUser(user);
                platform.setDean(dean);
                platform.setOrganization(organization);
                platform.setGrade(resultSet.getInt("Pgrade"));
                platform.setDistrict(resultSet.getString("Pdistrict"));
                platform.setForm(resultSet.getInt("Pform"));
                platform.setUnite(resultSet.getBoolean("Punite"));
                platform.setJjjgj(resultSet.getBoolean("Pjjjgj"));
                platform.setIndustry(resultSet.getString("Pindustry"));
                platform.setSubject(resultSet.getString("Psubject"));
                platform.setGjdw(resultSet.getString("Pgjdw").split(";"));
                platform.setSitename(resultSet.getString("Pwebsite"));
                platform.setWebsite(resultSet.getString("Pweburl"));
                platform.setAddr(resultSet.getString("Paddress"));
                platform.setPostcode(resultSet.getString("Ppostcode"));
                platform.setStatus(resultSet.getInt("Pstatus"));
                platforms.add(platform);
			}	
			//往分页对象里面设置数据
			pager.setDatas(platforms);
			pager.setPageSize(pageSize);
			pager.setTotalPage(totalPage);
			pager.setTotalRecord(totalRecord);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return pager;
	}

	@Override
	public Pager<Platform> loadPlatformClassification(String[] district) {
		// TODO Auto-generated method stub
		 int pageSize = systemContext.getPageSize();
			int pageOffset = systemContext.getpageOffset();
			UserDao userDao = new UserDao();
	        DeanDao deanDao = new DeanDao();
	        OrganizationDao organizationDao = new OrganizationDao();
			Pager<Platform> pager = new  Pager<Platform>();
			Connection connection = DBUtil.getConnection();
			//创建语句传输对象
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			//准备sql语句
			String sql = "SELECT \"ID\",PUSERID,PDEANID,PORGANIZATIONID,PDISTRICT,PFORM,PUNITE,PJJJGJ,Pgrade,Psubject,Pweburl, " + 
					"PINDUSTRY,PGJDW,PWEBSITE,PADDRESS,PPOSTCODE,PSTATUS from (SELECT a.\"ID\",PUSERID,PSUBJECT,PDEANID,PORGANIZATIONID,PDISTRICT,PFORM,PUNITE,PJJJGJ, " + 
					"PINDUSTRY,PGJDW,PWEBSITE,PADDRESS,PPOSTCODE,Pgrade,Pweburl,PSTATUS,USER1.USERNAME,USER1.\"PASSWORD\",USER1.PLATFORM_NAME, " + 
					"USER1.PLATFORM_NO,USER1.APPROVAL_DATE," + 
					"USER1.APPROVAL_NUMBER,USER1.FIELD,DEAN.\"NAME\",DEAN.\"DATE\",DEAN.\"DEGREE\",DEAN.EDUCATION,DEAN.EMAIL,DEAN.JOB_TITLE,DEAN.MAJOR, " + 
					"DEAN.MOBILEPHONE,DEAN.TELEPHONE,DEAN.SEX,\"ORGANIZATION\".\"NAME\",\"ORGANIZATION\".USCI,\"ORGANIZATION\".FAREN_NAME,\"ORGANIZATION\".TELEPHONE, " + 
					"\"ORGANIZATION\".\"TYPE\", " + 
					"ROWNUM AS NUM from PLATFORM_INFO a " + 
					"inner join dean on a.Pdeanid = dean.ID  " + 
					"join \"ORGANIZATION\" on a.PorganizationID=\"ORGANIZATION\".ID " + 
					"join USER1 on a.Puserid=USER1.ID ) "; 
			//数据总条数
			String  sqlCount = "SELECT count(*) from (SELECT a.\"ID\",PUSERID,PDEANID,PORGANIZATIONID,PDISTRICT,PFORM,PUNITE,PJJJGJ,Pweburl, " + 
					"PINDUSTRY,PGJDW,PWEBSITE,Pgrade,PADDRESS,Pweburl,PPOSTCODE,PSTATUS,USER1.USERNAME,USER1.\"PASSWORD\",USER1.PLATFORM_NAME, " + 
					"USER1.PLATFORM_NO,USER1.APPROVAL_DATE, " + 
					"USER1.APPROVAL_NUMBER,USER1.FIELD,DEAN.\"NAME\",DEAN.\"DATE\",DEAN.\"DEGREE\",DEAN.EDUCATION,DEAN.EMAIL,DEAN.JOB_TITLE,DEAN.MAJOR,Pgrade," + 
					"DEAN.MOBILEPHONE,DEAN.TELEPHONE,DEAN.SEX,\"ORGANIZATION\".\"NAME\",\"ORGANIZATION\".USCI,\"ORGANIZATION\".FAREN_NAME,\"ORGANIZATION\".TELEPHONE, " + 
					"\"ORGANIZATION\".\"TYPE\", " + 
					"ROWNUM AS NUM from PLATFORM_INFO a  " + 
					"inner join dean on a.Pdeanid = dean.ID  " + 
					"join \"ORGANIZATION\" on a.PorganizationID=\"ORGANIZATION\".ID " + 
					"join USER1 on a.Puserid=USER1.ID ) "; 
			//集合中只能放入user对象
			List<Platform> platforms = new ArrayList<Platform>();
			Platform platform = null;
			
			/*" where name like '%" + content + "%' or faren_name like '%" + content + "%' "*/
					
				try {
					if(district==null||"".equals(district))
					{
						sql+="";
						sqlCount+="";
					}else
					{
						sql+=" where Pdistrict =  "+district[0] +" ";
						sqlCount+=" where Pdistrict = "+district[0]+ " ";
						for(int i=1;i<district.length;i++)
						{
							sql+="or Pdistrict = "+district[i]+" ";
							sqlCount+="or Pdistrict = "+district[i]+" ";
							System.out.println("-------"+sql);		
						}
					}
					System.out.println("ehjkhk");
					System.out.println(sql);
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
				if(district==null||"".equals(district))
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
					platform = new Platform();

	                User user = userDao.loadUser(resultSet.getInt("Puserid"));
	                Dean dean = deanDao.loadDean(resultSet.getInt("Pdeanid"));
	                Organization organization = organizationDao.loadOrganization(resultSet.getInt("Porganizationid"));

	                platform.setId(resultSet.getInt("id"));
	                platform.setUser(user);
	                platform.setDean(dean);
	                platform.setOrganization(organization);
	                platform.setGrade(resultSet.getInt("Pgrade"));
	                platform.setDistrict(resultSet.getString("Pdistrict"));
	                platform.setForm(resultSet.getInt("Pform"));
	                platform.setUnite(resultSet.getBoolean("Punite"));
	                platform.setJjjgj(resultSet.getBoolean("Pjjjgj"));
	                platform.setIndustry(resultSet.getString("Pindustry"));
	                platform.setSubject(resultSet.getString("Psubject"));
	                platform.setGjdw(resultSet.getString("PGJDW").split(";"));
	                platform.setSitename(resultSet.getString("Pwebsite"));
	                platform.setWebsite(resultSet.getString("Pweburl"));
	                platform.setAddr(resultSet.getString("Paddress"));
	                platform.setPostcode(resultSet.getString("Ppostcode"));
	                platform.setStatus(resultSet.getInt("Pstatus"));
	                platforms.add(platform);
				}	
				//往分页对象里面设置数据
				pager.setDatas(platforms);
				pager.setPageSize(pageSize);
				pager.setTotalPage(totalPage);
				pager.setTotalRecord(totalRecord);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			finally {
				DBUtil.close(resultSet);
				DBUtil.close(preparedStatement);
				DBUtil.close(connection);
			}
			return pager;
	}

	/*@Override
	public Pager<Platform> loadPlatform(String[] condition, String[] values, String[] style, String[] con, String date1, String date2,
			int platform_grade) {
		// TODO Auto-generated method stub
		if(values==null)
		{
			System.out.println("数组长度"+values.length);
			for(int i=0;i<values.length;i++)
			{
				values[i]="";
			}
		}
		int pageSize = systemContext.getPageSize();
		int pageOffset = systemContext.getpageOffset();
		UserDao userDao = new UserDao();
        DeanDao deanDao = new DeanDao();
        OrganizationDao organizationDao = new OrganizationDao();
		Pager<Platform> pager = new  Pager<Platform>();
		Connection connection = DBUtil.getConnection();
		//创建语句传输对象
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Platform> platforms = new ArrayList<Platform>();
		Platform platform = null;
		//准备sql语句
		String sql="SELECT * FROM platform_info a join dean on a.Pdeanid = dean.id "  + 
				"JOIN organization ON a.Porganizationid=organization.id  " + 
				"JOIN `user` ON a.Puserid=`user`.id where ";
		
		String sqlCount="SELECT count(*) FROM platform_info a " + 
				" join dean on a.Pdeanid = dean.id " + 
				"  JOIN organization ON a.Porganizationid=organization.id " + 
				"  JOIN `user` ON a.Puserid=`user`.id where ";
		System.out.println("初始sql语句"+sql);
		int a=0;
		if(values!=null&&!"".equals(values[0]))
		{
			sql+=condition[0] +" "+ style[0] +" "+ values[0]+ " ";
			sqlCount+=condition[0] +" "+ style[0] +" "+ values[0]+ " ";
			a++;
			
			System.out.println(a+"value");
			System.out.println("初始2sql语句"+sql);
		}
		
		if(con!=null)
		{
			System.out.println("con长度"+con.length);
			int Nsty=style.length;
			if(Nsty>1)
			{
				for(int i=1;i<Nsty;i++)
				{
				System.out.println("----"+i+"+++++");
				System.out.println("con"+con[i-1]);
				System.out.println("condition"+condition[i]);
				System.out.println("values"+values[i]);
//				if(i<Nsty)
				sql+=con[i-1] + " "+condition[i] +" "+ style[i] + " "+ values[i]+ " ";
				sqlCount+=con[i-1] + " "+condition[i] +" "+ style[i] +" "+ values[i]+ " ";
				a++;
				}
			}
			System.out.println("链接"+sql);
			System.out.println(a+" and");
		}
		if(!"".equals(date1)&&!"".equals(date2))
		{
			if(a==0)
			{
				sql+=" approval_date BETWEEN '"+ date1 +"' and '"+date2+"' ";
				sqlCount+=" approval_date BETWEEN '"+ date1 +"' and '"+date2+"' ";
			}
			else
			{
			sql+=" and approval_date BETWEEN '"+ date1 +"' and '"+date2+"' ";
			sqlCount+=" and approval_date BETWEEN '"+ date1 +"' and '"+date2+"' ";
			}
			a++;
			System.out.println("datesql语句"+sql);
			
		}
		if(platform_grade!=0)
		{
			if(a==0)
			{
			sql+=" Pform = "+platform_grade;
			sqlCount+=" Pform = "+platform_grade;
			}
			else
			{
				sql+=" and Pform = "+platform_grade;
				sqlCount+=" and Pform = "+platform_grade;
			}
			System.out.println("gradesql语句"+sql);
		}
		System.out.println("最终sql语句"+sql);
		try {
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
		sql += " limit ?,?";
		System.out.println(sql);
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, pageOffset);
		preparedStatement.setInt(2, pageSize);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			platform = new Platform();

            User user = userDao.loadUser(resultSet.getInt("Puserid"));
            Dean dean = deanDao.loadDean(resultSet.getInt("Pdeanid"));
            Organization organization = organizationDao.loadOrganization(resultSet.getInt("Porganizationid"));

            platform.setId(resultSet.getInt("id"));
            platform.setUser(user);
            platform.setDean(dean);
            platform.setOrganization(organization);
            platform.setGrade(resultSet.getInt("Pgrade"));
            platform.setDistrict(resultSet.getString("Pdistrict"));
            platform.setForm(resultSet.getInt("Pform"));
            platform.setUnite(resultSet.getBoolean("Punite"));
            platform.setJjjgj(resultSet.getBoolean("Pjjjgj"));
            platform.setIndustry(resultSet.getString("Pindustry"));
            platform.setSubject(resultSet.getString("Psubject"));
            platform.setGjdw(resultSet.getString("Pgjdw").split(";"));
            platform.setSitename(resultSet.getString("Pwebsite"));
            platform.setWebsite(resultSet.getString("Pweburl"));
            platform.setAddr(resultSet.getString("Paddress"));
            platform.setPostcode(resultSet.getString("Ppostcode"));
            platform.setStatus(resultSet.getInt("Pstatus"));
            platforms.add(platform);
		}	
		//往分页对象里面设置数据
		pager.setDatas(platforms);
		pager.setPageSize(pageSize);
		pager.setTotalPage(totalPage);
		pager.setTotalRecord(totalRecord);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	finally {
		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);
		DBUtil.close(connection);
	}
		return pager;
	}*/

	public List<Platform> loadPlatform(String[] condition, String[] values, String[] style, String[] con, String date1, String date2,
			int platform_grade) {
		// TODO Auto-generated method stub
/*		if(values==null)
		{
			System.out.println("数组长度"+values.length);
			for(int i=0;i<values.length;i++)
			{
				values[i]="";
			}
		}*/
		UserDao userDao = new UserDao();
        DeanDao deanDao = new DeanDao();
        OrganizationDao organizationDao = new OrganizationDao();
		Pager<Platform> pager = new  Pager<Platform>();
		Connection connection = DBUtil.getConnection();
		//创建语句传输对象
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Platform> platforms = new ArrayList<Platform>();
		Platform platform = null;
		//准备sql语句
		String sql=" SELECT * from PLATFORM_INFO a " + 
				"inner join dean on a.Pdeanid = dean.ID " + 
				"join \"ORGANIZATION\" on a.PorganizationID=\"ORGANIZATION\".ID " + 
				"join USER1 on a.Puserid=USER1.ID WHERE ";
		
		String sqlCount=" SELECT COUNT(*) from PLATFORM_INFO a " + 
				"inner join dean on a.Pdeanid = dean.ID " + 
				"join \"ORGANIZATION\" on a.PorganizationID=\"ORGANIZATION\".ID " + 
				"join USER1 on a.Puserid=USER1.ID where ";
		System.out.println("初始sql语句"+sql);
		int a=0;
		if(values!=null&&!"".equals(values[0]))
		{
			sql+=condition[0] +" "+ style[0] +" "+ values[0]+ " ";
			sqlCount+=condition[0] +" "+ style[0] +" "+ values[0]+ " ";
			a++;
			
			System.out.println(a+"value");
			System.out.println("初始2sql语句"+sql);
		}
		
		if(con!=null)
		{
			System.out.println("con长度"+con.length);
			int Nsty=style.length;
			if(Nsty>1)
			{
				for(int i=1;i<Nsty;i++)
				{
				System.out.println("----"+i+"+++++");
				System.out.println("con"+con[i-1]);
				System.out.println("condition"+condition[i]);
				System.out.println("values"+values[i]);
//				if(i<Nsty)
				sql+=con[i-1] + " "+condition[i] +" "+ style[i] + " "+ values[i]+ " ";
				sqlCount+=con[i-1] + " "+condition[i] +" "+ style[i] +" "+ values[i]+ " ";
				a++;
				}
			}
			System.out.println("链接"+sql);
			System.out.println(a+" and");
		}
		if(!"".equals(date1)&&!"".equals(date2))
		{
			if(a==0)
			{
				sql+=" approval_date BETWEEN '"+ date1 +"' and '"+date2+"' ";
				sqlCount+=" approval_date BETWEEN '"+ date1 +"' and '"+date2+"' ";
			}
			else
			{
			sql+=" and approval_date BETWEEN '"+ date1 +"' and '"+date2+"' ";
			sqlCount+=" and approval_date BETWEEN '"+ date1 +"' and '"+date2+"' ";
			}
			a++;
			System.out.println("datesql语句"+sql);
			
		}
		if(platform_grade!=0)
		{
			if(a==0)
			{
			sql+=" Pform = "+platform_grade;
			sqlCount+=" Pform = "+platform_grade;
			}
			else
			{
				sql+=" and Pform = "+platform_grade;
				sqlCount+=" and Pform = "+platform_grade;
			}
			System.out.println("gradesql语句"+sql);
		}
		System.out.println("最终sql语句"+sql);
		try {
		preparedStatement = connection.prepareStatement(sqlCount);
		resultSet = preparedStatement.executeQuery();
		
		System.out.println(sql);
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			platform = new Platform();

            User user = userDao.loadUser(resultSet.getInt("Puserid"));
            Dean dean = deanDao.loadDean(resultSet.getInt("Pdeanid"));
            Organization organization = organizationDao.loadOrganization(resultSet.getInt("Porganizationid"));

            platform.setId(resultSet.getInt("id"));
            platform.setUser(user);
            platform.setDean(dean);
            platform.setOrganization(organization);
            platform.setGrade(resultSet.getInt("Pgrade"));
            platform.setDistrict(resultSet.getString("Pdistrict"));
            platform.setForm(resultSet.getInt("Pform"));
            platform.setUnite(resultSet.getBoolean("Punite"));
            platform.setJjjgj(resultSet.getBoolean("Pjjjgj"));
            platform.setIndustry(resultSet.getString("Pindustry"));
            platform.setSubject(resultSet.getString("Psubject"));
            platform.setGjdw(resultSet.getString("Pgjdw").split(";"));
            platform.setSitename(resultSet.getString("Pwebsite"));
            platform.setWebsite(resultSet.getString("Pweburl"));
            platform.setAddr(resultSet.getString("Paddress"));
            platform.setPostcode(resultSet.getString("Ppostcode"));
            platform.setStatus(resultSet.getInt("Pstatus"));
            platforms.add(platform);
		}	
		//往分页对象里面设置数据
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	finally {
		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);
		DBUtil.close(connection);
	}
		return platforms;
	}
}
