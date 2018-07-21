package headfirst.strategyPattern;

/**
 * 战士
 */
public class Warrior extends Character {
    @Override
    void fight() {
        if(weaponBehavior == null){
            System.out.println("use fist(拳头) to fight");
        }else {
            weaponBehavior.userWeapon();

        }
    }
}
