package headfirst.iterator;

import java.util.Iterator;

/**
 * created by qinwanxin on 2018/6/14 15:26
 */
public class ComputerCategoryNew implements CategoryNew {
    private String[] members;

    public ComputerCategoryNew(String[] members) {
        this.members = members;
    }
    @Override
    public Iterator createIterator() {
        return new ComputerCategoryIterator(members);
    }
}
