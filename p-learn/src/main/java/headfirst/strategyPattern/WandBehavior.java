package headfirst.strategyPattern;

public class WandBehavior implements WeaponBehavior {
    @Override
    public void userWeapon() {
        System.out.println("use wand to fight");
    }
}
