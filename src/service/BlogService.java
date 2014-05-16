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
	
	UserDao ud = new UserDao();
	BlogDao bd = new BlogDao();
	CategoryDao cd = new CategoryDao();
	PostDao pd = new PostDao();
	ReplyDao rd = new ReplyDao();

	
	public void executeLoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("001.jsp").forward(request, response);
	}

	public void executeLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		
		
		UserVO user = ud.getUser(userId);
		
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
		System.out.println("[executePostDetail] blogId="+blogId+" postId="+request.getParameter("postId"));
		int postId = Integer.parseInt(request.getParameter("postId"));
		
		
		BlogVO blog = bd.getBlog(blogId);
		
		List<CategoryVO> categoryList = cd.getCategoryList(blogId);
		
		
		PostVO post = pd.getPost(postId);
		
		List<ReplyVO> replyList = rd.getReplyList(postId);
		
		request.setAttribute("blog", blog);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("post", post);
		request.setAttribute("replyList", replyList);
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("003.jsp").forward(request, response);
	}

	public void executeReplyAdd(HttpServletRequest request,	HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		String blogId = request.getParameter("blogId");
		
		System.out.println(blogId);
		if(user == null || !(user.getUserId().equals(blogId))) {
			throw new ServiceException("유효하지 않은 사용자입니다.");
		}
		
		ReplyVO reply = new ReplyVO();
		
		String nickname = request.getParameter("nickname");
		boolean publicReply = Boolean.getBoolean(request.getParameter("public_reply"));
		String content = request.getParameter("content");
		int postId = 1; // 원래는 003.jsp에 있는 hidden form에서 가져옴
		boolean res = false;
		
		reply.setNickname(nickname);
		reply.setPublicReply(publicReply);
		reply.setContent(content);
		reply.setPostId(postId);
		reply.setUserId(user.getUserId());
		
		res = rd.addReply(reply);
		
		if(!res) {
			throw new ServiceException("입력에 실패하였습니다.");
		}
		
		response.sendRedirect("detailpost.navi?blogId=test&postId=1");
		
	}
}
