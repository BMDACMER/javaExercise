package leetcode;

import java.util.concurrent.Semaphore;

// https://leetcode-cn.com/problems/building-h2o/
public class H2O {
    Semaphore semaphoreH = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(0);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphoreO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        semaphoreH.release(2);
    }
}
