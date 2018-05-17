package headfirst.factory.simple;

import org.springframework.util.Assert;

public class SimpleFactoryMain {
    /**
     *
     * 简单工厂模式
     * 简单工厂模式 并不是一种设计模式，但是很实用。
     * 把对象的创建封装到一个工厂类里，让客户端仅与抽象类型相关 而与具体类型无关
     *
     *
     * 顾客去蛋糕店买蛋糕，蛋糕店生产蛋糕，蛋糕店不依赖具体的实现类型，如 奶油蛋糕，而是把制作封装到工厂。
     */

    public static void main(String[] args) {
        //选了一家 蛋糕店
        CakeStore cakeStore = new CakeStore();

        Cake cake1 = cakeStore.makeCakeCommon(CakeTypeEnum.Cream_Cake.getType());
        Assert.isTrue(cake1 instanceof CreamCake,"cake1 is not creamCake");
        Cake cake2 = cakeStore.makeCakeFactory(CakeTypeEnum.Fruit_Cake.getType());
        Assert.isTrue(cake2 instanceof FruitCake,"cake1 is not fruitCake");

    }
}
