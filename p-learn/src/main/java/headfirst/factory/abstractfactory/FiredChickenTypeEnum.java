package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 18:04
 */
public enum FiredChickenTypeEnum {
    /**
     * 炸鸡腿
     */
    Drumsticks(1),
    /**
     * 炸鸡翅
     */
    Chicken_Wings(2)
    ;
    private int type;

    FiredChickenTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
