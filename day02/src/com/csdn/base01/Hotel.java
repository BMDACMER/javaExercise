package com.csdn.base01;

import java.util.Scanner;

public class Hotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String menu = "请选择：\n1: 入住 \n2: 退房\n3: 查房\n4: 退出系统\n您的选择：";
		HotelManager hm = new HotelManager();
		hm.initRoom();
		System.out.println(menu);
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			if (scan.hasNext()) {
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("请输入入住房间号");
					Scanner scan1 = new Scanner(System.in);
					if(scan1.hasNext()) {
						String no = scan1.next();
						hm.checkIn(no);
						System.out.println("入住成功");
					}
					break;
				case 2:
					System.out.println("请输入退房房间号");
					Scanner scan2 = new Scanner(System.in);
					if(scan2.hasNext()) {
						String no = scan2.next();
						hm.checkOut(no);
						System.out.println("退房成功");
					}
					break;
				case 3:
					hm.show();
					break;
				case 4:
					System.out.println("bye bye！");
					System.exit(0);
					break;
				default:
					break;	
				}
			}
		}
	}

}
