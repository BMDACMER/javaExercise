package java02;

import org.junit.Test;

import java.io.*;

public class Code_02_BufferedTest {

    @Test
    public void testBufferedReaderBufferedWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("src\\dbcp.txt"));
            bw = new BufferedWriter(new FileWriter("src\\dbcp12.txt"));

            char[] cbuff = new char[1024];
            int len;
            while ((len = br.read(cbuff)) != -1){
                bw.write(cbuff, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void copyFileWithBuffered(String srcPath, String destPath){

        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destPath);

            bi = new BufferedInputStream(fis);
            bo = new BufferedOutputStream(fos);

            // 复制过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bi.read(buffer)) != -1){
                bo.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bo != null) {
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
//            File srcFile = new File("src\\爱情与友情.jpg");
//            File destFile = new File("src\\爱情与友情3.jpg");
            File srcFile = new File("src\\dbcp.txt");
            File destFile = new File("src\\dbcp2.txt");

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
