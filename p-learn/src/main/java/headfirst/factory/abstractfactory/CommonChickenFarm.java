package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 18:49
 */
public class CommonChickenFarm implements ChickenFarm {
    @Override
    public Chicken createDrumsticks() {
        return new CommonDrumsticks();
    }

    @Override
    public Chicken createChickenWings() {
        return new CommonChickenWings();
    }
}
