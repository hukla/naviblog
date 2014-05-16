package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.CategoryVO;

public class CategoryDao {

	public List<CategoryVO> getCategoryList(String blogId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM category WHERE blog_id=?");
			pstmt.setString(1, blogId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CategoryVO cvo = new CategoryVO();
				cvo.setBlogId(rs.getString("blog_id"));
				cvo.setCategoryId(rs.getInt("category_id"));
				cvo.setCategoryName(rs.getString("category_name"));
				cvo.setContent(rs.getString("content"));
				cvo.setCreatedDate(rs.getString("created_date"));
				list.add(cvo);
			}
			
		} finally {
			DBUtil.close(con, pstmt, rs);
		}

		return list;
	}
}
