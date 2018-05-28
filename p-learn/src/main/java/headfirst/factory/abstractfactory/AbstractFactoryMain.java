package headfirst.factory.abstractfactory;

/**
 * created by qinwanxin on 2018/5/25 16:23
 */
public class AbstractFactoryMain {
    /**
     *
     * 抽象工厂模式
     * 抽象工厂模式提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类。
     *
     *
     * KFC 炸鸡  Fried chicken
     * 原料 鸡腿 鸡翅
     * 两家 养鸡场 生产鸡腿Drumsticks  鸡翅Chicken wings
     * 两家 KFC 一个 北京 一个上海 分别从 北京 和上海的养鸡场 购买材料
     *
     * 炸鸡制作：准备材料、炸、加香料、打包。
     *
     * 确实例子不太合理  主要看 养鸡场。。。
     */
    public static void main(String[] args) {
        //找到一家北京fkc
        KFCStore bjkfc = new BJKFCStore();
        //香辣味炸鸡
        FiredChicken firedChicken = bjkfc.orderFiredChicken(FiredChickenTypeEnum.Spicy_Flavor.getType());
        firedChicken.descc();

        //找到一家上海fkc
        KFCStore shkfc = new SHKFCStore();
        //原味炸鸡
        FiredChicken firedChicken1 = shkfc.orderFiredChicken(FiredChickenTypeEnum.Original_Taste.getType());
        firedChicken1.descc();

    }
}
