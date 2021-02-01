package guohaoAlgorithm.��ָoffer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/1 9:52
 *
 * ��ָ Offer 05. �滻�ո�
 * ��ʵ��һ�����������ַ��� s �е�ÿ���ո��滻��"%20"��
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "We are happy."
 * �����"We%20are%20happy."
 */
public class ReplaceSpace {

    // Ч�ʣ� ��100%��90.34%��
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return "";
        // 1)ͳ�ƿո�
        int count = 0, len = s.length();
        for (char c : s.toCharArray()) {
            if (c == ' ') count++;
        }
        int n = len + 2 * count;
        char[] ans = new char[n];
        int index = n - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                ans[index--] = '0';
                ans[index--] = '2';
                ans[index--] = '%';
            }else {
                ans[index--] = s.charAt(i);
            }
        }
        return new String(ans);
    }

}
