package juc.base;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//ͬ�����첽���첽�ص�
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //   //ͬ�����첽���첽�ص�

        // ͬ��
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName() + "\t completableFuture1");
//        });
//        completableFuture.get();   // ForkJoinPool.commonPool-worker-1	 completableFuture1

        //�첽�ص�
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t completableFuture2");
//            int i = 10/0;
            return 1024;
        });

        completableFuture2.whenComplete((t,u)->{
            System.out.println("-------t="+t);
            System.out.println("-------u="+u);
        }).exceptionally(f->{
            System.out.println("-----exception:"+f.getMessage());
            return 444;
        }).get();

    }
}
