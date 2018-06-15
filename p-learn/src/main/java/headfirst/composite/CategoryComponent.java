package headfirst.composite;

/**
 * created by qinwanxin on 2018/6/15 10:53
 */
public abstract class CategoryComponent {
    public void add(CategoryComponent categoryComponent){
        throw new UnsupportedOperationException();
    }
    public void remove(CategoryComponent categoryComponent){
        throw new UnsupportedOperationException();
    }
    public boolean isImported(){
        throw new UnsupportedOperationException();
    }
    public void print(){
        throw new UnsupportedOperationException();
    }
    public abstract String getName();
}
