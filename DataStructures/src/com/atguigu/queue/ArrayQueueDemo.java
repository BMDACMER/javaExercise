package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/4 17:42
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        // ����һ��
        // ����һ������
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';   // �����û�����
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //���һ���˵�
        while(loop) {
            System.out.println("s(show): ��ʾ����");
            System.out.println("e(exit): �˳�����");
            System.out.println("a(add): ������ݵ�����");
            System.out.println("g(get): �Ӷ���ȡ������");
            System.out.println("h(head): �鿴����ͷ������");
            key = scanner.next().charAt(0);//����һ���ַ�
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("���һ����");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //ȡ������
                    try {
                        int res = queue.getQueue();
                        System.out.printf("ȡ����������%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //�鿴����ͷ������
                    try {
                        int res = queue.headQueue();
                        System.out.printf("����ͷ��������%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //�˳�
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

// ʹ������ģ�����-��дһ��ArrayQueue��
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    // �������еĹ�����
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;  // ָ�����ͷ����������front��ָ�����ͷ��ǰһ��λ��.
        rear = -1;   // ָ�����β��ָ�����β������(�����Ƕ������һ������)
    }

    // �ж϶����Ƿ���
    public boolean isFull() {
        return rear + 1 == maxSize;
    }

    // �ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return rear == front;
    }

    // ������ݵ�����
    public void addQueue(int n) {
        // �ж϶����Ƿ���
        if (isFull()) {
            System.out.println("�����������ܼ�������~");
            return;
        }
        arr[++rear] = n;
    }

    // ��ȡ���е����ݣ�������
    public int getQueue() {
        // �ж��Ƿ�Ϊ��
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ�գ�������ȡ������~~~");
        }
        front++;   // front����
        return arr[front];
    }

    // ��ʾ���е���������
    public void showQueue() {
        // ����
        if (isEmpty()) {
            System.out.println("����Ϊ�գ�û������~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    // ��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ������
    public int headQueue() {
        // �ж�
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ�գ�û������~~");
        }
        return arr[front + 1];
    }
}