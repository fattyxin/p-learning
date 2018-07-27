package sort;


import java.util.Iterator;

/**
 * created by qinwanxin on 2018/7/18 17:02
 */
public class ReverseLinkedList {
    /**
     * 翻转链表
     */
    public static void main(String[] args) {
        Node<String> nodeD = new Node<>("D",null);
        Node<String> nodeC = new Node<>("C",nodeD);
        Node<String> nodeB = new Node<>("B",nodeC);
        Node<String> nodeA = new Node<>("A",nodeB);
        Iterator<String> iterator = nodeA.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------");
        Node<String> nodeRev = reverseLinkedList(nodeA);

        Iterator<String> iteratorrev = nodeRev.getIterator();
        while (iteratorrev.hasNext()){
            System.out.println(iteratorrev.next());
        }
    }

    public static <T> Node<T> reverseLinkedList(Node<T> orglist){
        if(orglist == null){
            return null;
        }
        if(orglist.getNext() == null){
            return orglist;
        }
        Node<T> head = orglist;
        Node<T> next = head.getNext();
        head.setNext(null);
        Node<T> result = reverseLinkedList(next);
        next.setNext(head);
        return result;
    }
}

class Node<T>{
    private T value;
    private Node<T> next;
    public Node(T val, Node<T> next){
        this.value = val;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    private class NodeIterator implements Iterator<T>{
        private Node<T> node;
        public NodeIterator(Node<T> node){
            this.node = node;
        }
       @Override
       public boolean hasNext() {
           return node.getNext() != null;
       }

       @Override
       public T next() {
            T val = node.getValue();
           node = node.getNext();
           return val;
       }

       @Override
       public void remove() {

       }
   }

   public Iterator<T> getIterator(){
        return new NodeIterator(this);
   }
}

