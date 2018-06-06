package headfirst.adapter;

/**
 * created by qinwanxin on 2018/6/6 22:59
 */
public class OldRobotIns implements OldRobot {
    @Override
    public String sayHello() {
        return "hello! i am "+this.getClass().getSimpleName();
    }

    @Override
    public void cleanRoom() {
        System.out.println("I am cleaning room now!");
    }
}
