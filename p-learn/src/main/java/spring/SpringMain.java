package spring;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qinwanxin on 2017/8/1.
 */
public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-people.xml");
//        ctx.
        String s = (String)ctx.getBean("testString");
        System.out.println(s);
        People p = (People)ctx.getBean("people1");
        System.out.println(JSON.toJSONString(p));
    }
}
