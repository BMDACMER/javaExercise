package com.csdn.base01;

public class Customer {

	private int cid;
	private String name;
	private Room room;
	private int day;

	public Customer() {
		super();
	}

	public Customer(int cid, String name, Room room, int day) {
		super();
		this.cid = cid;
		this.name = name;
		this.room = room;
		this.day = day;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
