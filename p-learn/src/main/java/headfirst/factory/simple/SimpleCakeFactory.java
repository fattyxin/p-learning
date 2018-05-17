package headfirst.factory.simple;

public class SimpleCakeFactory {
    public static Cake makeCakeFactory(int cakeType){
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
}
