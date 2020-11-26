package com.gh.swing.basicComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/26 14:56
 */
public class JButton2 {
    public static void main(String[] args) {
        JFrame jf = new JFrame("���Դ���");
        jf.setSize(200,200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        final JButton btn = new JButton();

        // ���ð�ť��Ĭ��ͼƬ
        btn.setIcon(new ImageIcon("01.jpg"));

        // ���ð�ť�����ʱ��ͼƬ
        btn.setPressedIcon(new ImageIcon("02.jpg"));

        // �����Ʊ߿�
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);    //������Ĭ�ϰ�ť����
        btn.setFocusPainted(false);           //������ͼƬ��������Χ�Ľ������

        // ��Ӱ�ť����¼�������
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("����ť�����");
            }
        });

        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);

    }
}
