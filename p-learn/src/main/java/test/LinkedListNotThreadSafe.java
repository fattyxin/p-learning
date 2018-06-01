package test;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * created by qinwanxin on 2018/6/1 17:17
 */
public class LinkedListNotThreadSafe {
    public static void main(String[] args) {
        final LinkedList<Integer> linkedList = new LinkedList<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100,100,0, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final CountDownLatch countDownLatch2 = new CountDownLatch(10000);

        for(int i =0;i<10000;i++){
            final int num = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        linkedList.push(num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch2.countDown();
                    }
                }
            });
        }

        countDownLatch.countDown();
        try {
            countDownLatch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(linkedList);
        System.out.println(linkedList.size());

    }
}
