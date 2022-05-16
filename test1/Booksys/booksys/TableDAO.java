package table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TableDAO {
//	private Connection conn;
//	public Table selectTable(int number) {return null;}
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public static Connection getConnection() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/booksys1";
			String dbID = "root";
			String dbPW = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbURL, dbID, dbPW);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
