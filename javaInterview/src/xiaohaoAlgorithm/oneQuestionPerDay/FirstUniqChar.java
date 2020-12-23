package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/23 14:15
 * 387. �ַ����еĵ�һ��Ψһ�ַ�
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] nums = new int[26];  // ͳ��26��Сд��ĸ���ֵĴ���
        Arrays.fill(nums, 0);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            nums[chars[i] - 'a'] ++;
        }

        // ���ص�һ�����ظ����ַ����±�
        for (int i = 0; i < chars.length; i++) {
            if (nums[chars[i] - 'a'] == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar f = new FirstUniqChar();
        System.out.println(f.firstUniqChar("loveleetcode"));
    }
}
