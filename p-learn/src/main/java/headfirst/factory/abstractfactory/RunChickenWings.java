package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 18:50
 */
public class RunChickenWings implements Chicken {
    @Override
    public String getName() {
        return "I am run ChickenWings";
    }

    @Override
    public void box() {
        System.out.println("run ChickenWings boxed!");
    }
}
