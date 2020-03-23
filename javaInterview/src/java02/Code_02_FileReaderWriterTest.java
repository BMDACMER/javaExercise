package java02;

import org.junit.Test;

import java.io.*;

/**
 * * * һ�����ķ��ࣺ
 * 1.�������ݵ�λ���ֽ������ַ���
 * 2.���ݵ������������������
 * 3.���Ľ�ɫ���ڵ�����������
 *
 * ����������ϵ�ṹ
 * �������         �ڵ��������ļ�����                               ����������������һ�֣�
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *
 */
public class Code_02_FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");  // ����ڵ�ǰ����
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());  // �����ļ��ľ���·������
        System.out.println("*****************************");
        File file1 = new File("java02\\hello");   // ��ǰ������
        System.out.println(file1.getAbsoluteFile());  // E:\dev\javaweb\IDEA\javaExercise\java02\hello
        System.out.println(file.getAbsolutePath());  // E:\dev\javaweb\IDEA\javaExercise\hello.txt
    }


    @Test
    public void testFileReader() {
        FileReader fileReader = null;

        try {
            // 1 ʵ����File��Ķ���ָ��Ҫ�������ļ�
            File file = new File("E:\\dev\\javaweb\\IDEA\\javaExercise\\javaInterview\\src\\hello.txt");
            // 2 �ṩ�������
            fileReader = new FileReader(file);

            // 3 �������
            int data;
            while ((data = fileReader.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4 �رղ���
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testFileReader1(){
        FileReader fr = null;
        try {
            File file = new File("src\\hello.txt");
            fr = new FileReader(file);

            char[] cbuff = new char[5];
            int len;
            while ((len = fr.read(cbuff)) != -1){
                String s = new String(cbuff,0,len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     *���ڴ���д�����ݵ�Ӳ�̵��ļ��

     ˵����
     1. �����������Ӧ��File���Բ����ڵġ������ᱨ�쳣
     2. File��Ӧ��Ӳ���е��ļ���������ڣ�������Ĺ����У����Զ��������ļ���
     File��Ӧ��Ӳ���е��ļ�������ڣ�
     �����ʹ�õĹ������ǣ�FileWriter(file,false) / FileWriter(file):��ԭ�ļ��ĸ���
     �����ʹ�õĹ������ǣ�FileWriter(file,true):�����ԭ�ļ����ǣ�������ԭ�ļ�������׷������
     */
    @Test
    public void testFileWriter(){
        FileWriter fw = null;
        try {
            File file = new File("src\\hello1.txt");
            fw = new FileWriter(file); // Ĭ��append=false   ����
            fw.write("Let the epidemic end soon! ");
            fw.write("\nLet's all do it. Try to be less special.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReaderFileWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file = new File("src\\hello.txt");
            File file1 = new File("src\\hello2.txt");
            fr = new FileReader(file);
            fw = new FileWriter(file1);

            char[] cbuff = new char[5];
            int len;
            while ((len = fr.read(cbuff)) != -1){
                String s = new String(cbuff,0,len);
                fw.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

