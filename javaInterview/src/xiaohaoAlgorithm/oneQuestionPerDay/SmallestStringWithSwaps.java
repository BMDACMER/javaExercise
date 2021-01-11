package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/11 14:40
 *
 * 1202. 交换字符串中的元素
 */
public class SmallestStringWithSwaps {

    /**
     * 参考：https://leetcode-cn.com/problems/smallest-string-with-swaps/solution/1202-jiao-huan-zi-fu-chuan-zhong-de-yuan-wgab/
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) return s;

        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> list : pairs) {
            uf.union(list.get(0), list.get(1));
        }

        // 上面已经连通，将不同堆的字符放进 优先队列中
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>(n);
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            map.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(chars[i]);
        }

        // 重组字符串
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
}
