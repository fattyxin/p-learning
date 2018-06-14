package headfirst.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * created by qinwanxin on 2018/6/14 14:40
 */
public class IteratorMain {

    /**
     *
     * 迭代器模式
     * 迭代器模式提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。
     *
     * 有2个分类菜单。
     * 手机-->iphone,huawei 内部用list存储
     * 电脑-->mac,lenovo 内部用数组存储
     * 现在想要打印两个分类中的 数据
     *
     */
    public static void main(String[] args) {
        /**
         *
         * 老的方式有多少个分类就要弄多少个循环 for(）{...}
         */
        String [] computers = {"mac","lenovo"};
        List<String> mobiles = new ArrayList<String>();
        mobiles.add("iphone");
        mobiles.add("huawei");
        ComputerCategoryOld computerCategoryOld  = new ComputerCategoryOld(computers);
        MobileCategoryOld mobileCategoryOld = new MobileCategoryOld(mobiles);

        for(String comcate : computerCategoryOld.getMembers()){
            System.out.println(comcate);
        }

        for(String mobcate : mobileCategoryOld.getMembers()){
            System.out.println(mobcate);
        }

        System.out.println("----------------------------");

        ComputerCategoryNew computerCategoryNew = new ComputerCategoryNew(computers);
        MobileCategoryNew mobileCategoryNew = new MobileCategoryNew(mobiles);
        List<CategoryNew> list = new ArrayList<>();
        list.add(computerCategoryNew);
        list.add(mobileCategoryNew);

        for(CategoryNew categoryNew : list){
            printCategory(categoryNew.createIterator());
        }
    }

    public static void printCategory(Iterator iterator){
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
