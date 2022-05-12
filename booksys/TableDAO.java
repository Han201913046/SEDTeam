package booksys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utill.DatabaseUtill;

public class TableDAO {
	public Table selectTable(int number) {
		String sql = "SELECT * FROM table WHERE number = ?";
		Table table = null;
		try {
			Connection conn = DatabaseUtill.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = null;
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int seats = rs.getInt(2);
				table = new Table(number, seats);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}
}
