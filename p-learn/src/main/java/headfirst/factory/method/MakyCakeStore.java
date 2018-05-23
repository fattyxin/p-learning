package headfirst.factory.method;

/**
 * created by qinwanxin on 2018/5/22 23:38
 */
public class MakyCakeStore extends CakeStore {
    @Override
    protected Cake createCake(int type) {
        if (CakeTypeEnum.CREAM_CAKE.getType() == type) {
            return new MakyCreamCake();
        } else if (CakeTypeEnum.FRUIT_CAKE.getType() == type) {
            return new MakyFruitCake();
        } else {
            return null;
        }
    }
}
