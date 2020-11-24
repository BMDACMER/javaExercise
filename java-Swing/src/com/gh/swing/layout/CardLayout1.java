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
        JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(300, 200);

        // 创建卡片布局，卡片间水平和竖直间隔为 10
        final CardLayout layout = new CardLayout(10, 10);

        // 创建内容面板容器，指定布局管理器
        final JPanel panel = new JPanel(layout);

        JButton btn01 = new JButton("Button01");
        JButton btn02 = new JButton("Button02");
        JButton btn03 = new JButton("Button03");

        panel.add(btn01, "btn01");
        panel.add(btn02, "btn02");
        panel.add(btn03, "btn03");

        // 先显示第二个
        layout.show(panel, "btn02");

        jf.setContentPane(panel);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        // 每间隔2秒切换显示下一个
        new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.next(panel);
            }
        }).start();
    }
}
