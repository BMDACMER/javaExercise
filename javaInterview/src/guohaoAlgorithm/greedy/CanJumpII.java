package guohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 22:24
 *
 * 45. ��Ծ��Ϸ II
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
 *
 * ʾ��:
 *
 * ����: [2,3,1,1,4]
 * ���: 2
 * ����: �������һ��λ�õ���С��Ծ���� 2��
 *      ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
 */
public class CanJumpII {

    public int jump(int[] nums) {
        int n = nums.length;
        int count = 0;
        int farthest = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (end == i) {
                count++;
                end = farthest;
            }
        }
        return count;
    }
}
