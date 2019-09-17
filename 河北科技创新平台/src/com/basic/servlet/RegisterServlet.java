package com.basic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.dao.UserDao;
import com.basic.model.User;

/**
 * Servlet implementation class RegisterServlet
 * @WebServlet("/RegisterServlet")
 */

public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		//�û�ע����Ϣ
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password2").trim();
        String platformName = request.getParameter("platform_name").trim();
        String platformNo = request.getParameter("platform_num").trim();
        String approvalDate = request.getParameter("approval_date").trim();
        String approvalNum = request.getParameter("approval_number").trim();
        String field = request.getParameter("field").trim();
        //�����û����Ƿ��Ѵ���
        response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer=response.getWriter();
        try {
            UserDao userDao = new UserDao();
            List<User> users = userDao.loadUser(username);
            if (users.size() != 0){
                request.setAttribute("err_msg","�û����Ѵ��ڣ�");
                System.out.println("�û����Ѵ��� ����תerror.jsp");
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
            else
            {
            	 try {
                     System.out.println("����û�");
                     /*SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                     String date=formatter.format(new Date());*/
                     User user = new User(username,password,platformName,platformNo,approvalDate,approvalNum,field);
                     /*System.out.println("��λ�������");*/
                     userDao.addUser(user);
                     System.out.println("����û����");
                     request.setAttribute("msg","{title:'��ʾ��Ϣ',content:'ע��ɹ�',btnAlign:'c'}");
                     writer.println(html_head + "<script>alert('ע��ɹ�');history.go(-1);</script>" + html_tail);
                     /*request.getRequestDispatcher("login.html").forward(request, response);*/
                     response.sendRedirect("login.html");
                 }catch (Exception e){
                     request.setAttribute("exception",e);
                     request.setAttribute("err_msg","��������ϵ����Ա��15733931621��������ϢΪ��");
                     System.out.println(e);
                     request.getRequestDispatcher("error.jsp").forward(request,response);
                 }
                 //��Ӧ�û�
                 
         	}
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
   }
}
