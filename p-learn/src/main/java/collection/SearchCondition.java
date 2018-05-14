package collection;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class SearchCondition implements Serializable {
    /**
     * 搜索条件长度
     */
    private int length;

    private Long condition;

    private static String[] title = {"上下线状态","p.3.cn","p.3.local","vip1","vip2","group1","group2"};

    private SearchCondition(){
        this.length = title.length;
    }

    public static SearchCondition getSearchCOndition(String condition){
        SearchCondition instance = new SearchCondition();
        instance.condition = Long.valueOf(condition,2);
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(SearchCondition.getSearchCOndition("101010")));
        System.out.println(SearchCondition.getSearchCOndition("101010"));
    }

    @Override
    public String toString() {
        return "{length="+length+" , condition="+condition+"}";
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Long getCondition() {
        return condition;
    }

    public void setCondition(Long condition) {
        this.condition = condition;
    }

    public static String[] getTitle() {
        return title;
    }

    public static void setTitle(String[] title) {
        SearchCondition.title = title;
    }
}
