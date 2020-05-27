package com.interview.javabasic.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //����socket����ָ�����ӵ��Ǳ����Ķ˿ں�Ϊ65000�ķ�����socket
        Socket socket = new Socket("127.0.0.1", 65000);
        //��ȡ�����
        OutputStream os = socket.getOutputStream();
        //��ȡ������
        InputStream is = socket.getInputStream();
        //��Ҫ���ݸ�server���ַ�������ת����byte���飬��������д�뵽�������
        os.write(new String("hello world").getBytes());

        byte[] buff = new byte[1024];
        //buff��Ҫ������ȡ��������ݣ����byte���飬ch��Ҫ������ȡ��ȡ����ĳ���
        int ch = is.read(buff);
        //����������byte����ת�����ַ����������Ǵӷ���˻ط��������ַ��������ĳ���
        String content = new String(buff, 0, ch);
        System.out.println("TCPClient: " + content);


        //��Ҫ���ǹر�����������Լ�socket
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
