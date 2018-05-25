package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 18:01
 */
public abstract class KFCStore {
    FiredChicken orderFiredChicken(int type){
        FiredChicken firedChicken = createFiredChicken(type);
        firedChicken.prepare();
        firedChicken.fry();
        firedChicken.addTops();
        firedChicken.box();
        return firedChicken;
    }

    /**
     * 根据炸鸡类型 生成炸鸡实体
     * @param type 炸鸡类型
     * @return 具体炸鸡
     */
    protected abstract FiredChicken createFiredChicken(int type);
}
