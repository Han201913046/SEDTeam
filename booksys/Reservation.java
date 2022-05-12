package booksys;

import java.sql.Time;
import java.sql.Date;

public class Reservation {
	private User user;
	private int tableNum;
	private int covers;
	private Date date;
	private Time time;
	private Time arrivalTime;
	
	public Reservation(User user, int tableNum, int covers, Date date, Time time) {
		super();
		this.user = user;
		this.tableNum = tableNum;
		this.covers = covers;
		this.date = date;
		this.time = time;
		this.arrivalTime = null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTable(int tableNum) {
		this.tableNum = tableNum;
	}

	public int getCovers() {
		return covers;
	}

	public void setCovers(int covers) {
		this.covers = covers;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
