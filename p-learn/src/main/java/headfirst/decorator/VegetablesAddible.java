package headfirst.decorator;

public class VegetablesAddible implements Addible {
    private NeedBuy needBuy;
    private int price;
    public VegetablesAddible(NeedBuy needBuy, int price) {
        this.needBuy = needBuy;
        this.price = price;
    }

    @Override
    public int cost() {
        return this.price + needBuy.cost();
    }

}
