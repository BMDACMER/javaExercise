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
        JFrame jf = new JFrame("���Դ���");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // ������ѡ��
        JCheckBox checkBox01 = new JCheckBox("����");
        JCheckBox checkBox02 = new JCheckBox("�㽶");
        JCheckBox checkBox03 = new JCheckBox("ѩ��");
        JCheckBox checkBox04 = new JCheckBox("��֦");
        JCheckBox checkBox05 = new JCheckBox("����");
        JCheckBox checkBox06 = new JCheckBox("ƻ��");

        // ��ӵ�һ����ѡ���״̬���ı�ļ�����������ѡ�������Ҫ����״̬�ı䣬��ɰ��˷�����Ӽ�����
        checkBox01.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // ��ȡ�¼�Դ������ѡ����
                JCheckBox checkBox = (JCheckBox) e.getSource();
                System.out.println(checkBox.getText() + " �Ƿ�ѡ��: " + checkBox.isSelected());
            }
        });

        // ����Ĭ�ϵ�һ����ѡ��ѡ��
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
