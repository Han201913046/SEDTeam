package booksys.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginSystemTest {

	@Test
	void loginTest() {
		LoginSystem log = new LoginSystem();
		
		//1. ������ ���� ��� false
		assertFalse(log.login("testId_12", "testPW"));
		
		//2. ȸ������
		assertTrue(log.sigUp("testId_12", "testPW", "User1", "010-1234-5678"));
		
		//3. �ٽ� �α����� ��� true
		assertTrue(log.login("testId_12", "testPW"));
	}

}
