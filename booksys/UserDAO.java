package booksys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utill.DatabaseUtill;

public class UserDAO {
	public User selectUser(String id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		User user = null;
		try {
			Connection conn = DatabaseUtill.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = null;
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String PW = rs.getString(2);
				String name = rs.getString(3);
				String phoneNumber = rs.getString(4);
				user = new User(id, PW, name, phoneNumber);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int insertUser(User user) {
		String sql = "INSERT INTO user VALUES (?, ?, ?, ?)";
		try {
			Connection conn = DatabaseUtill.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getPhoneNumber());
			return pstmt.executeUpdate(); // 정상: 삽입된 데이터의 개수 > 0
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int deleteUser(String id) {
		String sql = "DELETE FROM user WHERE id = ?";
		try {
			Connection conn = DatabaseUtill.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate(); // 정상: 삽입된 데이터의 개수 = 0
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void updateUser(User user) {
		deleteUser(user.getId());
		insertUser(user);
	}
}
