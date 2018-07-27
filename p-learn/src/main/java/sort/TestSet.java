package sort;

/**
 * created by qinwanxin on 2018/7/3 14:54
 */
public class TestSet {
    private String anem;

    public TestSet(String anem) {
        this.anem = anem;
    }

    @Override
    public int hashCode() {
        return 9999999;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public String toString() {
        return "name="+anem;
    }
}
