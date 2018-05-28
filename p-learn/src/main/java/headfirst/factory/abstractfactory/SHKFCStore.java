package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/28 9:47
 */
public class SHKFCStore extends KFCStore {
    @Override
    protected FiredChicken createFiredChicken() {

        return new SHFiredChicken(new CommonChickenFarm());
    }
}
