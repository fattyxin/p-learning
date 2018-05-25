package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 18:41
 */
public interface ChickenFarm {
    //养鸡场

    /**
     * 生产鸡腿
     * @return
     */
    Chicken createDrumsticks();

    /**
     * 生产鸡翅
     * @return
     */
    Chicken createChickenWings();
}
