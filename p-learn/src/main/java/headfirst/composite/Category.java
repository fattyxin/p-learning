package headfirst.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * created by qinwanxin on 2018/6/15 10:58
 */
public class Category extends CategoryComponent {
    private List<CategoryComponent> categoryComponentList = new ArrayList<>();
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @Override
    public void add(CategoryComponent categoryComponent) {
        categoryComponentList.add(categoryComponent);
    }

    @Override
    public void remove(CategoryComponent categoryComponent) {
        categoryComponentList.remove(categoryComponent);
    }

    @Override
    public void print() {
        System.out.println(getName());
        Iterator<CategoryComponent> iterator = categoryComponentList.iterator();
        while(iterator.hasNext()){
            CategoryComponent categoryComponent = iterator.next();
            categoryComponent.print();
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
