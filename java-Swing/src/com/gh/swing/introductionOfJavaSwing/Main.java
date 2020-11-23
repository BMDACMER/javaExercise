package com.gh.swing.introductionOfJavaSwing;

import javax.swing.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 9:19
 */
public class Main {
    // 参考：https://blog.csdn.net/xietansheng/article/details/72814531
    public static void main(String[] args) {
        // 1 顶层容器
        JFrame jf = new JFrame("测试窗口");   // 创建窗口
        jf.setSize(250,250);   // 设置窗口大小
        jf.setLocationRelativeTo(null);  // 把窗口位置设置到屏幕中心
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）

        // 2 创建中间容器（面板容器）
        JPanel panel = new JPanel();

        // 3 创建一个基本组件（按钮），并添加到面板容器中
        JButton btn = new JButton("测试按钮");
        panel.add(btn);

        // 4 把 面板容器 作为窗口大内容面板 设置到 窗口
        jf.setContentPane(panel);

        // 5 显示窗口，前面创建的信息都在内存中，通过jf.setVisible(true)把内存中的窗口显示到屏幕上
        jf.setVisible(true);

    }
}
