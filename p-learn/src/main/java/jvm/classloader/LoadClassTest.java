package jvm.classloader;

/**
 * created by qinwanxin on 2018/7/26 14:50
 */
public class LoadClassTest {
    public static void main(String[] args) {
        //子类引用自身static变量
        /**
         * SuperClass load
         * 33
         */
//        System.out.println(SuperClass.age);
        /**
         * SuperClass load hello
         */
//        System.out.println(SuperClass.name);
        /**
         * 66
         */
//        System.out.println(SuperClass.age2);
        /**
         * hello2
         */
//        System.out.println(SuperClass.name2);

        //子类引用自身static变量
        /**
         * SuperClass load
         * SubClass load
         * 22
         */
//        System.out.println(SubClass.agesub);
        /**
         * SuperClass load
         * SubClass load
         * hellosub
         */
//        System.out.println(SubClass.namesub);
        /**
         * hellosub2
         */
//        System.out.println(SubClass.namesub2);
        /**
         * 444
         */
//        System.out.println(SubClass.agesub2);

        //引用父类static变量
        /**
         * SuperClass load
         * 33
         */
//        System.out.println(SubClass.age);
        /**
         * SuperClass load
         * hello
         */
//        System.out.println(SubClass.name);
        /**
         * hello2
         */
//        System.out.println(SubClass.name2);
        /**
         * 66
         */
//        System.out.println(SubClass.age2);

        /**
         * 结论：
         * 1.访问final static 不会触发初始化(final static 变量在编译器把结果放入常量池)
         * 2.访问static(非final)字段 仅会触发 定义此字段的类 及其 父类 的初始化
         */
    }
}

class SuperClass{
    public static int age = 33;
    public static String name = "hello";
    public static final String name2 = "hello2";
    public static final int age2 = 66;
    static {
        System.out.println("SuperClass load");
    }
}

class SubClass extends SuperClass{
    public static int agesub = 22;
    public static String namesub = "hellosub";
    public static final String namesub2 = "hellosub2";
    public static final int agesub2 = 444;
    static {
        System.out.println("SubClass load");
    }
}
