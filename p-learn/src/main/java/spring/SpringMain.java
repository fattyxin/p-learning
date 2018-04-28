package spring;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Created by qinwanxin on 2017/8/1.
 */
public class SpringMain {
    public static void main(String[] args) {
        genHashCode("123456");
    }
    public static void xsdTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-people.xml");
//        ctx.
        String s = (String)ctx.getBean("testString");
        System.out.println(s);
        People p = (People)ctx.getBean("people1");
        System.out.println(JSON.toJSONString(p));
    }

    //                    tokenUser.get(TokenUserESMeta.YN) != null && "0".equals(String.valueOf(tokenUser.get(TokenUserESMeta.YN)))
    public static void stringTest(){
        Map<String,Object> map  = new HashMap<String,Object>(6, 1);
        map.put("yn", 0);
        System.out.println("map.get(\"yn\")!=null = " + map.get("yn") != null);
        System.out.println("\"0\".equals(String.valueOf(map.get(\"yn\"))) = " + "0".equals(String.valueOf(map.get("yn"))));
    }

    public static void treeSetTest(){
        Set<Long> longSet = new TreeSet<Long>();
        longSet.add(5L);
        longSet.add(1L);
        longSet.add(9L);
        Long[] resu = new Long[longSet.size()];
        Iterator<Long> it = longSet.iterator();
        while(it.hasNext()){
            System.out.println("it.next() = " + it.next());
        }
        longSet.toArray(resu);
        for(Long l : resu){
            System.out.println("l = " + l);
        }
    }
    public static void genHashCode(String s){
        //CARMANAGER927843673
        System.out.println(s.hashCode());
    }
}
