package Collecition;

/**
 * Created by lixiangwei2 on 2017/10/26.
 */
public class LinkedList {

    private Node<Object> first;
    private Node<Object> last;

    private int size = 0;

    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(Object o){
        Node<Object> l= last;
        Node<Object> newNode = new Node<>(l,o,null);
        last = newNode;
        if(l==null){
            first = newNode;
        }else{
            l.next = newNode;
        }
        size++;

    }

    public Object get(int index){
        Node<Object> obj = first;
        for (int i = 0; i < index; i++) {
            obj = obj.next;
        }
        return obj.item;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        System.out.println(linkedList.get(1));
    }
}
