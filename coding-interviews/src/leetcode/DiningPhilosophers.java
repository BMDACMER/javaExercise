package leetcode;
// 1226. ��ѧ�ҽ���

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    Semaphore eatLimit = new Semaphore(4);
    //1��Fork��Ϊ1��ReentrantLock��5�����Ӽ�5��ReentrantLock�����䶼����������
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
        int leftFork = (philosopher + 1) % 5; //��ߵĲ��� �ı��
        int rightFork = philosopher; //�ұߵĲ��� �ı��

        eatLimit.acquire();    // ���Ƶ�����  -1

        lockList[leftFork].lock();   // ������ߵĲ���
        lockList[rightFork].lock();  //�����ұ�Ĳ���

        eat.run();   // ����

        putLeftFork.run();   // ������ߵĲ��ӵľ���ִ��
        putRightFork.run();   // �����ұߵĲ��ӵľ���ִ��

        lockList[leftFork].unlock();   // ������ߵĲ���
        lockList[rightFork].unlock();   // �����ұ�Ĳ���

        eatLimit.release();   // ���Ƶ����� +1
    }

}
