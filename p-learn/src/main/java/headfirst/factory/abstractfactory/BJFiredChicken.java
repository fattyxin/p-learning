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
        chickenList.add(chickenFarm.createDrumsticks());

    }

    @Override
    public void fry() {

    }

    @Override
    public void addTops() {

    }

    @Override
    public void box() {

    }

    @Override
    public void descc() {

    }
}
