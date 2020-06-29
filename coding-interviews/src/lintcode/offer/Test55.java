package lintcode.offer;
// 33. 二叉搜索树的后序遍历序列
public class Test55 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return helpVerifySequemceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean helpVerifySequemceOfBST(int[] sequence, int start, int root) {
        // 跳出条件
        if (start >= root) return true;

        int end = sequence[root];   // 后续遍历的最后一个结点为根节点

        int i;
        for (i = start; i < root; i++) {
            if (sequence[i] > end)
                break;    // 找到了右子树的第一个结点
        }

        // 在右子树中判断是否存在小于end的值，如果有返回false；
        for (int j = i; j < root; j++) {
            if (sequence[j] < end)
                return false;
        }

        return helpVerifySequemceOfBST(sequence, start, i-1) && helpVerifySequemceOfBST(sequence, i, root - 1);
    }
}
