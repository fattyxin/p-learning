package headfirst.decorator;

import java.util.ArrayList;
import java.util.List;

public class KaoLengMian implements NeedBuy {
    List<Addible> addibles = new ArrayList<>();
    private int price;

    public KaoLengMian(int price) {
        this.price = price;
    }

    @Override
    public int cost() {
        return this.price;
    }

}
