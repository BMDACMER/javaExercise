package leetcode;
// 1226. 哲学家进餐

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    Semaphore eatLimit = new Semaphore(4);
    //1个Fork视为1个ReentrantLock，5个叉子即5个ReentrantLock，将其都放入数组中
    private final ReentrantLock[]  lockList = {new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };


    public DiningPhilosophers() {

    }


    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher + 1) % 5; //左边的叉子 的编号
        int rightFork = philosopher; //右边的叉子 的编号

        eatLimit.acquire();    // 限制的人数  -1

        lockList[leftFork].lock();   // 拿起左边的叉子
        lockList[rightFork].lock();  //拿起右遍的叉子

        eat.run();   // 吃面

        putLeftFork.run();   // 放下左边的叉子的具体执行
        putRightFork.run();   // 放下右边的叉子的具体执行

        lockList[leftFork].unlock();   // 放下左边的叉子
        lockList[rightFork].unlock();   // 放下右遍的叉子

        eatLimit.release();   // 限制的人数 +1
    }

}
