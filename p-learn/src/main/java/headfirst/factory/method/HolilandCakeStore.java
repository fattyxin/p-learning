package headfirst.factory.method;

/**
 * created by qinwanxin on 2018/5/22 23:28
 */
public class HolilandCakeStore  extends CakeStore{
    @Override
    protected Cake createCake(int type) {
        if (CakeTypeEnum.CREAM_CAKE.getType() == type) {
            return new HolilandCreamCake();
        } else if (CakeTypeEnum.FRUIT_CAKE.getType() == type) {
            return new HolilandFruitCake();
        } else {
            return null;
        }
    }
}
