package xiaohaoAlgorithm.math;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 22:56
 * <p>
 * 204. 计数质数
 */
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i])
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }
        return count;
    }
}
