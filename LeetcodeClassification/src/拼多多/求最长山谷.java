package 拼多多;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 14:11
 */
public class 求最长山谷 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 2, 3, 4, 1};
        求最长山谷 m = new 求最长山谷();
        System.out.println(m.longestMountain(nums));
    }

    public int longestMountain(int[] A) {
        int cnt = 0;
        int l, r;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                l = i - 1;
                r = i + 1;
                while (l >= 1 && A[l] > A[l - 1]) l--;
                while (r < A.length - 1 && A[r] > A[r + 1]) r++;
                cnt = Math.max(cnt, r - l + 1);
            }
        }
        return cnt;
    }
}
