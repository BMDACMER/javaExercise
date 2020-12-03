package com.gh.swing.basicComponents;

import javax.swing.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/26 15:14
 *
 * reference: https://blog.csdn.net/xietansheng/article/details/74363379
 */
public class JRadioButton1 {

    public static void main(String[] args) {
        JFrame jf = new JFrame("���Դ���");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(200,250);
        jf.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        // ����������ѡ��ť
        JRadioButton radioBtn01 = new JRadioButton("��");
        JRadioButton radioBtn02 = new JRadioButton("Ů");

        // ������ť�飬��������ѡ��ť���ӵ�����
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioBtn01);
        btnGroup.add(radioBtn02);

        // ���õ�һ����ѡ��ťѡ��
        radioBtn01.setSelected(true);

        panel.add(radioBtn01);
        panel.add(radioBtn02);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }
}