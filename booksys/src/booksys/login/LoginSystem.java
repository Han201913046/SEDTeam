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
	 //����ڷκ��� ���̵�� ��й�ȣ�� �Է¹޾� �α���
	public boolean login(String id, String pw) {
		if(!isExistAccount(id)) //�α��� ����1 : ���̵�� ��ġ�ϴ� ������ ����
			return false;
		if(!am.getAccount(id).getPw().equals(pw)) //�α��� ����2 : ���̵�� ��й�ȣ�� ��ġ���� ����
			return false;
		return true; //�α��� ����
	}
	
	public boolean sigUp(String id, String pw, String name, String phone) {
		if(isExistAccount(id)) //ȸ������ ���� : �ش� ���̵�� �� ������ ������
			return false;
		am.createAccount(id, pw, name, phone);
		return true;
	}
}
