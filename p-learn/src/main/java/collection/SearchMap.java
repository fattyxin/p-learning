package collection;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by qinwanxin on 2018/4/28.
 */
public class SearchMap {
    private static ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<String,String>();
    public static void add(String key,String val){
        concurrentHashMap.put(key, val);
    }
    public static String update(String key,String val){
        return concurrentHashMap.put(key, val);
    }
    public static String del(String key){
        return concurrentHashMap.remove(key);
    }
    public static Set<String> search(String condition){
        Set<String> result = new HashSet<String>();
        if(condition == null || condition.length()!=555){
            return result;
        }
        for(Map.Entry<String,String> entry :concurrentHashMap.entrySet()){

        }
    }
}
