package headfirst.proxy;

/**
 * created by qinwanxin on 2018/6/22 14:50
 */
public class ManageImpl  implements  Manager{

    @Override
    public void approve(String s) {
        System.out.println("approve "+ s);
    }

    @Override
    public void meeting(String s) {
        System.out.println("meeting "+ s);
    }
}
