package com.gh.swing.layout;

import javax.swing.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/26 14:11
 * reference: https://blog.csdn.net/xietansheng/article/details/72862722
 * 弹性布局
 */
public class SpringLayout1 {

    public static void main(String[] args) {

        // 创建窗口
        JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);

        // 创建内容面板， 使用 弹性布局
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);
        jf.setContentPane(panel);

        // 创建组件
        JLabel label = new JLabel("Test JLabel:");
        JButton btn = new JButton("Btn");
        JTextField textField = new JTextField("Text Field");

        // 添加组件到内容面板
        panel.add(label);
        panel.add(btn);
        panel.add(textField);

        /*
         * 组件的约束设置（弹性布局设置的关键）
         */

        // 标签组件约束: 设置标签的左上角坐标为 (5, 5)
        SpringLayout.Constraints labelCons = layout.getConstraints(label);
        labelCons.setX(Spring.constant(5));
        labelCons.setY(Spring.constant(5));

        // 按钮组件约束: 设置左上角 水平坐标为5, 垂直坐标为 标签的南边坐标；设置东边坐标为 标签的东边坐标
        SpringLayout.Constraints btnCons = layout.getConstraints(btn);
        btnCons.setX(Spring.constant(5));
        btnCons.setY(labelCons.getConstraint(SpringLayout.SOUTH));
        btnCons.setConstraint(SpringLayout.EAST, labelCons.getConstraint(SpringLayout.EAST));

        // 文本框约束: 设置左上角 水平坐标为 标签的东边坐标 + 5, 垂直坐标为 5
        SpringLayout.Constraints textFieldCons = layout.getConstraints(textField);
        textFieldCons.setX(
                Spring.sum(
                        labelCons.getConstraint(SpringLayout.EAST),
                        Spring.constant(5)
                )
        );
        textFieldCons.setY(Spring.constant(5));

        /*
         * 内容面板（容器）的约束设置，即确定 组件 和 容器的右边和底边 之间的间隙大小
         */
        SpringLayout.Constraints panelCons = layout.getConstraints(panel);  // 获取容器的约束对象

        // 设置容器的 东边坐标 为 文本框的东边坐标 + 5
        panelCons.setConstraint(
                SpringLayout.EAST,
                Spring.sum(
                        textFieldCons.getConstraint(SpringLayout.EAST),
                        Spring.constant(5)
                )
        );

        // 计算出 按钮 和 文本框 的 南边坐标 的 值较大者
        Spring maxHeightSpring = Spring.max(
                btnCons.getConstraint(SpringLayout.SOUTH),
                textFieldCons.getConstraint(SpringLayout.SOUTH)
        );

        // 设置容器的 南边坐标 为 maxHeightSpring + 5
        panelCons.setConstraint(
                SpringLayout.SOUTH,
                Spring.sum(
                        maxHeightSpring,
                        Spring.constant(5)
                )
        );

        // 显示窗口
        jf.setVisible(true);
    }
}
