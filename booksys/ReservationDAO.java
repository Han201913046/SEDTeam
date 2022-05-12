package booksys;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import utill.DatabaseUtill;

public class ReservationDAO {
	// Date date = Date.valueOf("yyyy-mm-dd"); -> Date 인스턴스는 이 형식으로 생성해야 함
	
	public Reservation selectReservation(User user, Date date, Time time) {
		String sql = "SELECT * FROM reservation WHERE user_id = ? AND DATE(date) = ? AND TIME(time) = ?";
		Reservation reserv = null;
		try {
			Connection conn = DatabaseUtill.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = null;
			pstmt.setString(1, user.getId());
			pstmt.setDate(2, date);
			pstmt.setTime(3, time);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int tableNum = rs.getInt(2);
				int covers = rs.getInt(3);
				reserv = new Reservation(user, tableNum, covers, date, time);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reserv;
	}

	public int insertReservation(Reservation reserv) {
		String sql = "INSERT INTO reservation VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = DatabaseUtill.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reserv.getUser().getId());
			pstmt.setInt(2, reserv.getTableNum());
			pstmt.setInt(3, reserv.getCovers());
			pstmt.setDate(4, reserv.getDate());
			pstmt.setTime(5, reserv.getTime());
			pstmt.setTime(6, reserv.getArrivalTime());
			return pstmt.executeUpdate(); // 정상: 삽입된 데이터의 개수 > 0
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int deleteReservation(User user, Date date, Time time) {
		String sql = "DELETE FROM reservation WHERE user_id = ? AND DATE(date) = ? AND TIME(time) = ?";
		try {
			Connection conn = DatabaseUtill.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setDate(2, date);
			pstmt.setTime(3, time);
			return pstmt.executeUpdate(); // 정상: 삽입된 데이터의 개수 = 0
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void updateReservation(Reservation reserv) {
		deleteReservation(reserv.getUser(), reserv.getDate(), reserv.getTime());
		insertReservation(reserv);
	}
}
