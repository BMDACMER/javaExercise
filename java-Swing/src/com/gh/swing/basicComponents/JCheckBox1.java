package com.gh.swing.basicComponents;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/26 15:23
 *
 * reference: https://blog.csdn.net/xietansheng/article/details/74363460
 */
public class JCheckBox1 {

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建复选框
        JCheckBox checkBox01 = new JCheckBox("菠萝");
        JCheckBox checkBox02 = new JCheckBox("香蕉");
        JCheckBox checkBox03 = new JCheckBox("雪梨");
        JCheckBox checkBox04 = new JCheckBox("荔枝");
        JCheckBox checkBox05 = new JCheckBox("橘子");
        JCheckBox checkBox06 = new JCheckBox("苹果");

        // 添加第一个复选框的状态被改变的监听（其他复选框如果需要监听状态改变，则可按此方法添加监听）
        checkBox01.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即复选框本身）
                JCheckBox checkBox = (JCheckBox) e.getSource();
                System.out.println(checkBox.getText() + " 是否选中: " + checkBox.isSelected());
            }
        });

        // 设置默认第一个复选框选中
        checkBox01.setSelected(true);

        panel.add(checkBox01);
        panel.add(checkBox02);
        panel.add(checkBox03);
        panel.add(checkBox04);
        panel.add(checkBox05);
        panel.add(checkBox06);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }
}
