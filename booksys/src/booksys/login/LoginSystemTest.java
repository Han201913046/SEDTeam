package booksys.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginSystemTest {

	@Test
	void loginTest() {
		LoginSystem log = new LoginSystem();
		
		//1. 계정이 없을 경우 false
		assertFalse(log.login("testId_12", "testPW"));
		
		//2. 회원가입
		assertTrue(log.sigUp("testId_12", "testPW", "User1", "010-1234-5678"));
		
		//3. 다시 로그인할 경우 true
		assertTrue(log.login("testId_12", "testPW"));
	}

}
