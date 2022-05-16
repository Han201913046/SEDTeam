package user;

public class User {
	private String id;
	private String pw;
	private String name;
	private String phoneNumber;

//	public User(String id, String pw, String name, String phoneNumber) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
