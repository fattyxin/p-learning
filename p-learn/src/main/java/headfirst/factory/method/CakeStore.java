package headfirst.factory.method;

/**
 * created by qinwanxin on 2018/5/22 22:33
 */
public abstract class CakeStore {
    public Cake orderCake(int type){
        Cake cake = createCake(type);
        cake.prepare();
        cake.bake();
        cake.make();
        cake.box();
        return cake;
    }

    /**
     * 需要子类各个蛋糕店实现该方法
     * @param type 蛋糕类型 @See
     * @return 创建好的蛋糕
     */
    protected abstract Cake createCake(int type);
}
