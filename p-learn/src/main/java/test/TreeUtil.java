package test;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xueyanlei on 2016/10/18.
 */
public class TreeUtil {

    public static <T extends InheritedNode> T getTree(T root, LinkedList<T> list) {
        // 模拟树的广度遍历结果的集合
        LinkedList<T> traversalList = new LinkedList<T>();
        traversalList.push(root);
        int count = 1;
        // 原始集合不为空，则继续迭代，将其中的元素加入到树的广度遍历结果集合中
        while(list.size() != 0) {
            // 迭代原始集合中的元素
            Iterator<T> iterAll = list.iterator();
            while(iterAll.hasNext()) {
                T ndInAll = iterAll.next();
                // 迭代树的广度遍历结果集合中的元素
                Iterator<T> iterTrav = traversalList.iterator();
                int indInTrav = 0;// 记录迭代当前元素的位置
                boolean mate = false;// 标识是否找到父子类匹配关系
                while(iterTrav.hasNext()) {
                    T ndInTrav = iterTrav.next();
                    // 如果存在父子类关系，则在在树的广度遍历结果集合中添加该元素，并父类中加入子元素
                    if(!mate) {
                        if(ndInAll.isChildFrom(ndInTrav)) {
                            // 如果存在父子类关系，则在父类中加入子元素，并设置标识
                            ndInTrav.addChildNode(ndInAll);
                            mate = true;
                        }
                    } else {
                        // 在找到iterInAll元素的父类之后，继续迭代，找到它的兄弟结点的位置
                        if(ndInAll.isBrother(ndInTrav)) {
                            break;
                        }
                    }
                    indInTrav++; // 执行++之后为迭代当前元素的位置
                }
                if(mate) {
                    // 如果找到iterInAll元素的父类，则在它的兄弟结点之前插入该元素
                    traversalList.add(indInTrav, ndInAll);
                    // 移除已经匹配的元素
                    iterAll.remove();
                }
            }
        }
        // 最后将所有元素已经放到了树的广度遍历结果集合中，并且元素之间建立好了子父关系，即只取根就可得到所有元素
        T root2 = traversalList.getFirst();
        return root2;
    }

    /**
     * 通过树的深度优先遍历获取树的遍历集合
     * @param root 树的根元素
     * @return 深度优先遍历方式的遍历集合
     */
    public static <T extends InheritedNode> List<T> createDepthFirstTraversalList(T root) {
        List<T> depthFirstTraversalList = new ArrayList<T>();
        // 深度优先遍历使用的栈结构
        Deque<T> stack = new ArrayDeque<T>();
        stack.addFirst(root);
        T node = null;
        while((node=stack.pollFirst()) != null) {
            List<T> sub = node.getChildNodes();
            if(sub != null && !sub.isEmpty()) {
                for(int i=0; i<sub.size(); i++) {
                    stack.addFirst(sub.get(i));
                }
            }
            depthFirstTraversalList.add(node);
        }
        return depthFirstTraversalList;
    }

    /**
     * 通过树的广度优先遍历获取树的遍历集合
     * @param root 树的根元素
     * @return 深度优先遍历方式的遍历集合
     */
    public static <T extends InheritedNode> List<T> createBreadthFirstTraversalList(T root) {
        List<T> depthFirstTraversalList = new ArrayList<T>();
        // 广度优先遍历使用的队列结构
        Deque<T> stack = new ArrayDeque<T>();
        stack.addLast(root);
        T node = null;
        while((node=stack.pollFirst()) != null) {
            List<T> sub = node.getChildNodes();
            if(sub != null && !sub.isEmpty()) {
                for(int i=0; i<sub.size(); i++) {
                    stack.addLast(sub.get(i));
                }
            }
            depthFirstTraversalList.add(node);
        }
        return depthFirstTraversalList;
    }


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100,100,0, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final CountDownLatch countDownLatch2 = new CountDownLatch(1);

