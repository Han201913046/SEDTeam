package test;

import java.sql.Date;
import java.sql.Time;

import booksys.*;

public class mainTest {
	public static void main(String[] args) {
		mainTest mainTest = new mainTest();
		mainTest.testReservDAO();
	}

	public void testReservDAO() {
		UserDAO userDao = new UserDAO();
		ReservationDAO reservDao = new ReservationDAO();
		
		//1. 예약자 인스턴스 준비
		User testUser = new User("JinJu123", "password123", "JinJuJeong", "010-7878-9696");
		userDao.insertUser(testUser);
		
		//2. 예약 생성
		Date date = Date.valueOf("yyyy-mm-dd");
		Time time = Time.valueOf("3:00:00");
		Reservation testRserv = new Reservation(testUser, 1, 2, date, time);
		reservDao.insertReservation(testRserv);
		
		//3. 예약 불러오기
		Reservation validation = reservDao.selectReservation(testUser, date, time);
		printReservation(validation);
	}

	public void printUser(User u) {
		System.out.printf("[ID: %s | PW: %s]\nName: %s\nPhoneNum: %s", u.getId(), u.getPw(), u.getName(),
				u.getPhoneNumber());
	}

	public void printReservation(Reservation r) {
		System.out.printf("[Name: %s]\nDate: %s\nTime: %s\nTable: %d\nCovers: %d", r.getUser().getName(), r.getDate(),
				r.getTime(), r.getTableNum(), r.getCovers());
	}
}
