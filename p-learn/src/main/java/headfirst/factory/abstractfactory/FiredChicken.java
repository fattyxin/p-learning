package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 18:02
 */
public interface FiredChicken {
    /**
     * 准备
     */
    void prepare();

    /**
     * 油炸
     */
    void fry();

    /**
     * 加调料
     */
    void addTops();

    /**
     * 打包
     */
    void box();

    /**
     * 描述
     */
    void descc();
}
