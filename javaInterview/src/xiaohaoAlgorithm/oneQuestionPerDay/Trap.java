package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/26 16:35
 * 42. ����ˮ
 */
public class Trap {
    /**
     * ��̬�滮�㷨
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] heightLeft = new int[height.length];  // ��¼��ǰ�������ߵ�ǽ
        int[] heightRight = new int[height.length];  // ��¼��ǰ���ұ���ߵ�ǽ
        int result = 0;
        // ��¼��ǰ�������ߵ�ǽ
        for (int i = 1; i < heightLeft.length - 1; i++) {
            heightLeft[i] = Math.max(heightLeft[i - 1], height[i - 1]);
        }
        // ��¼��ǰ���ұ���ߵ�ǽ
        for (int i = heightRight.length - 2; i > 0; i--) {
            heightRight[i] = Math.max(heightRight[i + 1], height[i + 1]);
        }

        // �Ƚϵ�ǰ������ǽ��С�ĸ߶�
        for (int i = 1; i < height.length - 1; i++) {
            int dpHeight = Math.min(heightLeft[i], heightRight[i]);
            // ��ǰ�߶�С�� ����ǽ����С�߶ȣ����Լ������ǰ������ʢ�µ�ˮ������
            if (height[i] < dpHeight) {
                result += dpHeight - height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Trap t = new Trap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trap(height));
    }
}
