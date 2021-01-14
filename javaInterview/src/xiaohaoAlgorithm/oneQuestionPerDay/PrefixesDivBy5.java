package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/14 11:18
 *
 * 1018. 可被 5 整除的二进制前缀
 */
public class PrefixesDivBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        int n = A.length;
        List<Boolean> list = new ArrayList<>(n);
        int tmp = 0;

        for (int i = 0; i < n; i++) {
            tmp = ((tmp<<1) + A[i]) % 5;
            list.add(tmp == 0);
        }
        return list;
    }
}
