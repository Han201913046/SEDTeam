package booksys.login;

import java.util.ArrayList;
import booksys.application.persistency.*;

public class Account {
	private String id;
	private String pw;
	private String name;
	private String phonenumber;
	private ArrayList<PersistentCustomer> myCustomer = new ArrayList<PersistentCustomer>(); // 현재 계정에서 예약했던 이력을 담은 리스트

	public Account(String id, String pw, String name, String phonenumber) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phonenumber = phonenumber;
	}

	public Account() {
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getPhonenum() {
		return phonenumber;
	}

	public void createCustomer() {
	}

	public void createCustomer(String name, String phonenumber) {
	}

	public PersistentCustomer findMyCustomer(int oid) {
		for (PersistentCustomer c : myCustomer)
			if (c.getId() == oid)
				return c;
		return null;
	}
}
