package guohaoAlgorithm.nowcoder.bytedance;

import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/3/5 16:55
 * @Version 1.0
 *
 * �ο���https://www.nowcoder.com/practice/944e5ca0ea88471fbfa73061ebe95728?tpId=137&tqId=33900&rp=1&ru=%2Fta%2Fexam-bytedance&qru=%2Fta%2Fexam-bytedance%2Fquestion-ranking&tab=answerKey
 */
public class ZJ23 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ans = 0;
        n = 1024 - n;
        // ��ֵ64��Ӳ��
        int n64 = n / 64;
        n -= n64 * 64;
        // ��ֵ16��Ӳ��
        int n16 = n / 16;
        n -= n16 * 16;
        // ��ֵ4��Ӳ��
        int n4 = n / 4;
        n -= n4 * 4;
        // ��ֵ1��Ӳ��
        int n1 = n;

        ans = n64 + n16 + n4 + n1;
        System.out.println(ans);
    }
}
