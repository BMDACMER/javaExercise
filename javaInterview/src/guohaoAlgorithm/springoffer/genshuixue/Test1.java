package guohaoAlgorithm.springoffer.genshuixue;

import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/2/28 18:50
 * @Version 1.0
 *
 * �����еĺ�
 *
 * ���������֪�����ο��𰸣�
 *
 * ʱ�����ƣ� 4000MS
 * �ڴ����ƣ� 557056KB
 * ��Ŀ������
 * ���еĶ������£� ���еĵ�һ��Ϊn���Ժ����Ϊǰһ���ƽ�����������е�ǰm��ĺ͡�
 *
 * ��������
 * ���������ж��飬ÿ��ռһ�У�����������n��n<10000����m(m<1000)��ɣ�n��m�ĺ�����ǰ������
 *
 * �������
 * ����ÿ���������ݣ���������еĺͣ�ÿ������ʵ��ռһ�У�Ҫ�󾫶ȱ���2λС����
 *
 *
 * ��������
 * 81 4
 * 2 2
 *
 * �������
 * 94.73
 * 3.41
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n, m;
            n = scan.nextInt();
            m = scan.nextInt();
            double sum = 0, temp = n;
            for (int i = 0; i < m; i++) {
                sum += temp;
                temp = Math.sqrt(temp);
            }
            System.out.print(String.format("%.2f", sum));
        }
    }
}
