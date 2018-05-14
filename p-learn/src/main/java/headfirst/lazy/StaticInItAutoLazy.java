package headfirst.lazy;


public class StaticInItAutoLazy {
    public static StaticInItAutoLazy staticInItAutoLazy = new StaticInItAutoLazy();
    public static SingleAutoLazy singleAutoLazy = new SingleAutoLazy();
    public StaticInItAutoLazy(){
        System.out.println("StaticInItAutoLazy init");
    }
    static {
        System.out.println("static block");
    }

    public synchronized static StaticInItAutoLazy getInstance(){
        return staticInItAutoLazy;
    }

}
