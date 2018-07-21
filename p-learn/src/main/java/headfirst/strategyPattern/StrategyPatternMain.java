package headfirst.strategyPattern;

public class StrategyPatternMain {
    /**
     * 策略模式（StrategyPattern）
     * 策略模式定义了算法族，分别封装起来，让他们之间可以互相替换，
     * 此模式让算法的变化独立于使用算法的客户。
     * -----
     * 游戏角色：法师、战士。
     * 角色使用武器攻击
     * 角色可以更换武器
     */
    public static void main(String[] args) {
        Character master = new Master();
        master.fight();
        master.changeWeapon(new KnifeBeahvior());
        master.fight();
        master.changeWeapon(null);
        master.fight();
        master.changeWeapon(new WandBehavior());
        master.fight();
        System.out.println("-------");
        Character warrior = new Warrior();
        warrior.fight();;
        warrior.changeWeapon(new KnifeBeahvior());
        warrior.fight();
    }
}
