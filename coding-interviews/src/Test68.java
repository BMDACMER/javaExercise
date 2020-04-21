import java.math.BigInteger;

/**
 * ������
 *
 * ����һ������Ϊn�����ӣ�������Ӽ�����������m�Σ�m��n����������n>1����m>1����ÿ�����ӵĳ��ȼ�Ϊk[0],k[1],...,k[m]��
 * ����k[0]xk[1]x...xk[m]���ܵ����˻��Ƕ��٣�
 * ���磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
 */
public class Test68 {
    /*
    // �ݹ�
    public int cutRope(int target) {
        if (target < 2)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;

        return cutRopeHelp(target);
    }

    private int cutRopeHelp(int target) {
        if (target < 4) {
            return target;
        }
        int max = 0;
        for (int i = 1; i < target/2+1; i++) {
            max = Math.max(cutRopeHelp(i) * cutRopeHelp(target - i),max);
        }
        return max;
    }
    */

    // �ǵݹ�
    public int cutRope(int target) {
        if (target < 2)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;

        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i/2; j++) {
                max = Math.max((dp[j] * dp[i - j]),max);
            }
            dp[i] = max;
        }
        return dp[target];
    }
}
