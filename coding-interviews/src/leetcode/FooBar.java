package leetcode;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

// 1115. �����ӡFooBar      https://leetcode-cn.com/problems/print-foobar-alternately/
public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private BlockingDeque deque = new LinkedBlockingDeque(1);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            deque.push(i);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            deque.push(i);
            deque.push(i);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            deque.take();
            deque.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            deque.take();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        FooBar t = new FooBar(20);
        Thread foo = new Thread(() -> {
            try {
                t.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        foo.setDaemon(false);
        foo.start();

        Thread bar = new Thread(() -> {
            try {
                t.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        bar.setDaemon(false);
        bar.start();

//        ���ߣ�fuxue-9
//        ���ӣ�https://leetcode-cn.com/problems/print-foobar-alternately/solution/java-shi-yong-zu-sai-dui-lie-lai-kong-zhi-by-fuxue/
//        ��Դ�����ۣ�LeetCode��
//        ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
    }
}
