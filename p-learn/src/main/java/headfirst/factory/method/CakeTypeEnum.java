package headfirst.factory.method;

/**
 * created by qinwanxin on 2018/5/22 23:03
 */
public enum CakeTypeEnum {
    CREAM_CAKE(1),
    FRUIT_CAKE(2);


    private int type;
    CakeTypeEnum(int type){
        this.type = type;
    }
    public int getType() {
        return type;
    }
}
