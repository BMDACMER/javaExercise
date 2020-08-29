package ��ײָ��;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 18:17
 * 49  ��ĸ��λ�ʷ���
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 *
 * ˼·�� ����ÿ���ַ������Ƚ����ǵ�ÿ���ַ����ֵĸ����Ƿ���ȣ�����д��һ����������
 *      ��ȵĻ��Ͱ����Ƿ���һ�� list ��ȥ����Ϊһ�����
 *      �����дһ�� for ѭ��Ȼ��һһ�ȽϾͿ��ԣ�
 *      ��������һ���ȴ�Ĳ�������������¼��ǰ�ַ����Ƿ��Ѿ�������� list ��
 *      ʱ�临�Ӷ�ΪO(n*n)
 *
 * ���ߣ�windliang
 * ���ӣ�https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
 * ��Դ�����ۣ�LeetCode��
 * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 */
public class ��ĸ��λ�ʷ��� {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] used = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            List<String> list = null;
            if (!used[i]) {
                list = new ArrayList<>();
                list.add(strs[i]);

                // �ж������ַ����Ƿ����
                for (int j = i + 1; j < strs.length; j++) {
                    if (!used[j] && isEquals(strs[j],strs[i])) {
                        list.add(strs[j]);
                        used[j] = true;
                    }
                }
            }
            if (list!=null)
                ans.add(list);
        }
        return ans;
    }

    // �Ƚ������ַ����Ƿ����
    private boolean isEquals(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        // ͳ��str1�и��ַ��ĸ���
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i),0)+1);
        }

        //  ��str2�� �����ھ��Լ����������
        for (int i = 0; i < str2.length(); i++) {
            if (map.containsKey(str2.charAt(i))) {
                map.put(str2.charAt(i),map.get(str2.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        // �ж�������ַ����Ƿ���� mapΪ�� ˵�����
        //�ж�ÿ���ַ��Ĵ����ǲ��� 0 �����ǵĻ�ֱ�ӷ��� false
        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

}
