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
        // ��A�ϵ�����Ϊ��ʱ ֹͣ�ݹ�
        if (n < 1) return;

        // ��a�ϵ�n-1�������Ƶ�b��  ����C
        solve(n-1,A,C,B);
        // ��a�����������Ƶ�C��  ����B
        C.add(A.remove(A.size() - 1));
        // ��B�ϵ������Ƶ�C�� ����A
        solve(n - 1,B,A,C);
    }
}
