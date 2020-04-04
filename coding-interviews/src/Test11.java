import java.util.Scanner;

/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class Test11 {
    /**
     * ����һ  n�������� �� ֱ�ӳ�Ϊ�˶�����
     * ����flag=1 �� n���������㣬���ҵ����Դ˽��У�ֱ��flagΪ����� ������21�ھ͹��� ����ѭ��
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;  // ͳ��1�ĸ���
        int flag = 1;    // ����������
        while (flag != 0) {
            if ((n&flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // ������ (�Ƽ�)
    public static int NumberOf12(int n){
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();

            System.out.println(NumberOf1(n));
        }
    }
}
