package headfirst.lazy;

public class TestMain {
    public static void main(String[] args) {

        System.out.println("before");
        try {
            Class.forName("headfirst.lazy.StaticInItAutoLazy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("after");
        System.out.println("------");
        System.out.println(StaticInItAutoLazy.getInstance());
        System.out.println("======");

        System.out.println("after1");
        System.out.println(StaticInItAutoLazy.singleAutoLazy);
        System.out.println(StaticInItAutoLazy.staticInItAutoLazy);
    }
}
