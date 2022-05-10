package test;
import booksys.*;
import utill.DatabaseUtill;

public class mainTest {
	public static void main(String[] args) {
		UserDAO userDao = new UserDAO();
		userDao.join("testID", "testPW", "Jhonn", "010-123-5678");
	}
}
