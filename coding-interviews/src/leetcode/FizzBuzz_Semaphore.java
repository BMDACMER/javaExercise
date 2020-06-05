package leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz_Semaphore {
    private int n;
    private Semaphore semaphore = new Semaphore(1);
    private int curNum = 1;
//hashm
    public FizzBuzz_Semaphore(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException, BrokenBarrierException {
        for (;;) {
            this.semaphore.acquire(1);

            if (this.curNum > n) return;

            if ((this.curNum % 3 == 0) && this.curNum % 5 != 0) {
                printFizz.run();
                this.curNum++;
            }
            this.semaphore.release();
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException, BrokenBarrierException {
        for(;;) {
            this.semaphore.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 != 0) && (this.curNum % 5 == 0)) {
                    printBuzz.run();
                    this.curNum++;
                }
            } finally {
                this.semaphore.release(1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException, BrokenBarrierException {
        for(;;) {
            this.semaphore.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 == 0) && (this.curNum % 5 == 0)) {
                    printFizzBuzz.run();
                    this.curNum++;
                }
            } finally {
                this.semaphore.release(1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException, BrokenBarrierException {
        for(;;) {
            this.semaphore.acquire(1);

            try {
                if (this.curNum > n) {
                    return;
                }

                if ((this.curNum % 3 != 0) && (this.curNum % 5 != 0)) {
                    printNumber.accept(this.curNum);
                    this.curNum++;
                }
            } finally {
                this.semaphore.release(1);
            }
        }
    }

}
