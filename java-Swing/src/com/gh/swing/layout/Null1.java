package com.gh.swing.layout;

import javax.swing.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/26 14:23
 * reference: https://blog.csdn.net/xietansheng/article/details/72862726
 */
public class Null1 {

    public static void main(String[] args) {
        JFrame jf = new JFrame("���Բ���");
        jf.setLocation(300,300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ����������壬ָ������Ϊnull����ʹ�þ��Բ���
        JPanel panel = new JPanel(null);

        // ������ť
        JButton btn = new JButton("Button1");
        // ���ð�ť������
        btn.setLocation(50,50);
        // ���ð�ť�Ŀ��
        btn.setSize(100, 50);
        panel.add(btn);

        // ������ť
        JButton btn2 = new JButton("Button2");
        // ���ð�ť�Ľ���(����Ϳ��)�����ð�ť������Ϊ(50, 100)�����Ϊ 100, 50
        btn2.setBounds(50,100,100,50);
        panel.add(btn2);

        // ��ʾ����
        jf.setContentPane(panel);
        jf.setVisible(true);
    }
}
