package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 21:43
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //����һ��
        System.out.println("��������ģ�⻷�ζ��еİ���~~~");

        // ����һ�����ζ���
        CircleArray queue = new CircleArray(4); //˵������4, ����е���Ч���������3
        char key = ' '; // �����û�����
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // ���һ���˵�
        while (loop) {
            System.out.println("s(show):��ʾ����");
            System.out.println("e(exit): �˳�����");
            System.out.println("a(add): ������ݵ�����");
            System.out.println("g(get): �Ӷ���ȡ������");
            System.out.println("h(head): �鿴����ͷ������");
            key = scanner.next().charAt(0);// ����һ���ַ�
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("���һ����");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // ȡ������
                    try {
                        int res = queue.getQueue();
                        System.out.printf("ȡ����������%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // �鿴����ͷ������
                    try {
                        int res = queue.headQueue();
                        System.out.printf("����ͷ��������%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // �˳�
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("�����˳�~~");
    }
}

class CircleArray {
    private int maxSize;  // ��ʾ������������
    private int front; // ָ����еĵ�һ��Ԫ��
    private int rear;  // ָ����е�����һ��Ԫ�صĺ�һ��λ��
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("�����������ܼ�������~");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        System.out.println("front��" + front);
        if (isEmpty()) {
            throw new RuntimeException("���пգ�����ȡ����");
        }
        int value =  arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        System.out.println("rear:" + rear);
        if (isEmpty()) {
            System.out.println("���пյģ�û������");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw  new RuntimeException("����Ϊ�գ�û������~~~");
        }
        return arr[front];
    }
}
