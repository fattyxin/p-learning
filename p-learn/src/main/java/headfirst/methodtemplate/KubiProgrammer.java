package headfirst.methodtemplate;

/**
 * created by qinwanxin on 2018/6/8 16:29
 */
public class KubiProgrammer extends Programmer {
    @Override
    void doSomething() {
        System.out.println("do Kubi crud in company");

    }

    @Override
    protected void goCompany() {
        System.out.println("run 10km to company");
    }

    @Override
    protected void eat() {
        System.out.println("eat fish in company");

    }

    @Override
    protected void doMore() {
        System.out.println("do more do more more more in company");

    }

    @Override
    protected void goHome() {
        System.out.println("run 10km to home");

    }
}
