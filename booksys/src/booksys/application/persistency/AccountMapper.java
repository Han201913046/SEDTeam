package booksys.application.persistency;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import booksys.login.Account;
import booksys.storage.Database;

public class AccountMapper {
	private Hashtable cache;

	// Constructor:
	private AccountMapper() {
		cache = new Hashtable();
	}

	// Singleton:
	private static AccountMapper uniqueInstance;

	public static AccountMapper getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new AccountMapper();
		}
		return uniqueInstance;
	}

	private void addToCache(Account a) {
		String key = new String(a.getId());
		cache.put(key, a);
	}

	private Account getFromCacheById(String id) // 캐시에서 유저 아이디로 계정 탐색
	{
		String key = new String(id);
		return (Account) cache.get(key);
	}

	/*
	 * private Account getFromCacheByOid(int oid) { Account a = null; Enumeration
	 * enumeration = cache.elements(); while (a == null &&
	 * enumeration.hasMoreElements()) { Account tmp = (Account)
	 * enumeration.nextElement(); if (tmp.findCustomer(oid) == null) return null; a
	 * = tmp; } return a; }
	 */

	public Account getAccount(String id) { // 유저 아이디로 계정을 탐색하는 메소드
		Account a = getFromCacheById(id); // 캐시에서 유저 아이디로 인스턴스를 검색
		if (a == null) { // 캐시에 없다면 DB에서 검색
			a = getAccountFromDB("SELECT * FROM Account WHERE id = '" + id + "'");
			if (a == null) { // DB에 없는 경우 null을 반환-> 회원가입 해야 함
				return null;
			}
			addToCache(a);
		}
		return a;
	}

	private Account getAccountFromDB(String sql) { // 데이터베이스에서 계정을 탐색하는 메소드
		Account a = null;
		try {
			Statement stmt = Database.getInstance().getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(sql); // 계정 스키마의 key값인 'id'가 일치한다면
			while (rset.next()) {
				String id = rset.getString(1);
				String pw = rset.getString(2);
				String name = rset.getString(3);
				String phone = rset.getString(4);
				a = new Account(id, pw, name, phone);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public Account createAccount(String id, String pw, String name, String phone)
	  {
	    Account a = getFromCacheById(id) ;
	    if (a == null) { //기존에 계정이 없다면 새 인스턴스를 생성
	      try {
		Statement stmt
		  = Database.getInstance().getConnection().createStatement() ;
		int updateCount
		  = stmt.executeUpdate("INSERT INTO Account (id, pw, name, phoneNumber)" +
				       "VALUES ('" + id + "', '" + pw + "', '" + name + "', '" + phone + "')") ;
		stmt.close() ;
	      }
	      catch (SQLException e) {
		e.printStackTrace() ;
	      }
	      a = getAccount(id) ;
	    }
	    return a ;
	  }
}
