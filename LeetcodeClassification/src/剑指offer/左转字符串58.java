package ��ָoffer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/17 17:19
 * ��ָoffer58 ��ת�ַ���
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 */
public class ��ת�ַ���58 {
    public String reverseLeftWords(String s, int n) {
        // ����һ�� ������  ʱ�临�Ӷ�ΪO(n)   �ռ临�Ӷ�ΪO(n)
        // 23.93%   53.85%
        /*int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = n; i < len; i++) {
            sb.append(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();*/

        // ���������ÿ⺯��
        // 100%  44.43%
        return s.substring(n,s.length()) + s.substring(0,n);
    }

    public static void main(String[] args) {
        ��ת�ַ���58 m = new ��ת�ַ���58();
        System.out.println(m.reverseLeftWords("abcdefg",2));
    }
}
