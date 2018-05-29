package headfirst.singleton;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * created by qinwanxin on 2018/5/28 11:35
 */
public class SingletonMain {
    /**
     * 单例模式
     * 单例模式确保一个类只有一个实例,并提供一个全局访问点。
     * <p>
     * 主要需要考虑 多线程、性能
     */
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), new NamedThreadFactory("singleton"));
        int loopTimes = 10000;
        invokeMethodMoreTimes(SyncSingleton.class, executor, loopTimes);
        invokeMethodMoreTimes(EarlySingleton.class, executor, loopTimes);
        invokeMethodMoreTimes(DoubleCheckSingleton.class, executor, loopTimes);
    }


    private static void invokeMethodMoreTimes(final Class clasz, Executor executor, int loopTimes) {
        final Set result = new HashSet<Object>();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(loopTimes);

        try {
            final Method method = clasz.getDeclaredMethod("getInstance");
            for (int i = 0; i < loopTimes; i++) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            countDownLatch.await();
                            result.add(method.invoke(clasz));
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            done.countDown();
                        }
                    }
                });
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        countDownLatch.countDown();
        try {
            done.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(clasz.getName() + " " + loopTimes + " times cost " + (end - start) + "ms");
        System.out.println("instance result " + result);
    }
}
