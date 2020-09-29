package 牛客网.算法初级班;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/28 18:06
 */
public class SmallSum {
    /*public static void main(String[] args) {
        int [] a= {11,223,3,45,678,5,455,32};
        int nums=32;
        int x=-1;//标记小于区域,让后面小于的和小于区域的下一个位置交换，小于区域++
        //如果第一个位置是小于，其实就是和自己交换，i一定永远大于等于x
        for(int i=0;i<a.length;i++) {
            if(a[i]<=nums) {
                int temp=a[i];
                a[i]=a[x+1];
                a[x+1]=temp;
                x++;
            }
        }
        for(int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
    }*/

    // 小和问题
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if (l == r)
            return 0;
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l, p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 拷贝回去
        for (i = 0; i < help.length; ++i) {
            arr[l + i] = help[i];
        }
        return res;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Util.generatorRandomArray(maxSize, maxValue);
            int[] arr2 = Util.copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                Util.printArray(arr1);
                Util.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
