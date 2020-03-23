package java02;

import org.junit.Test;

import java.io.*;

/**
 * * * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *
 */
public class Code_02_FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");  // 相对于当前工程
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());  // 返回文件的绝对路径名称
        System.out.println("*****************************");
        File file1 = new File("java02\\hello");   // 当前工程下
        System.out.println(file1.getAbsoluteFile());  // E:\dev\javaweb\IDEA\javaExercise\java02\hello
        System.out.println(file.getAbsolutePath());  // E:\dev\javaweb\IDEA\javaExercise\hello.txt
    }


    @Test
    public void testFileReader() {
        FileReader fileReader = null;

        try {
            // 1 实例化File类的对象，指明要操作的文件
            File file = new File("E:\\dev\\javaweb\\IDEA\\javaExercise\\javaInterview\\src\\hello.txt");
            // 2 提供具体的流
            fileReader = new FileReader(file);

            // 3 读入操作
            int data;
            while ((data = fileReader.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4 关闭操作
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
     *从内存中写出数据到硬盘的文件里。

     说明：
     1. 输出操作，对应的File可以不存在的。并不会报异常
     2. File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
     File对应的硬盘中的文件如果存在：
     如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原文件的覆盖
     如果流使用的构造器是：FileWriter(file,true):不会对原文件覆盖，而是在原文件基础上追加内容
     */
    @Test
    public void testFileWriter(){
        FileWriter fw = null;
        try {
            File file = new File("src\\hello1.txt");
            fw = new FileWriter(file); // 默认append=false   覆盖
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

