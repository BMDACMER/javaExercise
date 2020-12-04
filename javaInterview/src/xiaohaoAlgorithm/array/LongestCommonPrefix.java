package xiaohaoAlgorithm.array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/4 20:00
 *
 * �����ǰ׺
 *
 * ֪ʶ�㣺str.indexOf(baseStr)  ����򷵻�0���������
 *        str.substring(begin, end)   ����begin�������� end
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // �쳣����
        if (strs.length < 1) {
            return "";
        }

        // .indexOf()
        String baseStr = strs[0];  // ��׼�ַ���
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(baseStr) != 0) {
                if (baseStr.length() == 0) {
                    return "";
                }
                baseStr = baseStr.substring(0,baseStr.length() - 1);
            }
        }
        return baseStr;
    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = {"flower","flow", "flight"};

        System.out.println(test.longestCommonPrefix(strs));
    }
}
