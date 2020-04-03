import java.util.Scanner;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 *
 * ����ĵݹ�
 * ��ʵ����쳲���������
 *
 * ���ڱ���,ǰ��ֻ�� һ�� 1�׻���2�׵�������

 a.�������������1�׻���2�ף���ô�ٶ���һ��������һ�ף���ôʣ�µ���n-1��̨�ף�������f(n-1);

 b.�ٶ���һ��������2�ף���ôʣ�µ���n-2��̨�ף�������f(n-2)

 c.��a\b������Եó�������Ϊ: f(n) = f(n-1) + f(n-2)

 d.Ȼ��ͨ��ʵ�ʵ�������Եó���ֻ��һ�׵�ʱ�� f(1) = 1 ,ֻ�����׵�ʱ������� f(2) = 2

 e.���Է������յó�����һ��쳲���������
 */
public class Test08 {
    // ����һ���ݹ�
    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    // ������
    public static int JumpFloor2(int target) {
        int a = 1, b = 2, c = 0;
        if (target == 1) {
            return 1;
        }else if (target == 2) {
            return 2;
        }else {
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
//            System.out.println(JumpFloor(n));
            System.out.println(JumpFloor2(n));
        }
    }
}
