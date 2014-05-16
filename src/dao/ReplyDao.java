package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.ReplyVO;

public class ReplyDao {

	public List<ReplyVO> getReplyList(int postId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM reply WHERE post_id=?");
			pstmt.setInt(1, postId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyVO rvo = new ReplyVO();
				rvo.setContent(rs.getString("content"));
				rvo.setCreatedDate(rs.getString("created_date"));
				rvo.setNickname(rs.getString("nickname"));
				rvo.setPostId(rs.getInt("post_id"));
				rvo.setPublicReply((rs.getString("public_reply").equals("Y")?true:false));
				rvo.setRefId(rs.getInt("ref_id"));
				rvo.setReplyId(rs.getInt("reply_id"));
				rvo.setUserId(rs.getString("user_id"));
				list.add(rvo);
			}
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		
		return list;
	}

	public boolean addReply(ReplyVO reply) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean res = false;
		
		try {
			con = DBUtil.getConnection();
			
			System.out.println("reply.getNickname"+reply.getNickname());
			
			pstmt = con.prepareStatement("INSERT INTO reply(user_id, nickname, post_id, content, created_date) VALUES (?, ?, ?, ?, SYS_DATE)");
			pstmt.setString(1, reply.getUserId());
			pstmt.setString(2, reply.getNickname());
			pstmt.setInt(3, reply.getPostId());
			pstmt.setString(4, reply.getContent());
			
			res = pstmt.executeUpdate() > 0 ? true : false;
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return res;
	}
}
