package lintcode.offer;
// 33. �����������ĺ����������
public class Test55 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return helpVerifySequemceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean helpVerifySequemceOfBST(int[] sequence, int start, int root) {
        // ��������
        if (start >= root) return true;

        int end = sequence[root];   // �������������һ�����Ϊ���ڵ�

        int i;
        for (i = start; i < root; i++) {
            if (sequence[i] > end)
                break;    // �ҵ����������ĵ�һ�����
        }

        // �����������ж��Ƿ����С��end��ֵ������з���false��
        for (int j = i; j < root; j++) {
            if (sequence[j] < end)
                return false;
        }

        return helpVerifySequemceOfBST(sequence, start, i-1) && helpVerifySequemceOfBST(sequence, i, root - 1);
    }
}
