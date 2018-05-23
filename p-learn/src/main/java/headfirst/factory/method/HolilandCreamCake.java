package headfirst.factory.method;

/**
 * created by qinwanxin on 2018/5/23 14:31
 */
public class HolilandCreamCake extends Cake {
    public HolilandCreamCake() {
        this.setName("Holiland cream cake");
        this.getToppings().add("sugar");
        this.getToppings().add("cream");
    }
}
