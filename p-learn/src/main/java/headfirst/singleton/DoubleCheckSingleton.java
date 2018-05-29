package headfirst.singleton;

/**
 * created by qinwanxin on 2018/5/28 17:39
 */
public class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getInstance(){
        if(doubleCheckSingleton == null){
            synchronized (DoubleCheckSingleton.class){
                if(doubleCheckSingleton == null){
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }
}
