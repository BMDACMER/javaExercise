package lintcode.offer;

/**
 * 拆分规则：
 * 最优： 3 。把数字 n 可能拆为多个因子 3 ，余数可能为 0,1,2 三种情况。
 * 次优： 2 。若余数为 22 ；则保留，不再拆为 1+1。
 * 最差： 1 。若余数为 11 ；则应把一份 3 + 1 替换为 2 + 2，因为 2×2>3×1。
 * <p>
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Test33 {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n % 3 == 0)
            return (int) Math.pow(3, n / 3);
        if (n % 3 == 1)
            return (int) Math.pow(3, n / 3 - 1) * 4;
        // if (n % 3 == 2)
        return (int) Math.pow(3, n / 3) * 2;

    }
}
