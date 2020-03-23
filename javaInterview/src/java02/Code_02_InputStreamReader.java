package java02;

import org.junit.Test;

import java.io.*;

public class Code_02_InputStreamReader {
    @Test
    public void test1(){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream("src\\dbcp.txt");
            isr = new InputStreamReader(fis, "UTF-8");

            char[] cbuf = new char[20];
            int len;
            while ((len=isr.read(cbuf))!=-1){
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file1 = new File("src\\dbcp.txt");
            File file2 = new File("src\\dbcp_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
