public class LinkedListDeque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node prev,T item,Node next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;


    /*construct an empty list */
    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    /* deep copy a list */
    public LinkedListDeque(LinkedListDeque<T> other){
        sentinel = new Node(null,other.sentinel.item,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        Node p = other.sentinel.next;
        while(p != null){
            addLast(p.item);
            p = p.next;
        }
    }

    /* add an item to the front of the list */
    public void addFirst(T item) {
        size += 1;
        sentinel.next = new Node(sentinel,item,sentinel.next);
        if(sentinel.prev == sentinel){
            sentinel.prev = sentinel.next;
        }else{
            sentinel.next.next.prev = sentinel.next;
        }
    }

    /* add an item to the last of the list */
    public void addLast(T item){
        size += 1;
        sentinel.prev = new Node(sentinel.prev,item,sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        }

    /*see if the list is empty*/
    public boolean isEmpty(){
        return sentinel.next == sentinel;
    }

    /* return the size of a list */
    public int size(){
        return size;
    }

    /* print the content of the list */
    public void printDeque(){
        Node p = sentinel.next;
        if(p == sentinel){
            System.out.println("nothing in the list");
        }
        else {
            while (p != sentinel.prev) {
                System.out.print(p.item);
                System.out.print(" ");
                p = p.next;
            }
            System.out.println(p.item);
        }
    }

    /* remove and return the first element of the list */
    public T removeFirst(){
        size -= 1;
        if(sentinel.next == sentinel){
            return null;
        }
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        first.next = null;
        first.prev = null;
        return first.item;
    }

    /* remove and return last element of the list */
    public T removeLast(){
        size -= 1;
        if(sentinel.prev == sentinel){
            return null;
        }
        Node returnedLast = sentinel.prev;
        sentinel.prev = returnedLast.prev;
        returnedLast.prev.next = sentinel;
        returnedLast.prev = null;
        returnedLast.next = null;
        return returnedLast.item;
    }

    /* return the corresponding item according to the given index */
    public T get(int index){
        if(index < 0 | index > size-1){
            return null;
        }
        Node p = sentinel.next;
        while(index > 0){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    private T getRecursive(int index, Node L){
        if(index < 0 | index > size-1){
            return null;
        }
        if(index == 0){
            return L.item;
        }
        return getRecursive(index-1,L.next);
    }

    public T getRecursive(int index){
        return getRecursive(index, sentinel.next);
    }

}
