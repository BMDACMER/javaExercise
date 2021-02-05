package guohaoAlgorithm.slidingwindow;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/3 8:41
 *
 * 480. ����������λ��
 * ��λ���������������м���Ǹ�����������еĴ�С��ż������û�����м��������ʱ��λ�������м����������ƽ������
 *
 * ���磺
 *
 * [2,3,4]����λ���� 3
 * [2,3]����λ���� (2 + 3) / 2 = 2.5
 * ����һ������ nums����һ����СΪ k �Ĵ��ڴ�����˻��������Ҷˡ��������� k ������ÿ�δ��������ƶ� 1 λ������������ҳ�ÿ�δ����ƶ���õ����´�����Ԫ�ص���λ�����������������ɵ����顣
 *
 *
 *
 * ʾ����
 *
 * ���� nums = [1,3,-1,-3,5,3,6,7]���Լ� k = 3��
 *
 * ����λ��                      ��λ��
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  ��ˣ����ظû������ڵ���λ������ [1,-1,-1,3,5,6]��
 */
public class MedianSlidingWindow {

    /**
     * ˫ָ��+�������� + ��������   �ᳬʱ
     * @param
     * @param
     * @return
     */
    /*public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new double[]{};

       MonotonicQueue window = new MonotonicQueue();
       int n = nums.length;
       double[] ans = new double[n - k + 1];
       int index = 0;

        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                // �ȰѴ��ڵ�ǰ k - 1 ����
                window.push(nums[i]);
            } else {
                // ���ڿ�ʼ��ǰ�ƶ����Ƴ���Ԫ��
                window.push(nums[i]);
                // �����ڵ���λ�� ��¼�ڽ����
                ans[index++] = window.medium();
                // �Ƴ�����Ԫ��
                window.pop(nums[i - k + 1]);
            }
        }

        return ans;
    }*/

    // �����㷨 ֱ��sort
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        int[] window = new int[k];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < k; j++) {
                window[j] = nums[i + j];
            }
            Arrays.sort(window);
            if (k % 2 == 1) {
                ans[i] = window[k/2];
            }else {
                ans[i] = ((double)window[k/2 - 1] + (double) window[k/2] ) / 2.0;
            }
        }
        return ans;
    }

    // ����88%�Ľⷨ  �ο���https://leetcode-cn.com/problems/sliding-window-median/
    public double[] medianSlidingWindow2(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        //��ӳ�ʼֵ
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        //��ʼ�Ŀ��ţ�����дֱ�ӵ���
        Arrays.sort(window);
        res[0] = getMid(window);
        //���ڻ���
        for (int i = 0; i < nums.length - k; i++) {
            //��Ҫɾ������
            int index = search(window, nums[i]);
            //�滻Ϊ��Ҫ�������
            window[index] = nums[i + k];
            //���ð��  �滻���index  ����Ⱥ���Ĵ� ������³�
            while (index < window.length - 1 && window[index] > window[index + 1]) {
                swap(window, index, index + 1);
                index++;
            }
            //��ǰð��   �����ǰ���С ����ǰ�³�
            while (index > 0 && window[index] < window[index - 1]) {
                swap(window, index, index - 1);
                index--;
            }
            res[i + 1] = getMid(window);
        }
        return res;
    }

    //����
    private void swap(int[] window, int i, int j) {
        int temp = window[i];
        window[i] = window[j];
        window[j] = temp;
    }

    //���������λ��
    private double getMid(int[] window) {
        int len = window.length;
        if (window.length % 2 == 0) {
            //�������
            return window[len / 2] / 2.0 + window[len / 2 - 1] / 2.0;
        } else {
            return window[len / 2];
        }
    }

    //��򵥵Ķ��ֲ���
    private int search(int[] window, int target) {
        int start = 0;
        int end = window.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (window[mid] > target) {
                end = mid - 1;
            } else if (window[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MedianSlidingWindow m = new MedianSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        double[] window = m.medianSlidingWindow(nums, 3);
        for (int i = 0; i < window.length; i++) {
            System.out.print(window[i] + " ");
        }
    }
}

/*
class MonotonicQueue {
    LinkedList<Integer> q = new LinkedList<>();

    // �ڶ�β���Ԫ�� n  ʼ�ձ��ִ�������
    void push(int n){
        // Ϊ�˱��ִ���Ԫ�ص������� ��������
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty() && q.peekLast() > n) {
            stack.push(q.pollLast());
        }
        // ����ǰԪ�ش�ŵ�������
        q.addLast(n);
        // ��ջ�е�Ԫ�طŵ�������
        while (!stack.isEmpty()) {
            q.addLast(stack.pop());
        }
    }

    // ������λ��
    double medium() {
        // ���ص���λ�� ��Ҫ�����������������ż��
        int n = q.size();
        if (n % 2 == 1) {
            return q.get(n / 2 ); // ���� 5/2 + 1 = 3   �±��0��ʼ �൱��2
        }else {
            return q.get(n/2 - 1) + (q.get(n/2) - q.get(n / 2 - 1)) / 2.0;
        }
    }

    // �Ƴ�����ͷԪ��
    void pop(int n) {
        for (int i = 0; i < q.size(); i++) {
            if (q.get(i).equals(n)) {
                q.remove(i);
                return;
            }
        }
    }
}
*/
