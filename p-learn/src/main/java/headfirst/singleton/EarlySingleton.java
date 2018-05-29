package headfirst.singleton;

/**
 * created by qinwanxin on 2018/5/28 17:38
 */
public class EarlySingleton {
    private static EarlySingleton earlySingleton = new EarlySingleton();
    private EarlySingleton(){}

    public static EarlySingleton getInstance(){
        return earlySingleton;
    }
}
