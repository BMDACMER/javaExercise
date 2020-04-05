package juc.lock;

public class SynchronizedDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Thread 1").start();

        new Thread(() -> {
            try {
                phone.sendEmails();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Thread 2 ").start();
    }
}

class Phone{
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getName() + "\t ---------invoked sendSMS()");
        Thread.sleep(3000);
        sendEmails();
    }

    public synchronized void sendEmails() throws Exception{
        System.out.println(Thread.currentThread().getName() + "\t ---------------invoked sendEmails()");
    }

}