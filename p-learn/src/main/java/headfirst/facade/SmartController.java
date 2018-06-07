package headfirst.facade;

/**
 * created by qinwanxin on 2018/6/7 18:40
 */
public class SmartController {
    private AirConditioner airConditioner;
    private Curtain curtain;
    private Window window;

    public SmartController(AirConditioner airConditioner, Curtain curtain, Window window) {
        this.airConditioner = airConditioner;
        this.curtain = curtain;
        this.window = window;
    }

    void sleepModel(){
        window.close();
        curtain.down();
        airConditioner.open();
    }
}
