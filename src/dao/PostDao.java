package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import vo.PostVO;

public class PostDao {
	public PostVO getPost(int postId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PostVO post = new PostVO();
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM post WHERE post_id=?");
			pstmt.setInt(1, postId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				post.setBlogId(rs.getString("blog_id"));
				post.setContent(rs.getString("content"));
				post.setCreatedDate(rs.getString("created_date"));
				post.setPermitReply((rs.getString("permit_reply").equals("Y")?true:false));
				post.setPostId(rs.getInt("post_id"));
				post.setPublicPost((rs.getString("public_post").equals("Y")?true:false));
				post.setTitle(rs.getString("title"));
				post.setUserId(rs.getString("user_id"));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		
		
		return post;
	}
}
