package guohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/1 9:05
 *
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 *
 * 示例 2：
 *
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2] 或 [2,3]均可
 *
 * 示例 3：
 *
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 *
 * 示例 4：
 *
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FairCandySwap {

    // 思路：因为一定存在 ，所以二者相差一定为偶数  取平均  一个增加 一个减少；
    // 将A，B数组分别用hashmap保存，取较小的元素的数组 + 相差平均数  判断是否咋B数组中存在（题意是一定存在） 并返回
    // 耗时 30ms 击败27%
    /*public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        int sum = 0;
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for (int a : A) {
            mapA.put(a, mapA.getOrDefault(a, 0) + 1);
            sum += a;
        }
        for (int b : B) {
            mapB.put(b, mapB.getOrDefault(b, 0) + 1);
            sum -= b;
        }

        // 提示中说   A B一定不相等 ---》 sum != 0
        if (sum > 0) {
            // 说明A总量大
            int avg = sum / 2;
            for (int i = 0; i < A.length; i++) {
                if (mapB.containsKey(A[i] - avg)) {
                    ans[0] = A[i];
                    ans[1] = A[i] - avg;
                    return ans;
                }
            }

        } else {
            // 说明 B总量大
            int avg = Math.abs(sum) / 2;
            for (int i = 0; i < B.length; i++) {
                if (mapA.containsKey(B[i] - avg)) {
                    ans[0] = B[i] - avg;
                    ans[1] = B[i];
                    return ans;
                }
            }
        }
        return ans;
    }*/

    // 方法二  优化代码  采用hashSet更好  优化后19ms   击败32%
    public int[] fairCandySwap2(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int avg = (sumA - sumB) / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) set.add(a);

        int[] ans = new int[2];
        for (int i = 0; i < B.length; i++) {
            if (set.contains(B[i] + avg)) {
                ans[0] = B[i] + avg;
                ans[1] = B[i];
                break;
            }
        }
        return ans;
    }
}
