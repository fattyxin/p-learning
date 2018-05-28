package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 18:04
 */
public enum FiredChickenTypeEnum {
    /**
     * 香辣味
     */
    Spicy_Flavor (1),
    /**
     * 原味
     */
    Original_Taste (2)
    ;
    private int type;

    FiredChickenTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
