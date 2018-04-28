package xml;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qinwanxin on 2018/2/27.
 */
public enum PeopleBeanElementEnum {
    NAME("name"),
    AGE("age"),
    HIDDEN("hidden");

    private String name;
    PeopleBeanElementEnum(String name){
        this.name = name;
    }
    private static Set<String> names ;

    public String getName() {
        return name;
    }
    static {
        names = new HashSet<String>();
        for(PeopleBeanElementEnum e : PeopleBeanElementEnum.values()){
            names.add(e.getName());
        }
    }

    public static Set<String> getNames() {
        return names;
    }
}
