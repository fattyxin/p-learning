package headfirst.composite;

/**
 * created by qinwanxin on 2018/6/15 13:55
 */
public class CategoryItem extends CategoryComponent {
    private String name;

    public CategoryItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isImported() {
        return super.isImported();
    }

    @Override
    public void print() {
        System.out.println(name);
    }
}
