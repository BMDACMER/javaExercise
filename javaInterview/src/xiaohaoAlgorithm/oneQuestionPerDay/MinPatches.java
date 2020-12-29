package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/29 9:10
 *
 * 330. ��Ҫ��������
 */
public class MinPatches {

    /**
     * ˼·����ͳ�ƴ� nums�е��������֣������hashset�У�Ȼ�����ȡ����ϵó������ŵ�hashset�У�
     * �ڱ���[1,n]֮��δ���ֵ����֣���С������ʣ�����hashset�У����¼�����������ʣ�µ�[1,n]֮������Ա�
     * ����[1,n]֮��ʣ�µ���Ҳ�ŵ�hashset�У����ڿ��ٷ��ʣ������ͳ����С����
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        // �쳣����
        if (nums.length >= n) return 0;

        Set<Long> visited = new HashSet<>(); // ���nums������
        Queue<Long> notVisited = new ArrayDeque<>();  // ��� ������nums��Ԫ����ϵõ�������

        int minCount = 0; // ������Ҫ���������
        for (int num : nums) {
            visited.add((long) num);
        }


        // ���nums�����е�����
        for (int i = 0; i < nums.length; i++) {
            long tmp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                tmp += nums[j];
                if (!visited.contains(tmp)) {
                    visited.add(tmp);
                }
            }
        }

        // �жϲ���nums�����е�Ԫ�� ��ʣ����
        for (long i = 1; i <= n; i++) {
            if (!visited.contains(i))
                notVisited.add(i);
        }

        // ͳ����Ҫ��ӵ����ٴ���
        while (!notVisited.isEmpty()) {
            long num = notVisited.poll();
            // ע��  notVisited�������Ԫ�������, ��Ŀ��˵���ź��������

            if (!visited.contains(num)) {
                visited.add(num);
                minCount++;
                // ����Ԫ�������¼�����ֵ ���¼��뵽 visited������
                Long[] visitedArr = new Long[visited.size()];
                visited.toArray(visitedArr);

                for (int i = 0; i < visitedArr.length; i++) {
                    long tmp = visitedArr[i];
                    for (int j = i + 1; j < visitedArr.length; j++) {
                        tmp += visitedArr[j];
                        if (tmp <= n && !visited.contains(tmp)) {
                            visited.add(tmp);
                        }
                    }
                }
            }

        }

        return minCount;
    }

    /**
     * ����������Ч�㷨
     * �ο���https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
     *
     */
    public int minPatches2(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        MinPatches m = new MinPatches();
        int[] nums = {1,2,31,33};
        int n = 2147483647;  // 2^31 - 1
        System.out.println(m.minPatches2(nums,n));
    }
}
