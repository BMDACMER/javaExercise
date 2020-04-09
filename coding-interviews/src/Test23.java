public class Test23 {

    public boolean helpVerify(int [] sequence, int start, int root){
        if (start >= root) return true;  // 满足条件的

        int key = sequence[root];   // 根结点
        int i = start;
        while (sequence[i] < key) {
            i++;
        }
        int j = i;   // 找到比根节点大的数
        // 判断右子树是否满足
        while (sequence[j] > key && j < root) {
            j++;
        }
        if (j < root - 1) {
            return false;   // 如果不满足就返回   正常应该是 j = root-1
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
