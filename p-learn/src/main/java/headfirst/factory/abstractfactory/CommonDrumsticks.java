package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 18:50
 */
public class CommonDrumsticks implements Chicken {
    @Override
    public String getName() {
        return "I am common Drumsticks";
    }

    @Override
    public void box() {
        System.out.println("common Drumsticks boxed!");
    }
}
