/**
 * Created by qinwanxin on 17/7/12.
 */
public class HelloWorld {
    public static void main(String[] args) {

        System.out.println("Hello test");
        testJava8();
    }

    public static void testJava8(){
        /**
         *  () -> {} replace no named inner class
         */
        new Thread( () -> System.out.println("hello java8")).start();
    }
}
