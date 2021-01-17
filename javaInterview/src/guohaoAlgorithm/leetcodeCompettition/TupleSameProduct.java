package guohaoAlgorithm.leetcodeCompettition;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/17 10:53
 */
public class TupleSameProduct {

    /**
     * 暴力算法 超时   3.7s左右
     * @param nums
     * @return
     */
    public int tupleSameProduct2(int[] nums) {
        int n = nums.length;
        if (n < 4) return 0;

        int a,b,c,d;
        int count = 0;
        HashSet<String> set = new HashSet<>();
        String str = "";
        for (int i = 0; i < n; i++) {
            a = nums[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    b = nums[j];
                    for (int k = 0; k < n; k++) {
                        if (k != j && k != i) {
                            c = nums[k];
                            for (int l = 0; l < n; l++) {
                                if (l != k && l != j && l != i) {
                                    d = nums[l];
                                    StringBuilder sb = new StringBuilder();
                                    str = sb.append(a).append(",").append(b).append(",").append(c).append(",").append(d).toString();
                                    if (a * b == c * d && !set.contains(str)) {
                                        set.add(str);
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }

            }

        }
        return count;
    }

    /**
     * HashMap 方法
     * @param nums
     * @return
     */
    public int tupleSameProduct3(int[] nums) {
        int n = nums.length;
        if (n < 4) return 0;

        HashMap<Integer, Integer> map = new  HashMap<>();
        int tmp, ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                tmp = nums[i]*nums[j];
                if (map.containsKey(tmp)) {
                    ans += map.get(tmp);
                    map.put(tmp, map.get(tmp) + 1);
                }else {
                    map.put(tmp, 1);
                }

            }
        }
        return ans<<3;
    }

    // 参考： https://leetcode-cn.com/problems/tuple-with-same-product/solution/ha-xi-pai-lie-zu-he-by-yexiso-8mmd/
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        if (n < 4) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = nums[i] * nums[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }

        for (int key : map.keySet()) {
            if (key >= 2) {
                ans += map.get(key) * (map.get(key) - 1);
            }
        }

        return ans<<2;
    }

    public static void main(String[] args) {
        TupleSameProduct t = new TupleSameProduct();
        // 1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192
        /**
         * [549,758,620,258,688,676,415,5,12,744,440,808,889,355,233,810,312,822,910,210,570,203,593,874,412,518,22,251,708,497,725,180,826,653,629,257,330,90,719,80,849,924,313,600,107,877,164,33,132,2,124,729,57,394,890,891,772,205,908,236,987,273,811,428,449,206,37,373,158,853,955,171,564,393,932,701,292,363,89,427,76,569,144,484,869,325,978,204,940,411,234,94,907,288,408,977,473,604,835,581]
         */
        long start = System.currentTimeMillis();
        int[] nums = {549,758,620,258,688,676,415,5,12,744,440,808,889,355,233,810,312,822,910,210,570,203,593,874,412,518,22,251,708,497,725,180,826,653,629,257,330,90,719,80,849,924,313,600,107,877,164,33,132,2,124,729,57,394,890,891,772,205,908,236,987,273,811,428,449,206,37,373,158,853,955,171,564,393,932,701,292,363,89,427,76,569,144,484,869,325,978,204,940,411,234,94,907,288,408,977,473,604,835,581};
//        int[] nums = {2,3,4,6,8,12};
        int count = t.tupleSameProduct3(nums);
        System.out.println(count);
        System.out.println("总共耗时：" + (System.currentTimeMillis() - start) / 1000.0d + " 秒");
    }
}
