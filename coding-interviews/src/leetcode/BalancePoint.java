package leetcode;

/**
 * ����һ���б����硾3��8��1��5��7��4��1�� ���б��У�����ôһЩλ�õ��������������ߵĺ�����ȵģ���ƽ������
 * ������ ��ƽ������5��������б������е�ƽ������
 */
public class BalancePoint {

    private int countPoint;   // ͳ��ƽ���ĸ���
    private int leftCount = 0;
    private int rightCount = 0;
    private static int[] display = new int[100];
    private static int displayIndex = 0;

    // ������ߵĺ�
    private int getLeftCount(int[] arr, int index) {
        if (index == 0) return 0;  // ��һ��Ԫ�ص�����Ϊ0   ��Ϊû��Ԫ��
        int count = 0;
        for (int i = 0; i < index; i++) {
            count += arr[i];
        }
        return count;
    }

    // �����ұߵĺ�
    private int getRightCount(int[] arr, int index) {
        if (index + 1 == arr.length) return 0;   // ��Ԫ��Ϊ�������ұߵ�Ԫ�أ���ʱ�ұ�û��Ԫ����
        int count = 0;
        for (int i = index + 1; i < arr.length; i++) {
            count += arr[i];
        }
        return count;
    }

    // ����һ  ������
    public int getBalancePoint(int[] arr) {
        if (arr.length < 2) return 1;   // �����鳤��Ϊ0����ֻ��һ��Ԫ�ؿ��Լٶ�Ϊƽ����λ1

        for (int i = 0; i < arr.length; i++) {
            leftCount = getLeftCount(arr, i);
            rightCount = getRightCount(arr, i);
            if (leftCount == rightCount) {
                countPoint++;
                display[displayIndex++] = arr[i];
            }
        }
        return countPoint;
    }

    // չʾƽ������
    private static void printPoint(int[] display) {
        for (int i = 0; i < displayIndex; i++) {
            System.out.print(display[i] + "\t");
        }
    }


    // ������ �ȼ��������λ������ұ�����Ԫ�صĺͣ�Ȼ������������α��������ͬʱ��߼���Ԫ�أ��ұ��ȥԪ��
    public int getBalancePoint2(int[] arr) {
        int equipPoint = 0;    // ����ƽ����±�Ϊ0
        for (int i = 1; i < arr.length; i++) {
            rightCount += arr[i];
        }

        if (leftCount == rightCount) return equipPoint;

        for (equipPoint = 1; equipPoint < arr.length; equipPoint++) {
            leftCount += arr[equipPoint - 1];   //�µ����Ϊԭ����ͼ�ƽ�����ߵ�Ԫ��.
            rightCount -= arr[equipPoint];   //�µ��Һ�Ϊԭ�����Һͼ�֧ƽ����Ԫ��
            if (leftCount == rightCount) {
                countPoint++;
                display[displayIndex++] = arr[equipPoint];
            }
        }
        return countPoint;
    }

    public static void main(String[] args) {
//        int[] array = new int[]{3,8,1,5,7,4,1};
        int[] array = new int[]{-7, 1, 5, 2, -4, 3, 0};
        //����һ��ʱ�临�Ӷȸ� O(n2)
        BalancePoint test1 = new BalancePoint();

//        System.out.println("ƽ������Ϊ" + test1.getBalancePoint(array));
        // ��������ʱ�临�Ӷ�ΪO(n)
        System.out.println("ƽ������Ϊ" + test1.getBalancePoint2(array));

        System.out.print("ƽ���Ϊ��");
        printPoint(display);

    }
}
