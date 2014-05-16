package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;
import vo.UserVO;

public class UserDao {
	public UserVO getUser(String userId) throws Exception {
		UserVO user = new UserVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT user_id, b_password FROM b_user WHERE user_id=?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs == null) {
				throw new DAOException("결과가 없습니다.");
			}
			
			while(rs.next()){
				String user_id = rs.getString("user_id");
				System.out.println("[getUser()] userId="+user_id);
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("b_password"));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		 
		
		return user;
	}
}
