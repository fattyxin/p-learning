package headfirst.factory.abstractfactory;

import java.util.ArrayList;
import java.util.List;

/**
 * created by qinwanxin on 2018/5/28 9:47
 */
public class SHFiredChicken implements FiredChicken{
    private ChickenFarm chickenFarm;

    public SHFiredChicken(ChickenFarm chickenFarm) {
        this.chickenFarm = chickenFarm;
    }

    private List<Chicken> chickenList = new ArrayList<>();

    @Override
    public void prepare() {
        System.out.println("SHFiredChicken start to prepare");
        chickenList.add(chickenFarm.createChickenWings());
        chickenList.add(chickenFarm.createDrumsticks());
        chickenList.add(chickenFarm.createDrumsticks());
        System.out.println("SHFiredChicken end to prepare");

    }

    @Override
    public void fry() {
        System.out.println("SHFiredChicken fry 6 min ");
    }

    @Override
    public void addTops(int type) {
        String top = "";
        if (FiredChickenTypeEnum.Spicy_Flavor.getType() == type) {
            top = "Pepper";
        } else {
            top = "nothing";
        }
        System.out.println("SHFiredChicken addTops " + top);
    }

    @Override
    public void box() {
        System.out.println("SHFiredChicken boxed");

    }

    @Override
    public void descc() {
        System.out.println("I am SHFiredChicken! There are 2*drumsticksand one wings  here");
        for (Chicken chicken : chickenList) {
            System.out.println(chicken.getName());
        }
    }
}
