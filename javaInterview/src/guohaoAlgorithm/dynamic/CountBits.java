package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/25 23:11
 *
 * https://leetcode-cn.com/problems/counting-bits/
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 */
public class CountBits {

    // 暴力算法
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        ans[0] = 0;  // 0转为二进制后 1的个数依旧为0个
        for (int i = 1; i <= num; i++) {
            int temp = 0;
            int j = i;
            while (j != 0) {
                /*temp += j & 1;
                j >>= 1;*/
                temp++;
                j &= (j-1);
            }
            ans[i] = temp;
        }
        return ans;
    }

    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
/*
    作者：LeetCode
    链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public static void main(String[] args) {
        CountBits c = new CountBits();
        System.out.println(c.countBits(2));
    }
}
