package javanet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP���
 */
public class TCP {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;

        try {
            //1.����Socket����ָ���������˵�ip�Ͷ˿ں�
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            //2.��ȡһ��������������������
            os = socket.getOutputStream();
            //3.д�����ݵĲ���
            os.write("��ã����ǿͻ���mm".getBytes());

            // 5 �������Է���˵�����
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len1;
            while ((len1 = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.��Դ�Ĺر�
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.�����������˵�ServerSocket��ָ���Լ��Ķ˿ں�
            ss = new ServerSocket(8899);
            //2.����accept()��ʾ���������ڿͻ��˵�socket
            socket = ss.accept();
            //3.��ȡ������
            is = socket.getInputStream();

            //����������д�����ܻ�����
//        byte[] buffer = new byte[1024];
//        int len;
//        while((len = is.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);
//        }
            //4.��ȡ�������е�����
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());

            System.out.println("�յ��������ڣ�" + socket.getInetAddress().getHostAddress() + "������");

            OutputStream os = socket.getOutputStream();
            os.write("���ã���Ϣ���յ�".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                //5.�ر���Դ
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
