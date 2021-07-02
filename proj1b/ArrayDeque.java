public class ArrayDeque<T> implements Deque<T> {
    private T[] elements;
    private int size;
    private int front;

    public ArrayDeque() {
        elements = (T[]) new Object[8];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }


    private void upsize() {
        T[] resize = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, front, resize, 0, (elements.length - front));
        if (front != 0) {
            System.arraycopy(elements, 0, resize, (elements.length - front), front);
        }
        elements = resize;
        front = 0;
    }

    private void downsize() {
        T[] resize = (T[]) new Object[elements.length / 2];
        if (elements.length - front > size) {
            System.arraycopy(elements, front, resize, 0, size);
        } else {
            System.arraycopy(elements, front, resize, 0, (elements.length - front));
            System.arraycopy(elements, 0, resize, (elements.length - front),
                    (size - elements.length + front));
        }
        elements = resize;
        front = 0;
    }

    /* add an item to the front */
    @Override
    public void addFirst(T item) {
        if (size == elements.length) {
            upsize();
        }
        if (size == 0) {
            front = 0;
        } else {
            front = front - 1;
            if (front < 0) {
                front = front + elements.length;
            }
        }
        elements[front] = item;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == elements.length) {
            upsize();
        }
        elements[indexFront(size)] = item;
        size += 1;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            System.out.println("out of index");
            return null;
        }
        return elements[indexFront(index)];
    }

    /*get the index counted from elements[front],front may be <0*/
    private int indexFront(int index) {
        if (index + front >= elements.length) {
            return index + front - elements.length;
        }
        return index + front;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        T returned = elements[indexFront(size)];
        elements[indexFront(size)] = null;
        if (size * 4 < elements.length & elements.length > 8) {
            downsize();
        }
        return returned;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T returned = elements[front];
        elements[front] = null;
        front = indexFront(1);
        size -= 1;
        if (size * 4 < elements.length & elements.length > 8) {
            downsize();
        }
        return returned;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(get(i));
            System.out.print(" ");
        }
        System.out.println(get(size - 1));
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

