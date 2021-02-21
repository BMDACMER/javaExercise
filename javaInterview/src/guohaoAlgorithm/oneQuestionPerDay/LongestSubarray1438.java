package guohaoAlgorithm.oneQuestionPerDay;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @Author guohao
 * @Date 2021/2/21 9:36
 * @Version 1.0
 *
 * 1438. ���Բ�������Ƶ������������
 * ����һ���������� nums ����һ����ʾ���Ƶ����� limit�����㷵�������������ĳ��ȣ����������е���������Ԫ��֮��ľ��Բ����С�ڻ��ߵ��� limit ��
 *
 * ������������������������飬�򷵻� 0 ��
 *
 * ʾ�� 1��
 *
 * ���룺nums = [8,2,4,7], limit = 4
 * �����2
 * ���ͣ��������������£�
 * [8] �����Բ� |8-8| = 0 <= 4.
 * [8,2] �����Բ� |8-2| = 6 > 4.
 * [8,2,4] �����Բ� |8-2| = 6 > 4.
 * [8,2,4,7] �����Բ� |8-2| = 6 > 4.
 * [2] �����Բ� |2-2| = 0 <= 4.
 * [2,4] �����Բ� |2-4| = 2 <= 4.
 * [2,4,7] �����Բ� |2-7| = 5 > 4.
 * [4] �����Բ� |4-4| = 0 <= 4.
 * [4,7] �����Բ� |4-7| = 3 <= 4.
 * [7] �����Բ� |7-7| = 0 <= 4.
 * ��ˣ�����������������ĳ���Ϊ 2 ��
 */
public class LongestSubarray1438 {

    // �����㷨   ��ʱ   56 / 60 ��ͨ����������
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, maxLen, ans = 0;
        for (int i = 0; i < n; i++) {
            maxLen = 0;
            int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                // �������¼��Сֵ�����ֵ
                maxValue = Math.max(maxValue, nums[j]);
                minValue = Math.min(minValue, nums[j]);
                if (Math.abs(maxValue - minValue) > limit) break;
                maxLen++;
            }
            ans = Math.max(ans, maxLen);
        }
        return ans;
    }

    // ��������   �Ż��㷨  TreeMap ---- 32.66% + 34.08%
    public int longestSubarray2(int[] nums, int limit) {
        int n = nums.length;
        int left = 0, right = 0, ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            right++;
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    // ��������   ˫�˶���   93.43%+64.25%
    public int longestSubarray3(int[] nums, int limit) {
        int n = nums.length;
        LinkedList<Integer> maxV = new LinkedList<>();
        LinkedList<Integer> minV = new LinkedList<>();
        int left = 0, right = 0, ans = 0;
        while (right < n) {
            while (!maxV.isEmpty() && maxV.peekLast() < nums[right]) {
                maxV.pollLast();
            }
            while (!minV.isEmpty() && minV.peekLast() > nums[right]) {
                minV.pollLast();
            }
            maxV.offerLast(nums[right]);
            minV.offerLast(nums[right]);
            right++;
            while (!maxV.isEmpty() && !minV.isEmpty() && Math.abs(maxV.peekFirst() - minV.peekFirst()) > limit) {
                if (nums[left] == minV.peekFirst()) {
                    minV.pollFirst();
                }
                if (nums[left] == maxV.peekFirst()) {
                    maxV.pollFirst();
                }
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubarray1438 test = new LongestSubarray1438();
//        int[] nums = {1,5,6,7,8,10,6,5,6};
        int[] nums = {8,2,4,7};
        System.out.println(test.longestSubarray2(nums, 4));
    }
}
