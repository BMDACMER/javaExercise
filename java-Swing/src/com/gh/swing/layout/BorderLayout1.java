package com.gh.swing.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/26 14:04
 *
 * reference:https://blog.csdn.net/xietansheng/article/details/72862707
 */
public class BorderLayout1 {

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(350, 250);

        // 创建内容面包容器，指定使用 边界布局
        JPanel panel = new JPanel(new BorderLayout());

        // 创建 5 个按钮
        JButton btn1 = new JButton("Button_North");
        JButton btn2 = new JButton("Button_South");
        JButton btn3 = new JButton("Button_West");
        JButton btn4 = new JButton("Button_East");
        JButton btn5 = new JButton("Button_Center");


        // 把5个按钮添加到容器中的5个方位
        panel.add(btn1, BorderLayout.NORTH);
        panel.add(btn2, BorderLayout.SOUTH);
        panel.add(btn3, BorderLayout.WEST);
        panel.add(btn4, BorderLayout.EAST);
        panel.add(btn5, BorderLayout.CENTER);

        jf.setContentPane(panel);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }
}
