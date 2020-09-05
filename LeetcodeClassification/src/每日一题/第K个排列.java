package 每日一题;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/5 20:11
 * 60. 第k个排列
 * https://leetcode-cn.com/problems/permutation-sequence/
 * <p>
 * 参考解法：https://leetcode-cn.com/problems/permutation-sequence/solution/di-kge-pai-lie-shu-xue-gui-na-on2-by-acw_weian/
 */
public class 第K个排列 {
    /**
     * 做法：
     * <p>
     * 从高位到低位依次考虑每一位；
     * 对于每一位，从小到大依次枚举未使用过的数，确定当前位是几；
     * 为了便于理解，我们这里给出一个例子的具体操作：n=4,k=14。
     * 首先我们将所有排列按首位分组：
     * <p>
     * 1 + (2, 3, 4的全排列)
     * 2 + (1, 3, 4的全排列)
     * 3 + (1, 2, 4的全排列)
     * 4 + (2, 3, 4的全排列)
     * 接下来我们确定第 k=14个排列在哪一组中。每组的排列个数是 3!=6个，所以第14个排列在第3组中，所以首位已经可以确定，是3。
     * <p>
     * 然后我们再将第3组的排列继续分组：
     * <p>
     * 31 + (2, 4的全排列)
     * 32 + (1, 4的全排列)
     * 34 + (1, 2的全排列)
     * 接下来我们判断第 k=14个排列在哪个小组中。我们先求第 14个排列在第三组中排第几，由于前两组每组有6个排列，所以第14个排列在第3组排第
     * 14?6?2=2。
     * 在第三组中每个小组的排列个数是 2!=2个，所以第 k 个排列在第1个小组，所以可以确定它的第二位数字是1。
     * <p>
     * 依次类推，可以推出第14个排列是 3142。
     * <p>
     * 时间复杂度分析：两重循环，所以时间复杂度是 O(n^2)。
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];   // 用于存放阶乘的
        fact[0] = 1;   // 0! = 1
        for (int i = 1; i <= n; i++) {
            fact[i] = i * fact[i - 1];
        }

        boolean[] visited = new boolean[n + 1]; // 用于记录该数字是否被访问
        StringBuilder sb = new StringBuilder();  // 用于存放最终的结果

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {  // 当前数字还未被访问
                    if (k <= fact[n - i]) {   // 当前k端在fact[n-i]内
                        sb.append(j);    // 取 j 这位
                        visited[j] = true;
                        break;
                    }
                    // 不在该分组 fact[n- i]
                    k -= fact[n - i];
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        第K个排列 m = new 第K个排列();
        System.out.println(m.getPermutation(4, 14));
    }

}
