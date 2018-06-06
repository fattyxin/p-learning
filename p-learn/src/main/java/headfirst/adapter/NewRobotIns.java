package headfirst.adapter;

/**
 * created by qinwanxin on 2018/6/6 23:01
 */
public class NewRobotIns implements NewRobot {
    @Override
    public String sayHi() {
        return "hi! i am "+this.getClass().getSimpleName() + " and really niubility!";
    }

    @Override
    public void sweepRoom() {
//        System.out.println("I can not clean room!It is too difficult");
        throw new UnsupportedOperationException("I can not clean room!It is too difficult");
    }
}
