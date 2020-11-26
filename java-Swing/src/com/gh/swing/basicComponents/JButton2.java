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
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(200,200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        final JButton btn = new JButton();

        // 设置按钮的默认图片
        btn.setIcon(new ImageIcon("01.jpg"));

        // 设置按钮被点击时的图片
        btn.setPressedIcon(new ImageIcon("02.jpg"));

        // 不绘制边框
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);    //不绘制默认按钮背景
        btn.setFocusPainted(false);           //不绘制图片或文字周围的焦点虚框

        // 添加按钮点击事件监听器
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("被按钮点击了");
            }
        });

        panel.add(btn);

        jf.setContentPane(panel);
        jf.setVisible(true);

    }
}
