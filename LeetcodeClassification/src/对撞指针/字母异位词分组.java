package 对撞指针;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 18:17
 * 49  字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 思路： 对于每个字符串，比较它们的每个字符出现的个数是否相等（可以写成一个函数），
 *      相等的话就把它们放在一个 list 中去，作为一个类别。
 *      最外层写一个 for 循环然后一一比较就可以，
 *      还可以用一个等大的布尔型数组来记录当前字符串是否已经加入的了 list 。
 *      时间复杂度为O(n*n)
 *
 * 作者：windliang
 * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] used = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            List<String> list = null;
            if (!used[i]) {
                list = new ArrayList<>();
                list.add(strs[i]);

                // 判断两两字符串是否相等
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

    // 比较两个字符串是否相等
    private boolean isEquals(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        // 统计str1中个字符的个数
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i),0)+1);
        }

        //  在str2中 若存在就自减，否则不相等
        for (int i = 0; i < str2.length(); i++) {
            if (map.containsKey(str2.charAt(i))) {
                map.put(str2.charAt(i),map.get(str2.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        // 判断最后两字符串是否相等 map为空 说明相等
        //判断每个字符的次数是不是 0 ，不是的话直接返回 false
        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

}
