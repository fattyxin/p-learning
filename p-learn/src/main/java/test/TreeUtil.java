package test;

import java.util.*;

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
        SimpleNode root = new SimpleNode("0", null, "root", 0,"","");
        root = TreeUtil.getTree(root,simpleNodes);
    }
}
