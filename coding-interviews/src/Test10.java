import java.util.Scanner;

/**
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 *
 * 쳲���������
 */
public class Test10 {
    public static int RectCover(int target) {

        // �쳣����
        if (target < 1){
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }

    //������
    public static int RectCover2(int target) {

        int a = 1, b = 2, c = 0;
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            for (int i = 3; i <= target; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            n = sc.nextInt();
            System.out.println(RectCover(n));
//            System.out.println(RectCover2(n));
        }
    }
}
