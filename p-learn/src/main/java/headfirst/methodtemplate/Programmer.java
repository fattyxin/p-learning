package headfirst.methodtemplate;

/**
 * created by qinwanxin on 2018/6/8 16:19
 */
public abstract class Programmer {
    protected final void onDay(){
        goCompany();
        doSomething();
        eat();
        doMore();
        goHome();
    }
    protected void goCompany(){
        System.out.println("go to company");
    }
    protected void eat(){
        System.out.println("eat rice in company");
    }
    protected void doMore(){
        //默认不加班 所以是空的
    }
    protected void goHome(){
        System.out.println("go home");
    }
    abstract void doSomething();
}
