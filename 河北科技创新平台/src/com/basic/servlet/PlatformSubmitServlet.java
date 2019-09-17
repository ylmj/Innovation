package com.basic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.dao.PlatformDao;
import com.basic.model.Dean;
import com.basic.model.Organization;
import com.basic.model.Platform;
import com.basic.model.User;

/**
 * Servlet implementation class PlatformSubmitServlet
 * @WebServlet("/PlatformSubmitServlet")
 */

public class PlatformSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String html_head = "<html>\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "    <link rel=\"stylesheet\" href=\"layui/css/layui.css\">\n" +
            "    <script type=\"javascript\" src=\"layui/layui.js\" ></script>\n" +
            "    <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n";
    String html_tail = "</body>\n" +
            "</html>";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlatformSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��session�л�ȡ��û�
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		/*ƽ̨������Ϣ*/
		String[] platform_grade=request.getParameterValues("platform_grade");//ƽ̨����
		String platform_province=request.getParameter("province");//ʡ
		String platform_city=request.getParameter("city");//��
		String platform_district=request.getParameter("district");//��
		String platform_form=request.getParameter("platform_form");//ƽ̨��֯��̬
		String platform_subject=request.getParameter("subject3");//������Ҫѧ��
		String platform_faren_type=request.getParameter("faren_type");//����
		String platform_unite=request.getParameter("unite");//���Ϲ���������
		String platform_jjjgj=request.getParameter("jjjgj");//���򼽹���
		String[] platform_gjdw=request.getParameterValues("gjdw");//������λ
		
		System.out.println("ƽ̨������Ϣ");
		int gradeValue=0;//ƽ̨������Զ�ѡ
		if(platform_grade!=null)
		{
			for(String grade:platform_grade)
				gradeValue=gradeValue|Integer.valueOf(grade);
			System.out.println("ƽ̨����"+gradeValue);
		}
		
		//ƽ̨��֯��̬ ���� platform_form���������Զ���(�޷����ʸ�)1 ��������0  platform_faren_type���ŷ���2 34
		int formValue=0;
		try
		{
			formValue+=Integer.valueOf(platform_form);
			formValue+=Integer.valueOf(platform_faren_type);
		}catch(NumberFormatException e)
		{
			System.out.println("��ֵ��������");
		}
		
		 System.out.println(platform_province);
	     System.out.println(platform_city);
	     System.out.println(platform_district);
	     System.out.println(platform_form);
	     System.out.println(platform_faren_type);
	     System.out.println(platform_unite);
	     System.out.println(platform_jjjgj);
	     //������λ
	     if (platform_gjdw != null)
	     {
	       for (String g:platform_gjdw){
	          if (!"".equals(g))
	                    System.out.println(g);
	            }
	        }
	        System.out.println("");
	        
	        //���񾭼���ҵ
	        
	        
	        //���е�λ��Ϣ
	        
	        String dep_organization_name=request.getParameter("dep_organization_name");//���е�λ����
	        String dep_organization_number=request.getParameter("dep_organization_number");//���е�λ��֯��������
	        String dep_organization_faren=request.getParameter("dep_organization_faren");//���е�λ���˴���
	        String dep_organization_phone = request.getParameter("dep_organization_phone");     //�칫�绰
	        String dep_organization_type = request.getParameter("dep_organization_type");       //���е�λ����


	        System.out.println("���е�λ��Ϣ��");
	        System.out.println(dep_organization_name);
	        System.out.println(dep_organization_number);
	        System.out.println(dep_organization_faren);
	        System.out.println(dep_organization_phone);
	        System.out.println(dep_organization_type);
	        System.out.println("");

	        //ƽ̨����
	        String dean_name = request.getParameter("dean_name");                               //ƽ̨��������
	        String dean_sex = request.getParameter("sex");                                      //�Ա�
	        String dean_birthday = request.getParameter("birthday");                            //��������
	        String dean_job_title = request.getParameter("job_title");                          //ְ��
	        String dean_major = request.getParameter("major");                                  //��ѧרҵ
	        String dean_education = request.getParameter("education");                          //ѧ��
	        String dean_degree = request.getParameter("degree");                                //ѧλ
	        String dean_telephone = request.getParameter("dean_telephone");                     //�칫�绰
	        String dean_mobilephone = request.getParameter("dean_mobilephone");                 //�ֻ�
	        String dean_email = request.getParameter("dean_email");                             //Email

	        System.out.println("ƽ̨������Ϣ��");
	        System.out.println(dean_name);
	        System.out.println(dean_sex);
	        System.out.println(dean_birthday);
	        System.out.println(dean_job_title);
	        System.out.println(dean_major);
	        System.out.println(dean_education);
	        System.out.println(dean_degree);
	        System.out.println(dean_telephone);
	        System.out.println(dean_mobilephone);
	        System.out.println(dean_email);
	        System.out.println("");


	        /***ƽ̨��ϵ��Ϣ***/
	        String platform_site_name = request.getParameter("platform_site_name");             //ƽ̨��վ����
	        String platform_website = request.getParameter("platform_website");                 //ƽ̨��վ��ַ
	        String platform_addr = request.getParameter("platform_addr");                       //ƽ̨ͨѶ��ַ
	        String platform_postcode = request.getParameter("platform_postcode");               //�ʱ�

	        System.out.println("ƽ̨��ϵ��Ϣ");
	        System.out.println(platform_site_name);
	        System.out.println(platform_website);
	        System.out.println(platform_addr);
	        System.out.println(platform_postcode);
	        
	        
	        
	        //�ύ��Ϣ
	        String status=request.getParameter("status");//1����2�ύ
	        System.out.println("ƽ̨��Ϣ״̬��"+status);
	        int statusValue=0;
	        try {
	        	statusValue=Integer.parseInt(status);
	        }catch(NumberFormatException e)
	        {
	        	System.out.println("��ֵ��������");		
	        }
	        
	        		
	        		
	        //�������ݿ�
	        PlatformDao platformDao=new PlatformDao();
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");//���ڸ�ʽ����
	        Platform platform=platformDao.loadPlatformByUserid(user.getId());//ƽ̨
	        //organizationƽ̨��λ
	        Organization organization=new Organization(dep_organization_name,dep_organization_number,dep_organization_faren,dep_organization_phone,dep_organization_type);//organization
	        Dean dean=null;//ƽ̨Ժ��
	        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
	        String birthday=null;
	        birthday=sdf.format(new Date());
	        
	        dean=new Dean(dean_name,dean_sex,birthday,dean_job_title,dean_major,dean_education,dean_degree,dean_telephone,dean_mobilephone,dean_email);
	        
	        //�û�δ����ƽ̨
	        if(platform==null)
	        {
	        	platform=new Platform(user,organization,dean,gradeValue,platform_district,formValue,"united".equals(platform_unite),"yes".equals(platform_jjjgj),"��Ҫ���񾭼���ҵ",platform_subject,platform_gjdw,platform_site_name,platform_website,platform_addr,platform_postcode,statusValue);
	        	platformDao.addPlatform(platform);
	        	if(statusValue==1)
	        	{
	        		System.out.println("����ɹ���");
	        		//JSON���ݣ���������ɹ��Ի���
	        		 response.setContentType("text/json");
	                 PrintWriter writer = response.getWriter();
	                 writer.write("{\"status\":\"OK\",\"msg\":\"����ɹ���\",\"error\":\"\"}");
	        	}else if(statusValue==2)
	        	{
	        		System.out.println("�ύ�ɹ�");
	        		//��ת���ύ�ɹ�ҳ��
	        		request.setAttribute("msg", "{title:'��ʾ��Ϣ',content:'�ύ�ɹ�',btnAlign:'c',yes:function(index,layero){location.href='Review.jsp'}}");
	        		request.getRequestDispatcher("msg.jsp").forward(request, response);
	        	}
	        }
	        else
	        	//�û������ƽ̨
	        {
	        	int id = platform.getId();
	            int deanid = platform.getDean().getId();
	            int organizationid = platform.getOrganization().getId();

	            dean.setId(deanid);
	            organization.setId(organizationid);

	            platform = new Platform(user,organization,dean,gradeValue,platform_district,formValue,"united".equals(platform_unite),"yes".equals(platform_jjjgj),"��Ҫ���񾭼���ҵ",platform_subject,platform_gjdw,platform_site_name,platform_website,platform_addr,platform_postcode,statusValue);
	            platform.setId(id);
	            platformDao.updatePlatform(platform);

	            if (statusValue == 1){          //�������Ϊ���棬����ƽ̨����

	                //����JSON���ݣ���������ɹ��Ի���
	                /*response.setContentType("text/json");
	                PrintWriter writer = response.getWriter();
	                writer.write("{\"status\":\"OK\",\"msg\":\"����ɹ���\",\"error\":\"\"}");
	                System.out.println("�Ѵ���ƽ̨��Ϣ");*/
	            	 request.setAttribute("msg","{title:'��ʾ��Ϣ',content:'����ɹ���',btnAlign:'c',yes:function(index,layero){location.href='fill_in.jsp'}}");
		             request.getRequestDispatcher("msg.jsp").forward(request,response);

	            }else if(statusValue == 2 && platform.getStatus() != 2){        //�������Ϊ�ύ

	                //��ת���ύ�ɹ�ҳ��
	                request.setAttribute("msg","{title:'��ʾ��Ϣ',content:'�ύ�ɹ�',btnAlign:'c',yes:function(index,layero){location.href='fill_in.jsp'}}");
	                request.getRequestDispatcher("msg.jsp").forward(request,response);

	            }else if (platform.getStatus() == 2){                       //�����ظ��ύ

	                //��ת���ύ�ɹ�ҳ��
	                request.setAttribute("msg","{title:'��ʾ��Ϣ',content:'�����ύ���������ĵȴ���',btnAlign:'c',yes:function(index,layero){location.href='fill_in.jsp'}}");
	                request.getRequestDispatcher("msg.jsp").forward(request,response);

	            }
	        	
	        }
	}

}
