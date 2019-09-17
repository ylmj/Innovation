package com.basic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.dao.PlatformDao;
import com.basic.dao.UserDao;
import com.basic.model.Platform;
import com.basic.model.User;

/**
 * Servlet implementation class LoginServlet
 */
/*@WebServlet("/LoginServlet")*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//HTML框架
	private String html_head = "<html>\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "    <link rel=\"stylesheet\" href=\"layui/css/layui.css\">\n" +
            "    <script type=\"javascript\" src=\"layui/layui.js\" ></script>\n" +
            "    <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n";
	private String html_tail="</body>\n"+"</html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDao userDao=new UserDao();
		User user=userDao.loadUser(username, password);
		PlatformDao platformDao=new PlatformDao();
		if(user==null)
		{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer=response.getWriter();
			writer.println(html_head + "<script>alert('用户名或密码错误');history.go(-1);</script>" + html_tail);
		}
		else if(user.getId()==1)
		{
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", user);
			response.sendRedirect("Admin.jsp");
		}
		else
		{
			Platform platform=platformDao.loadPlatformByUserid(user.getId());
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("platform",platform);
			request.getRequestDispatcher("fill_in.jsp").forward(request, response);
		}
	}

}
