package headfirst.strategyPattern;

public class Master extends Character {
    @Override
    void fight() {
        if(weaponBehavior == null){
            System.out.println("user fist to fight");
        }else {
            weaponBehavior.userWeapon();
        }
    }
}
