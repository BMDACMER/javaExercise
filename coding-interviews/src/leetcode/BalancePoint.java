package leetcode;

/**
 * 输入一个列表，例如【3，8，1，5，7，4，1】 在列表中，有那么一些位置的数，他左右两边的合是相等的，叫平衡数。
 * 本例中 的平衡数是5，请输出列表中所有的平衡数。
 */
public class BalancePoint {

    private int countPoint;   // 统计平衡点的个数
    private int leftCount = 0;
    private int rightCount = 0;
    private static int[] display = new int[100];
    private static int displayIndex = 0;

    // 数组左边的和
    private int getLeftCount(int[] arr, int index) {
        if (index == 0) return 0;  // 第一个元素的左遍和为0   因为没有元素
        int count = 0;
        for (int i = 0; i < index; i++) {
            count += arr[i];
        }
        return count;
    }

    // 数组右边的和
    private int getRightCount(int[] arr, int index) {
        if (index + 1 == arr.length) return 0;   // 该元素为数组最右边的元素，此时右遍没有元素了
        int count = 0;
        for (int i = index + 1; i < arr.length; i++) {
            count += arr[i];
        }
        return count;
    }

    // 方法一  暴力法
    public int getBalancePoint(int[] arr) {
        if (arr.length < 2) return 1;   // 当数组长度为0或者只有一个元素可以假定为平衡数位1

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

    // 展示平衡点个数
    private static void printPoint(int[] display) {
        for (int i = 0; i < displayIndex; i++) {
            System.out.print(display[i] + "\t");
        }
    }


    // 方法二 先计算出除首位置外的右遍所有元素的和，然后从左往右依次遍历数组的同时左边加上元素，右遍减去元素
    public int getBalancePoint2(int[] arr) {
        int equipPoint = 0;    // 假设平衡点下标为0
        for (int i = 1; i < arr.length; i++) {
            rightCount += arr[i];
        }

        if (leftCount == rightCount) return equipPoint;

        for (equipPoint = 1; equipPoint < arr.length; equipPoint++) {
            leftCount += arr[equipPoint - 1];   //新的左和为原来左和加平衡点左边的元素.
            rightCount -= arr[equipPoint];   //新的右和为原来的右和减支平衡点的元素
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
        //方法一：时间复杂度高 O(n2)
        BalancePoint test1 = new BalancePoint();

//        System.out.println("平衡点个数为" + test1.getBalancePoint(array));
        // 方法二：时间复杂度为O(n)
        System.out.println("平衡点个数为" + test1.getBalancePoint2(array));

        System.out.print("平衡点为：");
        printPoint(display);

    }
}
