package com.gh.swing.introductionOfJavaSwing;

import javax.swing.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 9:19
 */
public class Main {
    // �ο���https://blog.csdn.net/xietansheng/article/details/72814531
    public static void main(String[] args) {
        // 1 ��������
        JFrame jf = new JFrame("���Դ���");   // ��������
        jf.setSize(250,250);   // ���ô��ڴ�С
        jf.setLocationRelativeTo(null);  // �Ѵ���λ�����õ���Ļ����
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // ��������ڵĹرհ�ťʱ�˳�����û����һ�䣬���򲻻��˳���

        // 2 �����м����������������
        JPanel panel = new JPanel();

        // 3 ����һ�������������ť��������ӵ����������
        JButton btn = new JButton("���԰�ť");
        panel.add(btn);

        // 4 �� ������� ��Ϊ���ڴ�������� ���õ� ����
        jf.setContentPane(panel);

        // 5 ��ʾ���ڣ�ǰ�洴������Ϣ�����ڴ��У�ͨ��jf.setVisible(true)���ڴ��еĴ�����ʾ����Ļ��
        jf.setVisible(true);

    }
}
