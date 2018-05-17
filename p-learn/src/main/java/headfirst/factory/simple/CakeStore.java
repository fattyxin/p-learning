package headfirst.factory.simple;

public class CakeStore {

    /**
     * 老的做法 依赖于具体的实现类 如 奶油蛋糕
     * 新来一种蛋糕 需要改 cakeStore
     * @param cakeType
     * @return
     */
    public Cake makeCakeCommon(int cakeType) {
        if(CakeTypeEnum.Cream_Cake.getType() == cakeType){
            return new CreamCake("奶油蛋糕");
        }else if(CakeTypeEnum.Fruit_Cake.getType() == cakeType){
            return new FruitCake("水果蛋糕");
        }else if (CakeTypeEnum.Cream_Cake.getType() == cakeType){
            return new CheesesCake("芝士蛋糕");
        }else {
            return null;
        }
    }


    /**
     * 通过一个外部的工厂来创建，仅需依赖抽象Cake 而不用依赖具体实现
     * @param cakeType
     * @return
     */
    public Cake makeCakeFactory(int cakeType) {
        return SimpleCakeFactory.makeCakeFactory(cakeType);
    }
}
