package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

//public class ZeroEvenOdd {
//    private int n;
//    Semaphore semaphoreZero = new Semaphore(1);
//    Semaphore semaphoreEven = new Semaphore(0);
//    Semaphore semaphoreOld = new Semaphore(0);
//
//
//    public ZeroEvenOdd(int n) {
//        this.n = n;
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            semaphoreZero.acquire();
//            if (n % 2 == 0) {
//                printNumber.accept(0);
//                semaphoreOld.release();
//            } else {
//                semaphoreEven.release();
//            }
//        }
//    }
//
//    public void even(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 1; i <= n; i += 2) {
//            printNumber.accept(i);
//            semaphoreEven.acquire();
//            semaphoreZero.release();
//        }
//    }
//
//    public void odd(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 1; i <= n; i += 2) {
//            printNumber.accept(i);
//            semaphoreOld.acquire();
//            semaphoreZero.release();
//        }
//    }
//}
class ZeroEvenOdd {
    private int n;
    Semaphore zero = new Semaphore(1);
    Semaphore odd = new Semaphore(0);
    Semaphore even = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            zero.acquire();
            printNumber.accept(0);
            if(i%2==1) even.release();
            else odd.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}
