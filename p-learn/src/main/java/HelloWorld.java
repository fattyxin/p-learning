import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinwanxin on 17/7/12.
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello test");
        System.out.println("123456".hashCode());
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list.toString() = " + list.toString());
        System.out.println("list.toString().substring(1,list.toString().length()-1) = " + list.toString().substring(1, list.toString().length() - 1));
        System.out.println("1,2,3");
        String s = JSON.toJSONString(list);
        System.out.println(s.substring(1, s.length() - 1));

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        String s1 = JSON.toJSONString(list1);
        System.out.println(s1.substring(1, s1.length() - 1));
    }
}
