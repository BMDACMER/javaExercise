package com.interview.javabasic.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        // ����˽��ܿͻ��˷��͵����ݱ�
        DatagramSocket socket = new DatagramSocket(65001); //�����Ķ˿ں�
        byte[] buff = new byte[100]; //�洢�ӿͻ��˽��ܵ�������
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        //���ܿͻ��˷��͹��������ݣ��������ݷ�װ��DatagramPacket������
        socket.receive(packet);

        byte[] data = packet.getData(); //��DatagramPacket�����л�ȡ�������洢������
        //�����ݴӶ�����ת�����ַ�����ʽ
        String content = new String(data, 0, packet.getLength());
        System.out.println(content);
        //��Ҫ���͸��ͻ��˵�����ת���ɶ�����
        byte[] sendedContent = String.valueOf(content.length()).getBytes();
        // ����˸��ͻ��˷������ݱ�
        //��DatagramPacket�����л�ȡ�����ݵ���Դ��ַ��˿ں�
        DatagramPacket packetToClient = new DatagramPacket(sendedContent,
                sendedContent.length, packet.getAddress(), packet.getPort());
        socket.send(packetToClient); //�������ݸ��ͻ���
    }
}
