package com.interview.javabasic.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //����socket,����socket�󶨵�65000�˿�
        ServerSocket ss = new ServerSocket(65000);
        //��ѭ����ʹ��socketһֱ�ȴ�������ͻ��˷��͹���������
        while (true) {
            //����65000�˿ڣ�ֱ���ͻ��˷���������Ϣ��ŷ���
            Socket socket = ss.accept();
            //��ȡ�ͻ��˵�������Ϣ��ִ�����ҵ���߼�
            new LengthCalculator(socket).start();
        }
    }
}
