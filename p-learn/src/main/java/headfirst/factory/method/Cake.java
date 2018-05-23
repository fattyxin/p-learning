package headfirst.factory.method;

import java.util.ArrayList;
import java.util.List;

/**
 * created by qinwanxin on 2018/5/22 22:31
 */
public abstract class Cake {
    private String name;
    private List<String> toppings = new ArrayList<>();

    public Cake() {
        this.name = "大面包片";
    }

    public void prepare() {
        System.out.println("preparing " + this.getName());
        for (String topping : toppings) {
            System.out.println("preparing topping  " + topping);
        }
    }

    public void bake() {
        System.out.println(this.getName() + " baked!");
    }

    public void make() {
        //加配料
        System.out.println(this.getName() + " start to add topping!");
        for (String topping : toppings) {
            System.out.println("start to add topping  " + topping);
        }
        System.out.println(this.getName() + " end to add topping!");
    }

    public void box() {
        System.out.println(this.getName() + " boxed!");
    }

    @Override
    public String toString() {
        return "From Cake:\n I am " + this.getName() + ", my toppings " + this.getToppings();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }
}
