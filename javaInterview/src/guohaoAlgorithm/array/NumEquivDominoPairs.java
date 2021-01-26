package guohaoAlgorithm.array;

import javabase.thread.NumThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 8:54
 *
 * 1128. 等价多米诺骨牌对的数量
 *形式上，dominoes[i] = [a, b]?和?dominoes[j] = [c, d]?等价的前提是?a==c?且?b==d，或是?a==d 且?b==c。
 *
 * 在?0 <= i < j < dominoes.length?的前提下，找出满足?dominoes[i] 和?dominoes[j]?等价的骨牌对 (i, j) 的数量。
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int len = dominoes.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Arrays.sort(dominoes[i]);
            String key = dominoes[i][0] + "," + dominoes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int v : map.values()) {
            if (v == 0) continue;
            ans += v * (v - 1) / 2;
        }

        return ans;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumEquivDominoPairs n = new NumEquivDominoPairs();
        int[][] dominoes = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(n.numEquivDominoPairs2(dominoes));
    }
}
