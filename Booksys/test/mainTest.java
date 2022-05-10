package test;

import booksys.*;
import utill.DatabaseUtill;

public class mainTest {
	public static void main(String[] args) {
		mainTest mainTest = new mainTest();
		mainTest.run();
	}

	public void run() {
		UserDAO userDao = new UserDAO();
		User solution = new User("testID4", "testPW", "Yura", "010-1234-5678");
		
		System.out.println("[¼öÁ¤ Àü]");
		printUser(solution);
		
		solution.setName("Mina");
		solution.setPhoneNumber("010-9876-5432");
		userDao.updateUser(solution);
	}
	public void printUser(User u) {
		System.out.println(
				"id: " + u.getId() + "\npw: " + u.getPw() + "\nname: " + u.getName() + "\nphoneNum:" + u.getPhoneNumber());
	}
}
