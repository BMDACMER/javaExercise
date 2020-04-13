package codeguiide;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeCounterGenerator;

import javax.swing.*;
import java.util.Scanner;
import java.util.Stack;

// 汉诺塔（不允许从最左边的塔移到最右边，也不能从最右边直接译到最左边，而是必须经过中间。求当塔有N层的时候，
// 打印最优移动过程和最有解
public class Problem_0106_HanoiStack {
    private static int count = 0;
    // 递归调用
    public static int hanoiProblem1(int num, String left, String mid,
                                    String right){

        if (num == 1) {
            System.out.println(left + " ---> " + mid);
            System.out.println(mid + " ---> " + right);
            count += 2;
        } else {
            hanoiProblem1(num-1,left,mid,right);
            System.out.println(left + " ---> " + mid);
            count += 1;
            hanoiProblem1(num-1, right, mid, left);
            System.out.println(mid + " ---> " + right);
            count += 1;
            hanoiProblem1(num-1,left,mid,right);
        }
        return count;
    }

    public static enum Action {
        No, LToM, MToL, MToR, RToM
    }
    // 非递归
    public static int hanoiProblem2(int num, String left, String mid, String right) {
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            ls.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rs.size() != num + 1) {
            step += fStackTotStack(record,Action.MToL, Action.LToM, ls, ms, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, ms, ls, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, ms, rs, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rs, ms, right, mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack,
                                     Stack<Integer> tStack, String from, String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println(hanoiProblem1(num, "left","mid","right"));

        // solution 2
        int steps2 = hanoiProblem2(num, "left", "mid", "right");
        System.out.println("It will move " + steps2 + " steps.");
    }
}
