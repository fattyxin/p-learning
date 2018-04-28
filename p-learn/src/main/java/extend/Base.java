package extend;

import java.io.Serializable;

/**
 * Created by qinwanxin on 2018/1/11.
 */
public class Base implements Serializable {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
