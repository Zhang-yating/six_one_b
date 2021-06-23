public class ArrayDeque<Item> {
    private Item[] elements;
    private int size;
    private int front;


    public ArrayDeque() {
        elements = (Item[]) new Object[8];
        size = 0;
    }


    public int size() {
        return size;
    }


    private void upsize() {
        Item[] resize = (Item[]) new Object[elements.length*2];
        System.arraycopy(elements, front, resize,0,(elements.length - front));
        if(front != 0){
            System.arraycopy(elements,0,resize,(elements.length-front),front);
        }
        elements = resize;
        front = 0;
    }

    private void downsize() {
        Item[] resize = (Item[]) new Object[elements.length/2];
        int copy_len;
        if(elements.length-front > size){
            System.arraycopy(elements, front, resize,0, size);
        }
        else {
            System.arraycopy(elements, front, resize, 0, (elements.length - front));
            System.arraycopy(elements,0, resize, (elements.length - front), (size - elements.length + front));
        }
        elements = resize;
        front = 0;
    }

    /* add an item to the front */
    public void addFirst(Item item) {
        if (size == elements.length) {
            upsize();
        }
        if (size == 0) front = 0;
        else {
            front = front - 1;
            if (front < 0) {
                front = front + elements.length;
            }
        }
        elements[front] = item;
        size += 1;
    }

    public void addLast(Item item) {
        if (size == elements.length) {
            upsize();
        }
        elements[index_front(size)] = item;
        size += 1;
    }

    public Item get(int index) {
        if (index >= size) {
            System.out.println("out of index");
            return null;
        }
        return elements[index_front(index)];
    }

    /*get the index counted from elements[front],front may be <0*/
    private int index_front (int index){
        if(index + front >= elements.length){
            return index + front - elements.length;
        }
        return index + front;
    }

    public Item removeLast(){
        size -= 1;
        Item returned = elements[index_front(size)];
        elements[index_front(size)] = null;
        if (size*4 < elements.length & elements.length > 8){
            downsize();
        }
        return returned;
    }

    public Item removeFirst(){
        Item returned = elements[front];
        elements[front] = null;
        front = index_front(1);
        size -= 1;
        if (size*4 < elements.length & elements.length > 8){
            downsize();
        }
        return returned;
    }

    public void printDeque(){
        for(int i=0 ; i < size-1; i++){
            System.out.print(get(i));
            System.out.print(" ");
        }
        System.out.println(get(size-1));
    }

    public boolean isEmpty(){
        return size==0;
    }
}

