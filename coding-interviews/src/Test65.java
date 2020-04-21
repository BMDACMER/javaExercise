import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *  滑动窗口的最大值
 */
public class Test65 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size > num.length || size < 1 || num.length < 1) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);   // 大顶堆

        for (int i = 0; i < size; i++) {
            queue.add(num[i]);
        }
        res.add(queue.peek());

        for (int i = 1, j = size + i - 1; j < num.length; i++,j++) {
            queue.remove(num[i-1]);
            queue.add(num[j]);
            res.add(queue.peek());
        }
        return res;

    }

    // 效果更好
    public ArrayList<Integer> maxInWindows2(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        if (size > num.length || size < 1 || num.length < 1) {
            return res;
        }
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] <= num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            if (i >= size - 1) {
                res.add(num[qmax.peekFirst()]);
            }
        }
        return res;
    }
}
