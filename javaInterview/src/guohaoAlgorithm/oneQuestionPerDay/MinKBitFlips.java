package guohaoAlgorithm.oneQuestionPerDay;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author guohao
 * @Date 2021/2/18 9:09
 * @Version 1.0
 */
public class MinKBitFlips {

    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-bikk/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int minKBitFlips2(int[] A, int K) {
        int len = A.length;
        // 存储保存 要翻转的子数组边界，队列大小为当前元素要翻转次数
        Deque<Integer> transformRange = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            // 到达当前队列中最小的边界时，要将其排除
            if (!transformRange.isEmpty() && transformRange.peekFirst() == i) transformRange.pollFirst();
            // 第i个元素的实际值，为A[i]加上翻转次数
            int cur = A[i] + transformRange.size();

            // 当前位置的实际值不为1的情况
            if (cur % 2 == 0) {
                // 表示新的边界已经到达数组长度上线，该情况不可能成立，返回-1
                if(i + K > len) return -1;
                // 将[i, i + K]之间的元素翻转一次，将翻转的范围边界加入队列
                transformRange.offerLast(i + K);
                cnt++;
            }
        }
        return cnt;
    }
}
