package com.interview.javabasic.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        // �ͻ��˷����ݱ��������
        DatagramSocket socket = new DatagramSocket();
        // Ҫ���͸�����˵�����
        byte[] buf = "Hello World".getBytes();
        // ��IP��ַ��װ��InetAddress����
        InetAddress address = InetAddress.getByName("127.0.0.1");
        // ��Ҫ���͸�����˵����ݷ�װ��DatagramPacket���� ��Ҫ��д��ip��ַ��˿ں�
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address,
                65001);
        // �������ݸ������
        socket.send(packet);

        // �ͻ��˽��ܷ���˷��͹��������ݱ�
        byte[] data = new byte[100];
        // ����DatagramPacket���������洢����˷��͹���������
        DatagramPacket receivedPacket = new DatagramPacket(data, data.length);
        // �����ܵ������ݴ洢��DatagramPacket������
        socket.receive(receivedPacket);
        // ���������˷��͹���������ȡ��������ӡ������̨
        String content = new String(receivedPacket.getData(), 0,
                receivedPacket.getLength());
        System.out.println(content);

    }
}
