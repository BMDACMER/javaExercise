package com.gh.swing.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 9:53
 *
 * reference: https://blog.csdn.net/xietansheng/article/details/72814548
 */
public class GridLayout {
    public static void main(String[] args) {
        JFrame jf = new JFrame("GridLayout");
        jf.setSize(200,250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new java.awt.GridLayout(3,3));

        JButton btn01 = new JButton("按钮01");
        JButton btn02 = new JButton("按钮02");
        JButton btn03 = new JButton("按钮03");
        JButton btn04 = new JButton("按钮04");
        JButton btn05 = new JButton("按钮05");
        JButton btn06 = new JButton("按钮06");
        JButton btn07 = new JButton("按钮07");
        JButton btn08 = new JButton("按钮08");
        JButton btn09 = new JButton("按钮09");

        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
        panel.add(btn05);
        panel.add(btn06);
        panel.add(btn07);
        panel.add(btn08);
//        panel.add(btn09);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }
}
