package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/1 0:06
 *
 * 605. �ֻ�����
 */
public class CanPlaceFlowers {

    /**
     * ˼·���������Ҹ�����һ��0������  arr[i-1] == 0 && arr[i] == 1 && arr[i+1] == 0 ������ֲ�����α�������
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length < n) return false;

        int[] arr = new int[flowerbed.length + 2];
        arr[0] = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = flowerbed[i - 1];
        }
        arr[arr.length - 1] = 0;

        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] == 0 && arr[i] == 0 && arr[i + 1] == 0) {
                count++;
                arr[i] = 1;
            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlowers c = new CanPlaceFlowers();
        int[] nums = {1,0,0,0,0,1};
        System.out.println(c.canPlaceFlowers(nums,2));
    }
}
