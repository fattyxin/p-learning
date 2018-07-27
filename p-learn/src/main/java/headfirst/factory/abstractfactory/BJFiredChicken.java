package headfirst.factory.abstractfactory;

import java.util.ArrayList;
import java.util.List;

/**
 * created by qinwanxin on 2018/5/25 19:32
 */
public class BJFiredChicken implements FiredChicken {
    private ChickenFarm chickenFarm;

    public BJFiredChicken(ChickenFarm chickenFarm) {
        this.chickenFarm = chickenFarm;
    }

    private List<Chicken> chickenList = new ArrayList<>();

    @Override
    public void prepare() {
        System.out.println("BJFiredChicken start to prepare");
        chickenList.add(chickenFarm.createChickenWings());
        chickenList.add(chickenFarm.createChickenWings());
        chickenList.add(chickenFarm.createDrumsticks());
        System.out.println("BJFiredChicken end to prepare");

    }

    @Override
    public void fry() {
        System.out.println("BJFiredChicken fry 5 min ");
    }

    @Override
    public void addTops(int type) {
        String top = "";
        if (FiredChickenTypeEnum.Spicy_Flavor.getType() == type) {
            top = "Pepper";
        } else {
            top = "nothing";
        }
        System.out.println("BJFiredChicken addTops " + top);
    }

    @Override
    public void box() {
        System.out.println("BJFiredChicken boxed");

    }

    @Override
    public void descc() {
        System.out.println("I am BJFiredChicken! There are 2*wings and one drumsticks here");
        for (Chicken chicken : chickenList) {
            System.out.println(chicken.getName());
        }
    }
}