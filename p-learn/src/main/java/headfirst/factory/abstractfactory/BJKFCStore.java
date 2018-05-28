package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 19:26
 */
public class BJKFCStore extends KFCStore {
    @Override
    protected FiredChicken createFiredChicken() {
        //从跑步鸡养殖场购买原料
        RunChickenFarm runChickenFarm = new RunChickenFarm();
        return  new BJFiredChicken(runChickenFarm);
    }
}
