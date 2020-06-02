package leetcode;

// 1115. ½»Ìæ´òÓ¡FooBar      https://leetcode-cn.com/problems/print-foobar-alternately/
public class FooBar {

    private int n;
    private volatile boolean isPrint = false;
    private Object lock;

    public FooBar(int n) {
        this.lock = new Object();
        this.n = n;
    }


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (isPrint) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isPrint = true;
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!isPrint) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isPrint = false;
                lock.notify();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        FooBar t = new FooBar(2);
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
    }
}
