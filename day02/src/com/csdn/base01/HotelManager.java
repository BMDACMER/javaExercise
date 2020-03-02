package com.csdn.base01;

import java.util.ArrayList;

public class HotelManager {

	ArrayList<Room> roomList = new ArrayList<Room>();
	// 初始化房间
	public void initRoom() {
		Room r1 = new Room("101", 0);
		Room r2 = new Room("102", 0);
		Room r3 = new Room("103", 0);
		Room r4 = new Room("104", 0);
		Room r5 = new Room("105", 0);
		
		Room r6 = new Room("201", 0);
		Room r7 = new Room("202", 0);
		Room r8 = new Room("203", 0);
		Room r9 = new Room("204", 0);
		Room r10 = new Room("205", 0);
		
		roomList.add(r1);
		roomList.add(r2);
		roomList.add(r3);
		roomList.add(r4);
		roomList.add(r5);
		
		roomList.add(r6);
		roomList.add(r7);
		roomList.add(r8);
		roomList.add(r9);
		roomList.add(r10);
	}
	
	public ArrayList<Room> getRoomList(){
		return this.roomList;
	}
	
	// 入住
	public void checkIn(String roomNo) {
		for (Room room : roomList) {
			if (room.getNo().equals(roomNo)) {
				room.setIsBooked(1);
				break;
			}
		}
	}
	
	// 退房
	public void checkOut(String roomNo) {
		for (Room room : roomList) {
			if(room.getNo().equals(roomNo)) {
				room.setIsBooked(0);
			}
		}
	}
	
	// 查房（展示剩余房间）
	public void show() {
		for (Room room : roomList) {
			System.out.println(room);
		}
	}
	
}
