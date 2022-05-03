package booksys.login;

import booksys.application.persistency.*;

public class LoginSystem {
	AccountMapper am = AccountMapper.getInstance();
	
	public boolean isExistAccount(String id) {
		Account tmp = am.getAccount(id);
		if(tmp == null)
			return false;
		return true;
	}
	 //사용자로부터 아이디와 비밀번호를 입력받아 로그인
	public boolean login(String id, String pw) {
		if(!isExistAccount(id)) //로그인 실패1 : 아이디와 일치하는 계정이 없음
			return false;
		if(!am.getAccount(id).getPw().equals(pw)) //로그인 실패2 : 아이디와 비밀번호가 일치하지 않음
			return false;
		return true; //로그인 성공
	}
	
	public boolean sigUp(String id, String pw, String name, String phone) {
		if(isExistAccount(id)) //회원가입 실패 : 해당 아이디로 된 계정이 존재함
			return false;
		am.createAccount(id, pw, name, phone);
		return true;
	}
}
