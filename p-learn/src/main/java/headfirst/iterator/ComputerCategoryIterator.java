package headfirst.iterator;

import java.util.Iterator;

/**
 * created by qinwanxin on 2018/6/14 15:29
 */
public class ComputerCategoryIterator implements Iterator {
    private String[] members;
    private int posion = 0;

    public ComputerCategoryIterator(String[] members) {
        this.members = members;
    }

    @Override
    public boolean hasNext() {
        return !(posion >= members.length || members[posion] == null);
    }

    @Override
    public Object next() {
        String member = members[posion];
        posion++;
        return member;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("unsupported in computer!");
    }
}
