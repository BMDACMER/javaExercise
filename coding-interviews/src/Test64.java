import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 *如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Test64 {

    // 大顶堆  存储左半边元素
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2-o1);   // 相当于逆序
    // 小顶堆，存储右半边元素，并且右半边元素都大于左半边
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N = 0;    // 当前数据流元素的个数

    public void Insert(Integer num) {
        if (N % 2 == 0) {
            left.add(num);        // 左区间  大顶堆   降序
        } else {
            right.add(num);   // 右区间  小顶堆   升序
        }
        //放入的数据可能出现 左区间的数大于有区间的数 需要如下操作
        if (!right.isEmpty() && left.peek() > right.peek()) {
            int temp1 = left.poll();
            int temp2 = right.poll();
            left.add(temp2);
            right.add(temp1);
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) left.peek();
        }
    }

}
