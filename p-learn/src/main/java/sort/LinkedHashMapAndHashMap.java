package sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by qinwanxin on 2018/7/19 10:59
 */
public class LinkedHashMapAndHashMap {
    /**
     * LinkedHashMap 是 hashMap 的子类
     * 保证了写入顺序 遍历
     * 重写了 addEntry createEntry
     * 在执行方法的时候 维护了一个链表 保证遍历顺序
     */
    public static void main(String[] args) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("hello", "hello");
        linkedHashMap.put("good", "good");
        linkedHashMap.put("apple", "apple");
        linkedHashMap.put("good", "banana");


        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("hello", "hello");
        hashMap.put("good", "good");
        hashMap.put("apple", "apple");
        hashMap.put("good", "banana");

        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("--------------");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        Node1 nodec = new Node1("C",null);
        Node1 nodeb = new Node1("B",nodec);
        Node1 nodea = new Node1("A",nodeb);
        Node1 [] node1s = {nodea,nodeb,nodec};
        System.out.println("--------------");
        for(Node1 node:node1s){
            System.out.println(node.getValue());
        }
        System.out.println("--------------");
        nodeb.setValue("D");
        for(Node1 node:node1s){
            System.out.println(node.getValue());
        }
        System.out.println("--------------");
        Node1 note =nodea;
        do {
            System.out.println(note.getValue());
            note = note.getNext();
        }while(note !=null);

    }

}

class Node1 {
    private String value;
    private Node1 next;
    public Node1(String value,Node1 next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public Node1 getNext() {
        return next;
    }

    public void setValue(String value) {
        this.value = value;
    }
}