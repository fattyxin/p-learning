package headfirst.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * created by qinwanxin on 2018/6/14 17:54
 */
public class CompositeMain {

    /**
     *
     * 组合模式
     * 组合模式允许你将对象组合成树形结构来表现“整体/部分”层次结构。
     * 组合能让客户以一致的方式处理个别对象以及对象组合。
     *
     *
     * 家电--
     *      |
     *      |--手机
     *      |   |---iphone
     *      |   |      |
     *      |   |      |----ip5
     *      |   |      |
     *      |   |      |----ip7
     *      |   |
     *      |   |
     *      |   |---huawei
     *      |
     *      |--电脑
     *          |
     *          |---mac
     *          |
     *          |---lenovo
     *
     * 支持增加、删除、遍历
     */

    public static void main(String[] args) {
        CategoryComponent componentRoot = new Category("家电");
        CategoryComponent mobile = new Category("手机");
        CategoryComponent huawei = new Category("huawei");
        CategoryComponent iphone = new Category("iphone");
        CategoryComponent iphone5 = new CategoryItem("iphone5");
        CategoryComponent iphone7 = new CategoryItem("iphone7");

        mobile.add(huawei);
        mobile.add(iphone);
        iphone.add(iphone5);
        iphone.add(iphone7);


        CategoryComponent computer = new Category("电脑");
        CategoryComponent mac = new Category("mac");
        CategoryComponent lenovo = new Category("lenovo");
        computer.add(mac);
        computer.add(lenovo);

        //有根(家电)时
        componentRoot.add(mobile);
        componentRoot.add(computer);
        componentRoot.print();

        System.out.println("----------------------------");

        //无根(家电)时
        List<CategoryComponent> categoryComponents = new ArrayList<>();
        categoryComponents.add(mobile);
        categoryComponents.add(computer);
        print(categoryComponents.iterator());


        /**
         *
         * 利用内迭代器 print() 方法迭代遍历 已经满足需求
         * 若想打印 所有进口的分类 isImported = true
         * 可以在  print(Iterator<CategoryComponent> iterator) 中进行判断
         * 也可以 实现一个 外迭代器 CategoryComponentIterator
         */


    }

    public static void print(Iterator<CategoryComponent> iterator){
        while(iterator.hasNext()){
            iterator.next().print();
        }
    }
}
