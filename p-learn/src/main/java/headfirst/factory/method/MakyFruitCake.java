package headfirst.factory.method;

/**
 * created by qinwanxin on 2018/5/22 23:37
 */
public class MakyFruitCake extends Cake {
    public MakyFruitCake() {
        this.setName("Maky fruit cake");
        this.getToppings().add("banana");
        this.getToppings().add("cream");
    }
}
