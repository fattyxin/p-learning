package headfirst.singleton;

/**
 * created by qinwanxin on 2018/5/28 16:21
 */
public class SyncSingleton {
    private SyncSingleton(){}
    private static SyncSingleton syncSingleton;

    public static synchronized SyncSingleton getInstance(){
        if(syncSingleton == null){
            syncSingleton = new SyncSingleton();
        }
        return syncSingleton;
    }
}
