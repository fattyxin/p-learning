package headfirst.decorator;

public class EggAddible implements Addible {
    private NeedBuy needBuy;
    private int price;
    public EggAddible(NeedBuy needBuy, int price) {
        this.needBuy = needBuy;
        this.price = price;
    }

    @Override
    public int cost() {
        return this.price + needBuy.cost();
    }


}
