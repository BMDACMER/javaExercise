package guohaoAlgorithm.acm.baseAlgorithm_01;

import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 17:49
 */
public class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        solve(n,A,B,C);
    }

    private void solve(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        // 当A上的盘子为空时 停止递归
        if (n < 1) return;

        // 将a上的n-1个盘子移到b上  借助C
        solve(n-1,A,C,B);
        // 将a上最大的盘子移到C上  借助B
        C.add(A.remove(A.size() - 1));
        // 将B上的盘子移到C上 借助A
        solve(n - 1,B,A,C);
    }
}
