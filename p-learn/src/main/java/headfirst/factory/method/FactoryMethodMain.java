package headfirst.factory.method;

public class FactoryMethodMain {
    /**
     *
     * 工厂方法模式
     * 工厂方法模式定义了一个创建对象的接口,但由子类决定要实例化的类是哪一个,工厂方法让类把实例化推迟到子类。
     *
     * 有两家蛋糕店 好利来：Holiland  米旗:maky
     * 都有 奶油蛋糕、水果蛋糕
     * 奶油蛋糕: Holiland 的是甜的 maky的是酸的
     * 水果蛋糕：Holiland 的是苹果的 maky的是香蕉的
     * 水果蛋糕 和奶油蛋糕 仅仅是配料不同。这个模式里并不突出，实际上仅一种蛋糕就可以。即：去两家店 都订水果蛋糕。
     */
    public static void main(String[] args) {
        //选了Holiland蛋糕店
        CakeStore holilandCakeStore = new HolilandCakeStore();
        //订了一个水果蛋糕
        System.out.println("----------------start hfcake----------------");
        Cake hfcake = holilandCakeStore.orderCake(CakeTypeEnum.FRUIT_CAKE.getType());
        System.out.println("hfcake = " + hfcake);
        System.out.println("----------------end hfcake----------------");
        //订了一个奶油蛋糕
        System.out.println("----------------start hccake----------------");
        Cake hccake = holilandCakeStore.orderCake(CakeTypeEnum.CREAM_CAKE.getType());
        System.out.println("hccake = " + hccake);
        System.out.println("----------------end hccake----------------");

        //选了Maky蛋糕店
        CakeStore makyCakeStore = new MakyCakeStore();
        //订了一个水果蛋糕
        System.out.println("----------------start mfcake----------------");
        Cake mfcake = makyCakeStore.orderCake(CakeTypeEnum.FRUIT_CAKE.getType());
        System.out.println("mfcake = " + mfcake);
        System.out.println("----------------end mfcake----------------");

        //订了一个奶油蛋糕
        System.out.println("----------------start mccake----------------");
        Cake mccake = makyCakeStore.orderCake(CakeTypeEnum.CREAM_CAKE.getType());
        System.out.println("mccake = " + mccake);
        System.out.println("----------------end mccake----------------");
    }
}
