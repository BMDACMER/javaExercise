package guohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 22:23
 *
 * 55. ��Ծ��Ϸ
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * �ж����Ƿ��ܹ��������һ��λ�á�
 *
 * ʾ�� 1:
 *
 * ����: [2,3,1,1,4]
 * ���: true
 * ����: ���ǿ������� 1 ������λ�� 0 ���� λ�� 1, Ȼ���ٴ�λ�� 1 �� 3 ���������һ��λ�á�
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int farthest = 0;  // �������ԭ��ľ���
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (farthest <= i) return false;
        }
        return farthest >= nums.length - 1;
    }
}
