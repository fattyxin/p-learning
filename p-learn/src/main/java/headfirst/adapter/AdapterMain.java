package headfirst.adapter;

/**
 * created by qinwanxin on 2018/6/6 18:59
 */
public class AdapterMain {

    /**
     *
     * 适配器模式
     * 适配器模式将一个类的接口，转换成客户期望的另一个接口。
     * 适配器让原本接口不兼容的类可以合作无间。
     *
     *
     * 接口升级。
     * interface1 -->interface2，客户端并不愿意更换(就当因为变动太大balabala)
     * interface2中 仅实现了部分 原有功能(就当时间太紧，撸了个半成品)
     *
     * 由于interface2有非常牛逼的实现，所以要把interface1中的请求转到interface2上
     * 但是新接入interface2的客户端 表示 要用到某些 interface2中未实现的 原有功能。。。。。
     *
     */

    public static void main(String[] args) {
        //客户端仅依赖接口 不依赖具体实现。

        //old
        OldRobot oldRobot = new OldRobotIns();
        System.out.println(oldRobot.sayHello());
        oldRobot.cleanRoom();

        //new
        NewRobot newRobot = new NewRobotIns();
        System.out.println(newRobot.sayHi());
        try {
            newRobot.sweepRoom();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         *
         * old client 变化太大了 不改不改
         *  就要 sayHello 不要 sayHi
         *
         *
         *   new client 纳尼？新机器人不会扫地 闹啥呢~
         */
        System.out.println("------");
        OldRobot oldRobot1 = new RobotAdapter(oldRobot,newRobot);
        System.out.println(oldRobot1.sayHello());
        oldRobot1.cleanRoom();

        NewRobot newRobot1 = new RobotAdapter(oldRobot,newRobot);
        System.out.println(newRobot1.sayHi());
        try {
            newRobot1.sweepRoom();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
