package headfirst.decorator;

public class DecoratorMain {
    /**
     *
     * 装饰器模式
     * 装饰器模式 动态地将责任附加到对象上，若要扩展功能，装饰者提供了比继承更有弹性的替代方案。
     *
     *
     * 烤冷面
     * 可以加的 配料 很多-->加肠、加蛋、辣条、蔬菜
     * 不同的东西不同的价格
     *
     * 烤冷面本身是一种 需要购买的东西--> NeedBuy
     * NeedBuy 应有一个方法 得知购买需要花多少钱
     *
     * 配料 装饰 NeedBuy 并附加价格
     *
     * 最后付款时需要计算出 整体价格 及 添加的 配料
     */

    public static void main(String[] args) {
        //烤冷面5元
        NeedBuy kaolengmian = new KaoLengMian(5);
        //加蛋2元
        kaolengmian = new EggAddible(kaolengmian,2);
        //加肠3元
        kaolengmian = new SausageAddible(kaolengmian,3);
        //加菜1元
        kaolengmian = new VegetablesAddible(kaolengmian,1);
        NeedBuy klm = new SausageAddible(new EggAddible(new KaoLengMian(5),2),3);
        System.out.println("klm.cost() = " + klm.cost());
        System.out.println("kaolengmian = " + kaolengmian.cost());
    }
}
