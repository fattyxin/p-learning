package headfirst.singleton;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by qinwanxin on 2018/5/28 17:48
 */
public class NamedThreadFactory implements ThreadFactory {
    private AtomicInteger poolNum;
    private String prefix;
    private ThreadGroup threadGroup;
    private boolean isDaemon;

    public NamedThreadFactory(String prefix) {
        this(prefix, false);
    }

    public NamedThreadFactory(String prefix, boolean isDaemon) {
        this.prefix = prefix + "-thread-";
        this.isDaemon = isDaemon;
        this.poolNum = new AtomicInteger(0);
        SecurityManager s = System.getSecurityManager();
        threadGroup = s == null ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = prefix + poolNum.getAndIncrement();
        Thread t = new Thread(this.threadGroup, r, name);
        t.setDaemon(isDaemon);
        return t;
    }
}
