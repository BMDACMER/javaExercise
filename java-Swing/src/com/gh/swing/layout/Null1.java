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
        JFrame jf = new JFrame("绝对布局");
        jf.setLocation(300,300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 创建内容面板，指定布局为null，则使用绝对布局
        JPanel panel = new JPanel(null);

        // 创建按钮
        JButton btn = new JButton("Button1");
        // 设置按钮的坐标
        btn.setLocation(50,50);
        // 设置按钮的宽高
        btn.setSize(100, 50);
        panel.add(btn);

        // 创建按钮
        JButton btn2 = new JButton("Button2");
        // 设置按钮的界限(坐标和宽高)，设置按钮的坐标为(50, 100)，宽高为 100, 50
        btn2.setBounds(50,100,100,50);
        panel.add(btn2);

        // 显示窗口
        jf.setContentPane(panel);
        jf.setVisible(true);
    }
}
