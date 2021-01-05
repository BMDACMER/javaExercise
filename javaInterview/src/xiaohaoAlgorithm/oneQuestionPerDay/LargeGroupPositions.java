package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/5 8:40
 */
public class LargeGroupPositions {

    /**
     * 双指针
     * @param
     * @return
     *//*
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int start = 0, index = 1;  // 定义起始位置   双指针
        int count = 1;

        while (index < s.length()) {
            while (index < s.length() && s.charAt(start) == s.charAt(index)) {
                count++;
                index++;
            }

            if (count >= 3) {
                list.add(start);
                list.add(index - 1);
            }
            if (!list.isEmpty()) {
                res.add(list);
                list = new ArrayList<>();
            }

            start = index;
            index++;
            count = 1;
        }

        // 这个可以不要
        if (!res.isEmpty()) {
            Collections.sort(res, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(0) - o2.get(0);
                }
            });
        }

        return res;
    }*/

    public static void main(String[] args) {
        LargeGroupPositions l = new LargeGroupPositions();
        l.largeGroupPositions("abbxxxxzzy");
    }

    /**
     * 优化算法
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0, count = 1;
        for (int i = 1; i < s.length(); i++) {
            while (i < s.length() && s.charAt(start) == s.charAt(i)) {
                count++;
                i++;
            }
            if (count >= 3) {
                res.add(Arrays.asList(start, i-1));
            }
            start = i;
            count = 1;
        }
        return res;
    }
}
