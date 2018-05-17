package headfirst.factory.simple;

public enum CakeTypeEnum {
    Cream_Cake(1),
    Cheeses_Cake(2),
    Fruit_Cake(3);

    private int type;
    CakeTypeEnum(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
