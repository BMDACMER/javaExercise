package com.gh.swing.basicComponents;

import javax.swing.*;
import java.awt.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/26 14:31
 *
 * reference: https://blog.csdn.net/xietansheng/article/details/74362076
 */
public class JLable1 {

    public static void main(String[] args) {
        JFrame jf = new JFrame("���Դ���");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ����������壬Ĭ��ʹ����ʽ����
        JPanel panel = new JPanel();

        JLabel label01 = new JLabel();
        label01.setText("Only Text");
        label01.setFont(new Font(null, Font.PLAIN, 25)); // �������壬null ��ʾʹ��Ĭ������
        panel.add(label01);

        /**
         * ֻ��ʾͼƬ
         */
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("./01.jpg"));
        panel.add(label02);

        /**
         *  ͬʱ��ʾ�ı���ͼƬ
         */
        JLabel label03 = new JLabel();
        label03.setText("�ı���ͼƬ");
        label03.setIcon(new ImageIcon("02.jpg"));
        label03.setHorizontalTextPosition(SwingConstants.CENTER); // ˮƽ�����ı���ͼƬ����
        label03.setVerticalTextPosition(SwingConstants.BOTTOM); // ��ֱ�����ı���ͼƬ�·�
        panel.add(label03);

        jf.setContentPane(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}
