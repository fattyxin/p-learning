package headfirst.factory.method;

/**
 * created by qinwanxin on 2018/5/23 14:34
 */
public class MakyCreamCake extends Cake {
    public MakyCreamCake() {
        this.setName("Maky cream cake");
        this.getToppings().add("Yogurt");
        this.getToppings().add("cream");
    }


}
