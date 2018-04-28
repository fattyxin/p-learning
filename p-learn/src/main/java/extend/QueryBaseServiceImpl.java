package extend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinwanxin on 2018/1/11.
 */
public class QueryBaseServiceImpl implements QueryBaseService {
    @Override
    public List<Base> queryBase() {
        List<Base> result = new ArrayList<Base>();
        SubOne subOne = new SubOne();
        subOne.setSubName("subone");
        subOne.setName("basename1");

        SubTwo subTwo = new SubTwo();
        subTwo.setAge(50);
        subTwo.setName("basename2");

        result.add(subOne);
        result.add(subTwo);
        return result;
    }
}
