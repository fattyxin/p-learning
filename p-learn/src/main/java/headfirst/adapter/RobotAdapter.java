package headfirst.adapter;

/**
 * created by qinwanxin on 2018/6/6 23:07
 */
public class RobotAdapter implements OldRobot,NewRobot {
    private OldRobot oldRobot;
    private NewRobot newRobot;

    public RobotAdapter(OldRobot oldRobot, NewRobot newRobot) {
        this.oldRobot = oldRobot;
        this.newRobot = newRobot;
    }

    @Override
    public String sayHi() {
        return newRobot.sayHi();
    }

    @Override
    public void sweepRoom() {
        oldRobot.cleanRoom();
    }

    @Override
    public String sayHello() {
        return newRobot.sayHi();
    }

    @Override
    public void cleanRoom() {
        oldRobot.cleanRoom();
    }
}
