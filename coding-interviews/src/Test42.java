import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Test42 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // 采用动态窗口方式，设置窗口两边指针分别为pLeft,pRight 由于是等差为1的等差数列
        // 所以 （pLeft + pRight）* n / 2 为窗口内的值   判断是否为sum
        // < sum  pRgiht++
        // > sum  pLeft++
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int pLeft = 1, pRight = 2;
        while (pRight > pLeft) {
            int s = (pLeft + pRight) * (pRight - pLeft + 1) / 2;
            if (s == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = pLeft; i <= pRight; i++) {
                    list.add(i);
                }
                lists.add(list);
                pLeft++;
            } else if (s < sum) {
                pRight++;
            } else {
                pLeft++;
            }
        }
        return lists;
    }
}
