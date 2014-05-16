package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import vo.BlogVO;

public class BlogDao {
	public BlogVO getBlog(String blogId) throws Exception {
		BlogVO blog = new BlogVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM blog WHERE blog_id=?");
			pstmt.setString(1, blogId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				blog.setBlogId(rs.getString("blog_id"));
				blog.setTitle(rs.getString("title"));
				blog.setCodeId(rs.getString("code_id"));
				blog.setTag(rs.getString("tag"));
				blog.setCntDisplayPost(rs.getInt("cnt_display_post"));
				blog.setStatus(rs.getString("blog_status"));
				blog.setImagePath(rs.getString("image_path"));
				blog.setPublicBlog((rs.getString("public_blog").equals("Y")? true:false));
				blog.setCreatedDate(rs.getString("create_date"));
			}
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		
		return blog;
	}
}
