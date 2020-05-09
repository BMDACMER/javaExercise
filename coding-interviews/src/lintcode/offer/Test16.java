package lintcode.offer;

/**
 * 面试题17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Test16 {
    public int[] printNumbers(int n) {
        int num=(int)Math.pow(10,n);
        int[] arr=new int[num-1];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        return arr;

        /**
        //因为n为正整数，所以最小为10，也可以把10改为9，100改为99等
        int[] map = { 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000,
                100_000_000, 1_000_000_000, Integer.MAX_VALUE };
        int size = map[n-1];
        int[] ans = new int[size - 1];
        for (int i = 1; i < size; i++) {
            ans[i - 1] = i;
        }
        return ans;

        作者：hteason
        链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/javada-biao-bu-jie-zhu-mathpow-by-hteason/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        */
    }
}
