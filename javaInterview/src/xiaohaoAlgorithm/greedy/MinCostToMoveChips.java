package xiaohaoAlgorithm.greedy;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 14:06
 *
 * 1217. �����
 */
public class MinCostToMoveChips {

    /**
     * ����Զ� �κγ��� ִ���������ֲ���֮һ�����޲���������0 ��Ҳ���ԣ���
     *   ���� i ����������������ƶ� 2 ����λ������Ϊ 0��
     *   ���� i ����������������ƶ� 1 ����λ������Ϊ 1��
     *   �ο���
     *https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position/solution/yong-tan-xin-si-xiang-lai-zhao-gui-lu-chao-xiang-x/
     * @param position
     * @return
     */
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if ((position[i] & 1) == 0) even++;
            else odd++;
        }
        return even > odd ? odd :even;
    }
}
