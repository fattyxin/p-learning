package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 18:49
 */
public class RunChickenFarm implements ChickenFarm {
    @Override
    public Chicken createDrumsticks() {
        Chicken rd = new RunDrumsticks();
        System.out.println(rd.getName()+" created");
        rd.box();
        return rd;
    }

    @Override
    public Chicken createChickenWings() {
        Chicken rcw = new RunChickenWings();
        System.out.println(rcw.getName()+" created");
        rcw.box();
        return rcw;
    }
}
