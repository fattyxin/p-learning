package collection;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by qinwanxin on 2018/4/28.
 */
public class SearchMap<k> {
    private ConcurrentHashMap<k, Long> concurrentHashMap = new ConcurrentHashMap<k, Long>();

    public Long put(k key, Long val) {
        return concurrentHashMap.put(key, val);
    }

    public Long del(k key) {
        return concurrentHashMap.remove(key);
    }

    public Set<k> search(SearchCondition condition,Comparator<k> comparator) {
        Set<k> result = new TreeSet<k>(comparator);
//        Set<String> result = new HashSet<String>();

        if (condition == null || Long.toBinaryString(condition.getCondition()).length() != condition.getLength()) {
            return result;
        }
        for (Map.Entry<k, Long> entry : concurrentHashMap.entrySet()) {
            //todo threadPool
            System.out.println("entry.getValue() = " + entry.getValue());
            System.out.println("condition = " + condition);
            System.out.println((entry.getValue() & condition.getCondition()));
            if ((entry.getValue() & condition.getCondition()) == condition.getCondition()) {
                result.add(entry.getKey());
            }
        }
        return result;
    }


//    public void init() {
//        long val0 = 0b100010;
//        this.put("127.0.0.1", val0);
//        long val1 = 0b010010;
//        this.put("127.0.0.2", val1);
//        long val3 = 0b110010;
//        this.put("128.0.1.3", val3);
//        long val4 = 0b110010;
//        this.put("128.1.0.3", val4);
//        long val2 = 0b110010;
//        this.put("127.0.0.3", val2);
//
//    }

    public static void main(String[] args) {
        String v1 = "10101";
        String v2 = "11110";
        int i1 = Integer.valueOf(v1);
        int i2 = Integer.valueOf(v2);
        byte b1 = 0b10101;
        byte b2 = 0b11110;
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println(i1 & i2);
        System.out.println(Integer.toBinaryString(10101));
        System.out.println(Integer.toBinaryString(11110));
        System.out.println(Integer.toBinaryString(i1 & i2));
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        int br = b1 & b2;
        System.out.println("br = " + br);
        System.out.println(Integer.toBinaryString(br));
        byte b3 = Byte.valueOf(v1, 2);
        System.out.println("b3 = " + b3);
        System.out.println(Integer.toBinaryString(b3));


        SearchMap<String> searchMap = new SearchMap<String>();
        searchMap.put("127.0.0.1", (long)0b1000100);
        searchMap.put("127.0.0.2", (long)0b0100100);
        searchMap.put("128.0.1.3", (long)0b1100100);
        searchMap.put("128.1.0.3", (long)0b1100100);
        searchMap.put("127.0.0.3", (long)0b1100100);

        Set<String> ressult = searchMap.search(SearchCondition.getSearchCOndition("1000100"),null);
        for (String ip : ressult) {
            System.out.println(ip);
        }

    }
}
