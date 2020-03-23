package java02;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * * ����FileInputStream��FileOutputStream��ʹ��
 * <p>
 * ���ۣ�
 * 1. �����ı��ļ�(.txt,.java,.c,.cpp)��ʹ���ַ�������
 * 2. ���ڷ��ı��ļ�(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)��ʹ���ֽ�������
 */
public class Code_02_FileInputOutputStream {

    // ʹ��FileInputStream�����ı��ļ������ܻ��������
    // Ӧ��ʹ��fileReader
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

    // ʵ�ֶ�ͼƬ�ĸ���
    @Test
    public void testFileInputOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("src\\����������.jpg");
            File descFile = new File("src\\����������1.jpg");

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

    // ָ��·���¸���
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

        String srcPath = "src\\����������.jpg";
        String descPath = "src\\����������2.jpg";

        copyFile(srcPath,descPath);

        long end = System.currentTimeMillis();
        System.out.println("���Ʋ������ѵ�ʱ��Ϊ��" + (end - start)); // ���Ʋ������ѵ�ʱ��Ϊ��135
    }
}
