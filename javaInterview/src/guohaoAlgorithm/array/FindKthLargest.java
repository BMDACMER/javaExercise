package guohaoAlgorithm.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/20 10:00
 *
 * 215. �����еĵ�K�����Ԫ��
 * �ο���https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 */
public class FindKthLargest {

    /*// ����һ��   ���仮�ַ�
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;  // ��k��Ԫ�ص��±�Ϊlen - k

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            }else if (index > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
    }


    private int partition(int[] nums, int left, int right) {
        if (left < right) {
            int randomIndex = left + 1 + new Random().nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }

        // ��֮ǰ�����Ĺ����У����� [left + 1, j] < pivot������ (j, i] >= pivot
        swap(nums, j, left);
        // �����Ժ� [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }*/


    // �����������ȶ���
    public int findKthLargest(int[] nums, int k) {
        // С����
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,(a,b)-> a-b);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        int tmp;
        for (int i = k; i < nums.length; i++) {
            tmp = queue.peek();
            // ֻҪ��ǰ������Ԫ�رȶѶ�Ԫ�ش󣬶Ѷ�������������Ԫ�ؽ�ȥ
            if (tmp < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
