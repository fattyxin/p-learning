package headfirst.strategyPattern;

public abstract class Character {
    WeaponBehavior weaponBehavior;
    abstract void fight();


    public void changeWeapon(WeaponBehavior behavior){
        this.weaponBehavior = behavior;
    }
}
