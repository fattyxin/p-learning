package headfirst.strategyPattern;

public class KnifeBeahvior implements WeaponBehavior {
    @Override
    public void userWeapon() {
        System.out.println("use knife to fight!");
    }
}
