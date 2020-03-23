package java02;

import org.junit.Test;

import java.io.*;

public class Code_02_IO_PicTest {
    // 图片加密
    @Test
    public void test1() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\爱情与友情.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("src\\爱情与友情secret.jpg");

            bis = new BufferedInputStream(fileInputStream);
            bos = new BufferedOutputStream(fileOutputStream);

            byte[] buffer = new byte[20];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
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

    // 图片加密
    @Test
    public void test2() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\爱情与友情secret.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("src\\爱情与友情3.jpg");

            bis = new BufferedInputStream(fileInputStream);
            bos = new BufferedOutputStream(fileOutputStream);

            byte[] buffer = new byte[20];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
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
