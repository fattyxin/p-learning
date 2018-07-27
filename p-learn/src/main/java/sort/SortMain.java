package sort;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * created by qinwanxin on 2018/6/17 15:52
 */
public class SortMain {
    public static void main(String[] args) {
        Set<TestSet> sets = new HashSet<>();
        sets.add(new TestSet("1"));
        System.out.println(sets);
        sets.add(new TestSet("2"));
        System.out.println(sets);
        sets.add(new TestSet("3"));
        System.out.println(sets);

        Set<String> tsets = new TreeSet<>();

        tsets.add("1");
        System.out.println(tsets);
        tsets.add(new String("1"));
        System.out.println(tsets);
        tsets.add(new String("2"));
        System.out.println(tsets);
        try {
            throw new RuntimeException("sss");
        }catch (Exception e){

        }

    }
}
