package com.gh.swing.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/24 23:42
 *
 * reference: https://blog.csdn.net/xietansheng/article/details/72862688
 *
 */
public class CardLayout1 {

    public static void main(String[] args) {
        JFrame jf = new JFrame("���Դ���");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(300, 200);

        // ������Ƭ���֣���Ƭ��ˮƽ����ֱ���Ϊ 10
        final CardLayout layout = new CardLayout(10, 10);

        // �����������������ָ�����ֹ�����
        final JPanel panel = new JPanel(layout);

        JButton btn01 = new JButton("Button01");
        JButton btn02 = new JButton("Button02");
        JButton btn03 = new JButton("Button03");

        panel.add(btn01, "btn01");
        panel.add(btn02, "btn02");
        panel.add(btn03, "btn03");

        // ����ʾ�ڶ���
        layout.show(panel, "btn02");

        jf.setContentPane(panel);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        // ÿ���2���л���ʾ��һ��
        new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.next(panel);
            }
        }).start();
    }
}
