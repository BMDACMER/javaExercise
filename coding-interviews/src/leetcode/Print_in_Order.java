package leetcode;

//1114. 按序打印    https://leetcode-cn.com/problems/print-in-order/

public class Print_in_Order {

    public Print_in_Order() {
    }

    volatile int count = 1;
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        count++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count!=2);   // 自旋等待
        printSecond.run();
        count++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (count!=3);
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        Print_in_Order print = new Print_in_Order();
        print.first(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始第一个线程");
            }
        });
        System.out.println("count = " + print.count);

        print.second(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二个线程");
            }
        });
        System.out.println("count = " + print.count);

        print.third(new Runnable() {
            @Override
            public void run() {
                System.out.println("第三个线程");
            }
        });
        System.out.println("count = " + print.count);
    }
}
