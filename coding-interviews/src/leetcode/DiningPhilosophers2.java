package leetcode;
// 1226. 哲学家进餐
//  链接：
//  https://leetcode-cn.com/problems/the-dining-philosophers/solution/1ge-semaphore-1ge-reentrantlockshu-zu-by-gfu/

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class DiningPhilosophers2 {

    //初始化为0, 二进制表示则为00000, 说明当前所有叉子都未被使用
    private AtomicInteger fork = new AtomicInteger(0);
    //每个叉子的int值(即二进制的00001, 00010, 00100, 01000, 10000)
    private final int[] forkMask = new int[]{1,2,4,8,16};
    // 限制 最多只有4个哲学家去持有叉子
    private Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers2() {

    }


    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftMask = forkMask[(philosopher + 1) % 5];
        int rightMask = forkMask[philosopher];
        eatLimit.acquire();    //限制的人数 -1

        while (!pickFork(leftMask)) Thread.sleep(1);    //拿起左边的叉子
        while (!pickFork(rightMask)) Thread.sleep(1);   //拿起右边的叉子

        pickLeftFork.run();    //拿起左边的叉子 的具体执行
        pickRightFork.run();    //拿起右边的叉子 的具体执行

        eat.run();    //吃意大利面 的具体执行

        putLeftFork.run();    //放下左边的叉子 的具体执行
        putRightFork.run();    //放下右边的叉子 的具体执行

        while (!putFork(leftMask)) Thread.sleep(1);     //放下左边的叉子
        while (!putFork(rightMask)) Thread.sleep(1);    //放下右边的叉子

        eatLimit.release(); //限制的人数 +1

    }

    private boolean pickFork(int mask) {
        int expect = fork.get();
        return (expect & mask) > 0 ? false : fork.compareAndSet(expect, expect ^ mask);
    }

    private boolean putFork(int mask) {
        int expect = fork.get();
        return fork.compareAndSet(expect, expect ^ mask);
    }

}