        for(int i =0;i<1;i++){
            final int num = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        SimpleNode root = new SimpleNode("0", null, "root", 0,"","");
                        LinkedList<SimpleNode> simpleNodes = TreeUtil.transSimpleNodesTest();
                        countDownLatch.await();
                        root = TreeUtil.getTree(root,simpleNodes);
                        System.out.println(JSON.toJSONString(root));
                        System.out.println(JSON.toJSONString(simpleNodes));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch2.countDown();
                    }
                }
            });
        }

        countDownLatch.countDown();
        try {
            countDownLatch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static LinkedList<SimpleNode> transSimpleNodesTest(){
        LinkedList<SimpleNode> simpleNodes = new LinkedList<SimpleNode>();
        SimpleNode simpleNode = new SimpleNode("1","0","基础资料",0,"-","icon-sys");
        SimpleNode simpleNode1 = new SimpleNode("2","0","计费数据",0,"-","icon-sys");
        SimpleNode simpleNode2 = new SimpleNode("3","0","权限管理",0,"-","icon-sys");
        SimpleNode simpleNode3 = new SimpleNode("66","0","考察设置",0,"-","icon-sys");

        SimpleNode simpleNode4 = new SimpleNode("5","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode5 = new SimpleNode("6","3","角色管理",0,"role/gotoRolePage.do","icon-sys");
        SimpleNode simpleNode6 = new SimpleNode("7","4","考察设置",0,"investigation/gotoInvestigationPage.do","icon-sys");
        SimpleNode simpleNode7 = new SimpleNode("8","4","考察设置1",0,"-","icon-sys");
        SimpleNode simpleNode8 = new SimpleNode("9","8","考察设置2",0,"-","icon-sys");
        SimpleNode simpleNode9 = new SimpleNode("10","3","菜单管理",0,"menu/gotoMenuPage.do","icon-sys");
        SimpleNode simpleNode10 = new SimpleNode("11","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode11 = new SimpleNode("12","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode12 = new SimpleNode("13","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode13 = new SimpleNode("14","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode14 = new SimpleNode("15","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode15 = new SimpleNode("16","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode16 = new SimpleNode("17","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode17 = new SimpleNode("18","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode18 = new SimpleNode("19","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");

        SimpleNode simpleNode19 = new SimpleNode("20","0","基础资料",0,"-","icon-sys");
        SimpleNode simpleNode20 = new SimpleNode("21","0","计费数据",0,"-","icon-sys");
        SimpleNode simpleNode21 = new SimpleNode("22","0","权限管理",0,"-","icon-sys");
        SimpleNode simpleNode22 = new SimpleNode("23","0","考察设置",0,"-","icon-sys");
        SimpleNode simpleNode23 = new SimpleNode("24","0","基础资料",0,"-","icon-sys");
        SimpleNode simpleNode24 = new SimpleNode("25","0","计费数据",0,"-","icon-sys");
        SimpleNode simpleNode25 = new SimpleNode("26","0","权限管理",0,"-","icon-sys");
        SimpleNode simpleNode26 = new SimpleNode("27","0","考察设置",0,"-","icon-sys");
        simpleNodes.add(simpleNode);
        simpleNodes.add(simpleNode1);
        simpleNodes.add(simpleNode2);
        simpleNodes.add(simpleNode3);
        simpleNodes.add(simpleNode4);
        simpleNodes.add(simpleNode5);
        simpleNodes.add(simpleNode6);
        simpleNodes.add(simpleNode7);
        simpleNodes.add(simpleNode8);

        simpleNodes.add(simpleNode9);
        simpleNodes.add(simpleNode10);
        simpleNodes.add(simpleNode11);
        simpleNodes.add(simpleNode12);
        simpleNodes.add(simpleNode13);
        simpleNodes.add(simpleNode14);
        simpleNodes.add(simpleNode15);
        simpleNodes.add(simpleNode16);
        simpleNodes.add(simpleNode17);
        simpleNodes.add(simpleNode18);
        simpleNodes.add(simpleNode19);
        simpleNodes.add(simpleNode20);
        simpleNodes.add(simpleNode21);
        simpleNodes.add(simpleNode22);
        simpleNodes.add(simpleNode23);
        simpleNodes.add(simpleNode24);
        simpleNodes.add(simpleNode25);
        simpleNodes.add(simpleNode26);
        return simpleNodes;
    }
}
