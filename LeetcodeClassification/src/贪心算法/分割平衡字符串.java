package ̰���㷨;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 10:13
 *
 * 1221. �ָ�ƽ���ַ���
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 */
public class �ָ�ƽ���ַ��� {
    /**
     * ����ע��㣺
     *  1��������sһ����ƽ���ַ���
     *  2���㷨˼·��
     *      ������"L"�ַ�ʱ num++��������"R"�ַ�ʱ num--����num = 0ʱ count++��
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int count = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                num++;
            else num--;
            if (num == 0)
                count++;
        }

        return count;
    }
}
