package ̰���㷨;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 10:33
 * 944 ɾ������
 *
 */
public class ɾ������ {
    /**
     * ˼·������ÿһ�У����Ǽ�����Ƿ�������ġ�����������򽫴����� 1�����������뱻ɾ����
     *
     * ʱ�临�Ӷȣ�O(N)O(N)������ NN ������ A �е�Ԫ�ظ�����
     *
     * �ռ临�Ӷȣ�O(1)O(1)��
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        int res = 0;
        int col = A[0].length();
        int row = A.length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row - 1; j++) {
                if (A[j].charAt(i) - A[j + 1].charAt(i) > 0) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
