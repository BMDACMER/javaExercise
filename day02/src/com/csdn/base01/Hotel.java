package com.csdn.base01;

import java.util.Scanner;

public class Hotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String menu = "��ѡ��\n1: ��ס \n2: �˷�\n3: �鷿\n4: �˳�ϵͳ\n����ѡ��";
		HotelManager hm = new HotelManager();
		hm.initRoom();
		System.out.println(menu);
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			if (scan.hasNext()) {
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("��������ס�����");
					Scanner scan1 = new Scanner(System.in);
					if(scan1.hasNext()) {
						String no = scan1.next();
						hm.checkIn(no);
						System.out.println("��ס�ɹ�");
					}
					break;
				case 2:
					System.out.println("�������˷������");
					Scanner scan2 = new Scanner(System.in);
					if(scan2.hasNext()) {
						String no = scan2.next();
						hm.checkOut(no);
						System.out.println("�˷��ɹ�");
					}
					break;
				case 3:
					hm.show();
					break;
				case 4:
					System.out.println("bye bye��");
					System.exit(0);
					break;
				default:
					break;	
				}
			}
		}
	}

}
