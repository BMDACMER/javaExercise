public class Test23 {

    public boolean helpVerify(int [] sequence, int start, int root){
        if (start >= root) return true;  // ����������

        int key = sequence[root];   // �����
        int i = start;
        while (sequence[i] < key) {
            i++;
        }
        int j = i;   // �ҵ��ȸ��ڵ�����
        // �ж��������Ƿ�����
        while (sequence[j] > key && j < root) {
            j++;
        }
        if (j < root - 1) {
            return false;   // ���������ͷ���   ����Ӧ���� j = root-1
        }
        return helpVerify(sequence, start, i-1) && helpVerify(sequence, i, root - 1);
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return helpVerify(sequence,0,sequence.length-1);
    }
}
