package headfirst.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * created by qinwanxin on 2018/6/14 15:26
 */
public class MobileCategoryNew implements CategoryNew {
    private List<String> members;

    public MobileCategoryNew(List<String> members) {
        this.members = members;
    }
    @Override
    public Iterator createIterator() {
        return members.iterator();
    }
}
