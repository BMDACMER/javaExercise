package com.gh.swing.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 10:01
 *
 * reference: https://blog.csdn.net/xietansheng/article/details/72814552
 */
public class GridBagLayout1 {
    public static void main(String[] args) {
        // 1 顶层容器
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(300,350);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 2 中间层
        GridBagLayout gridBag = new GridBagLayout();  // 布局管理器
        GridBagConstraints c = null;                  // 约束

        JPanel panel = new JPanel(gridBag);

        JButton btn01 = new JButton("button01");
        JButton btn02 = new JButton("Button02");
        JButton btn03 = new JButton("Button03");
        JButton btn04 = new JButton("Button04");
        JButton btn05 = new JButton("Button05");
        JButton btn06 = new JButton("Button06");
        JButton btn07 = new JButton("Button07");
        JButton btn08 = new JButton("Button08");
        JButton btn09 = new JButton("Button09");
        JButton btn10 = new JButton("Button10");

        // 添加  组件 和 约束 到布局管理器
        // btn01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn01, c);  // 内部使用的仅是 c 的副本

        // btn02
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn02, c);

        // btn03
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn03, c);

        // Button04 显示区域占满当前行剩余空间（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn04, c);

        // Button05 显示区域独占一行（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn05, c);

        // Button06 显示区域占到当前尾倒车第二个单元格（下一个组件后需要手动换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn06, c);

        // Button07 放置在当前行最后一个单元格（换行）
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.addLayoutComponent(btn07, c);

        // Button08 显示区域占两列，组件填充显示区域
        c = new GridBagConstraints();
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn08, c);

        // Button09 显示区域占满当前行剩余空间（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn09, c);

        // Button10 显示区域占满当前行剩余空间（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn10, c);

        // 添加组件到内容面板
        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
        panel.add(btn05);
        panel.add(btn06);
        panel.add(btn07);
        panel.add(btn08);
        panel.add(btn09);
        panel.add(btn10);


        jf.setContentPane(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }
}
