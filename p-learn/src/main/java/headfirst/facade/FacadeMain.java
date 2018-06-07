package headfirst.facade;

/**
 * created by qinwanxin on 2018/6/7 16:27
 */
public class FacadeMain {

    /**
     *
     * 外观模式
     * 外观模式提供了一个统一的接口，用来访问子系统中的一群接口。
     * 外观定义了一个高层接口，让子系统更容易使用。
     *
     * 夏天回家，关窗、挂窗帘、开空调。
     * 出门 关空调、收窗帘、开窗
     */
    public static void main(String[] args) {
        //I am a man
        AirConditioner airConditioner = new AirConditioner();
        Curtain curtain = new Curtain();
        Window window = new Window();
        System.out.println("go home back");
        window.close();
        curtain.down();
        airConditioner.open();
        System.out.println("go bo bed for sleeping");

        System.out.println("---------------------");
        //换了一套智能家居 仅依赖控制器即可
        SmartController smartController = new SmartController(airConditioner,curtain,window);
        System.out.println("go home back");
        //开启睡觉模式
        smartController.sleepModel();
        System.out.println("go bo bed for sleeping");


    }
}
