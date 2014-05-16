package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.BlogVO;
import vo.CategoryVO;
import vo.PostVO;
import vo.ReplyVO;
import vo.UserVO;
import dao.BlogDao;
import dao.CategoryDao;
import dao.PostDao;
import dao.ReplyDao;
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
	
	public void executePostDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String blogId = request.getParameter("blogId");
		int postId = Integer.parseInt(request.getParameter("postId"));
		
		BlogDao bd = new BlogDao();
		BlogVO blog = bd.getBlog(blogId);
		
		CategoryDao cd = new CategoryDao();
		List<CategoryVO> categoryList = cd.getCategoryList(blogId);
		
		PostDao pd = new PostDao();
		PostVO post = pd.getPost(postId);
		
		ReplyDao rd = new ReplyDao();
		List<ReplyVO> replyList = rd.getReplyList(postId);
		
		request.setAttribute("blog", blog);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("post", post);
		request.setAttribute("replyList", replyList);
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("003.jsp").forward(request, response);
	}
}
