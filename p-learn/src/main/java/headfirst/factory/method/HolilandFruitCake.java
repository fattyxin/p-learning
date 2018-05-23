package headfirst.factory.method;

import java.util.List;

/**
 * created by qinwanxin on 2018/5/22 23:33
 */
public class HolilandFruitCake extends Cake {
    public HolilandFruitCake() {
        this.setName("Holiland fruit cake");
        this.getToppings().add("apple");
        this.getToppings().add("cream");
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    public void bake() {
        super.bake();
    }

    @Override
    public void make() {
        super.make();
    }

    @Override
    public void box() {
        super.box();
    }
}
