package guohaoAlgorithm.bitoperation;

/**
 * @Author guohao
 * @Date 2021/3/10 9:41
 * @Version 1.0
 *
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        ans = Integer.bitCount(x ^ y);
        return ans;
    }

    // 方法二：右移
    public int hammingDistance2(int x, int y) {
        int distance = 0;
        int xor = x ^ y;
        while (xor != 0) {
            if ((xor&1) == 1) {
                distance++;
            }
            xor>>=1;
        }
        return distance;
    }

    public static void main(String[] args) {
        HammingDistance h = new HammingDistance();
        System.out.println(h.hammingDistance2(2,4));
    }
}
