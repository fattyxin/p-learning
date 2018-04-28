package extend;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by qinwanxin on 2018/1/11.
 */
public class TestMain {
    public static void main(String[] args) {
        QueryBaseService queryBaseService = new QueryBaseServiceImpl();
        List<Base> bases = queryBaseService.queryBase();
        for (Base base:bases){
            if(base instanceof SubOne){
                System.out.println("((SubOne) base).getSubName() = " + ((SubOne) base).getSubName());
                System.out.println("subone:"+JSON.toJSON(base));
            }
            if(base instanceof SubTwo){
                System.out.println("((SubOne) base).getSubName() = " + ((SubTwo) base).getAge());
                System.out.println("subtwo:"+JSON.toJSON(base));
            }
        }
    }
}
