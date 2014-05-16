package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.UserVO;
import dao.UserDao;

public class BlogService {
	public void executeLoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("001.jsp").forward(request, response);
	}

	public void executeLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		
		UserDao udao = new UserDao();
		UserVO user = udao.getUser(userId);
		
		if(user == null || !password.equals(user.getPassword())) {
			System.out.println("[executeLogin()] user="+user+" password="+password);
			response.sendRedirect("loginform.navi");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		response.sendRedirect("index.navi");
	}
	
	public void executeIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("002.jsp").forward(request, response);
	}
	
	
}
