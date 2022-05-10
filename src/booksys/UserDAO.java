package booksys;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utill.DatabaseUtill;

public class UserDAO {
	public int join(String id, String pw, String name, String phoneNumber) {
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?)";
		try {
			Connection conn = DatabaseUtill.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phoneNumber);
			return pstmt.executeUpdate(); // 삽입된 데이터의 개수를 반환 -> 0일 경우 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
