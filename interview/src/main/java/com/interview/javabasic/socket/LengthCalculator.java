package com.interview.javabasic.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LengthCalculator extends Thread {
    // ��socketΪ��Ա����
    private Socket socket;

    public LengthCalculator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        OutputStream os = null;
        try {
            // ��ȡsocket�������
            os = socket.getOutputStream();
            // ��ȡsocket��������
            is = socket.getInputStream();
            int ch = 0;
            byte[] buff = new byte[1024];
            //buff��Ҫ������ȡ��������ݣ����byte���飬ch��Ҫ������ȡ��ȡ����ĳ���
            ch = is.read(buff);

            //����������byte����ת�����ַ����������ȡ�������ǿͻ��˷��͹������ַ�������
            String content = new String(buff, 0, ch);
            System.out.println("LengthCalculator: " + content);
            //���������д���õ��ַ����ĳ��ȣ��ط����ͻ���
            os.write(String.valueOf(content.length()).getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

}
