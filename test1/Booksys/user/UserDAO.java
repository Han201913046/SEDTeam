package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/booksys";
			String dbID = "root";
			String dbPW = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private ResultSet rs = null;
//
//	public User selectUser(String id) {
//		String sql = "SELECT * FROM user WHERE id = ?";
//		User user = null;
//		try {
//			Connection conn = DatabaseUtill.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				String ID = rs.getString(1);
//				String PW = rs.getString(2);
//				String name = rs.getString(3);
//				String phoneNumber = rs.getString(4);
//				user = new User(ID, PW, name, phoneNumber);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return user;
//	}
//
	public int insertUser(User user) {
		String sql = "INSERT INTO user VALUES (?,?,?,?)";
		try {
//			Connection conn = DatabaseUtill.getConnection();

			pstmt = conn.prepareStatement(sql);
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
//
//	public int deleteUser(String id) {
//		String sql = "DELETE FROM user WHERE id = ?";
//		try {
//			Connection conn = DatabaseUtill.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			return pstmt.executeUpdate(); // 정상: 삽입된 데이터의 개수 = 0
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}
//
//	public void updateUser(User user) {
//		deleteUser(user.getId());
//		insertUser(user);
//	}

	public int login(String id, String pw) {

		String SQL = "SELECT pw FROM user WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
					return 1; // 로그인 성공
				} else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터베이스 오류
	}

//	public int join(User user) {
//		String SQL = "INSERT INTO USER VALUES (?,?,?,?)";
//
//		try {
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setString(1, user.getId());
//			pstmt.setString(2, user.getPw());
//			pstmt.setString(3, user.getName());
//			pstmt.setString(4, user.getPhoneNumber());
//			return pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1; // 데이터베이스 오류
//	}

}
