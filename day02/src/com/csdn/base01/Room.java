package com.csdn.base01;

public class Room {
	private String no;
	private int isBooked; // 0 δ��ס 1 ��ס

	public Room() {
		super();
	}

	public Room(String no, int isBooked) {
		super();
		this.no = no;
		this.isBooked = isBooked;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(int isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		return this.no + "," + (this.isBooked == 1? "����":"�շ�");
	}
	

}
