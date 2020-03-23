package java02;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * * 测试FileInputStream和FileOutputStream的使用
 * <p>
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 */
public class Code_02_FileInputOutputStream {

    // 使用FileInputStream处理文本文件，可能会出现乱码
    // 应该使用fileReader
    @Test
    public void testFileInputStream() {
        FileInputStream fi = null;
        try {
            File file = new File("src\\hello.txt");
            fi = new FileInputStream(file);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fi.read(buffer)) != -1) {
                String s = new String(buffer, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fi != null)
                    fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 实现对图片的复制
    @Test
    public void testFileInputOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("src\\爱情与友情.jpg");
            File descFile = new File("src\\爱情与友情1.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len=fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 指定路径下复制
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File descFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcPath = "src\\爱情与友情.jpg";
        String descPath = "src\\爱情与友情2.jpg";

        copyFile(srcPath,descPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end - start)); // 复制操作花费的时间为：135
    }
}
