package sort;

import java.util.*;

/**
 * created by qinwanxin on 2018/7/18 18:32
 */
public class CommonOp {
    /**
     * 对一个集合进行统一操作
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        List<Integer> result = aCommonOpForList(list, new IntegerAddOneCommonOperate());
        System.out.println(result);

        Collection<Integer> result2 = aCommonOpForColl(list, new IntegerAddOneCommonOperate());
        System.out.println(result2);

    }

    public static <T> Collection<T> aCommonOpForColl(Collection<T> collection, CommonOperate<T> operate) {
        Iterator<T> iterator = collection.iterator();
        while(iterator.hasNext()){
            T e = iterator.next();
            e= operate.doSomeThing(e);
        }
        return collection;
    }

    public static <T> List<T> aCommonOpForList(List<T> list, CommonOperate<T> operate) {
        List<T> result = new ArrayList<>(list.size());
        for (T element : list) {

            result.add(operate.doSomeThing(element));
        }
        return result;
    }
}

interface CommonOperate<T> {
    T doSomeThing(T org);
}

class IntegerAddOneCommonOperate implements CommonOperate<Integer> {
    @Override
    public Integer doSomeThing(Integer org) {
        return org + 1;
    }
}