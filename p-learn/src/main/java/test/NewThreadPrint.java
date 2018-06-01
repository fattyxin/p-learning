package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by qinwanxin on 2018/5/31 21:18
 */
public class NewThreadPrint {
    public static int k=0;
    static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        for (int m = 0; m<10;m++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int p=0;p<4000;p++) {
                        System.out.println("i："+ i.get());
                        i.getAndIncrement();
                        System.out.println("k: "+k);
                        k++;
                    }
                }
            });
            t.start();
        }
        System.out.println("最终i： --------------"+i);
        System.out.println("最终k: --------------"+k);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.insert(0,"");
    }
}
