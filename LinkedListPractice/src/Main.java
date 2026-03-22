class DoublyLinkedList<E>{
    Node <E>head;
    Node <E>tail;
    public DoublyLinkedList(Node<E> head) {
        this.head = head;
        this.tail = head;
    }
    public DoublyLinkedList(){}

    public Node<E> add(Node<E> next){
        if(head == null){
            head = next;
            tail = next;
        }
        else{
            tail.setNext(next);
            next.setPrev(tail);
            tail=next;
        }
        return(next);
    }
    public Node<E> removeLast(){
        if (tail == null) throw new NullPointerException();
        if (tail == head){
            tail = null;
            head = null;
            return (tail);
        }                           //  a,b,c,d
        tail = tail.prev;           //      ^ ^
        tail.next = null;
        return(tail);
    }


    public String toString(){
        Node<E> current = head;
        String info =(String)current.getValue();

        while(current.next!= null){
            current = current.next;
            info = info +", "+ (String) current.getValue();

        }
        return(info);
    }
}

class Node<E> {
    E value;
    Node next;
    Node prev;

    public Node() {
        value = null;
    }

    public Node(E value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public E getValue() {
        return (value);
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        if (next == null) throw new NullPointerException();
        return (next);
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        if (prev == null) throw new NullPointerException();
        return (prev);
    }

}


public class Main {
    public static void main(String[] args) {
        Node<String> name0 = new Node<>("Bob");
        Node<String> name1 = new Node<>("Bill");
        Node<String> name2 = new Node<>("Carl");

        DoublyLinkedList<String> names = new DoublyLinkedList<>();
        names.add(name0);
        names.add(name1);
        names.add(name2);
        System.out.println(names.toString());
        names.removeLast();
        System.out.println(names.toString());
    }
}
