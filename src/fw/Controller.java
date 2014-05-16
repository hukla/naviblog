package fw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlogService;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		BlogService bservice = new BlogService();
		
		try {	
			if(uri.contains("loginform.navi")) {
				bservice.executeLoginForm(request, response);
			} else if(uri.contains("login.navi")) {
				bservice.executeLogin(request, response);
			} else if(uri.contains("index.navi")) {
				bservice.executeIndex(request, response);
				System.out.println("[process()] user="+request.getSession().getAttribute("user"));
			} else if(uri.contains("detailpost.navi")){
				bservice.executePostDetail(request, response);
			} else {
				throw new Exception("해당 요청을 처리할 수 없습니다.");
			}
		} catch(Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
			try {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
