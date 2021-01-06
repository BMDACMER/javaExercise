package xiaohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 14:23
 *
 * 55. ��Ծ��Ϸ
 */
public class JumpI {

    /**
     * ̰���㷨
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int farthest = 0;  // �������ԭ��ľ���
        for (int i = 0; i < nums.length - 1; i++) {
            // ���ϼ�������������Զ����
            farthest = Math.max(farthest, nums[i] + i);
            // ����������0����ס��������
            if (farthest <= i) return false;
        }
        return farthest >= nums.length - 1;
    }
}
