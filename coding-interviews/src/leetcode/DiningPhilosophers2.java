package leetcode;
// 1226. ��ѧ�ҽ���
//  ���ӣ�
//  https://leetcode-cn.com/problems/the-dining-philosophers/solution/1ge-semaphore-1ge-reentrantlockshu-zu-by-gfu/

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class DiningPhilosophers2 {

    //��ʼ��Ϊ0, �����Ʊ�ʾ��Ϊ00000, ˵����ǰ���в��Ӷ�δ��ʹ��
    private AtomicInteger fork = new AtomicInteger(0);
    //ÿ�����ӵ�intֵ(�������Ƶ�00001, 00010, 00100, 01000, 10000)
    private final int[] forkMask = new int[]{1,2,4,8,16};
    // ���� ���ֻ��4����ѧ��ȥ���в���
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
        eatLimit.acquire();    //���Ƶ����� -1

        while (!pickFork(leftMask)) Thread.sleep(1);    //������ߵĲ���
        while (!pickFork(rightMask)) Thread.sleep(1);   //�����ұߵĲ���

        pickLeftFork.run();    //������ߵĲ��� �ľ���ִ��
        pickRightFork.run();    //�����ұߵĲ��� �ľ���ִ��

        eat.run();    //��������� �ľ���ִ��

        putLeftFork.run();    //������ߵĲ��� �ľ���ִ��
        putRightFork.run();    //�����ұߵĲ��� �ľ���ִ��

        while (!putFork(leftMask)) Thread.sleep(1);     //������ߵĲ���
        while (!putFork(rightMask)) Thread.sleep(1);    //�����ұߵĲ���

        eatLimit.release(); //���Ƶ����� +1

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
