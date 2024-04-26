import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public MyLinkedList(){
        head = null;
        tail = null;
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null)
            head = newNode;
        else {
            Node<T> currNode = head;
            while (currNode.next != null){
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        Node<T> newNode = new Node<>(item);
        if (index == 0)
            addFirst(item);
        else if (index == size) {
            addLast(item);
        }
        else {
            Node<T> currNode = head;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            newNode.prev = currNode;
            currNode.next.prev = newNode;
            currNode.next = newNode;
        }
        size++;

    }

    private void checkIndex(int index){
        if (index < 0 || size <= index)
            throw new IndexOutOfBoundsException("index not correct");
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        Node<T> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        currNode.data = item;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; 
        }
        size++; 
    }

    public void printLl(){
        Node<T> currNode = head;
        while (currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> curr = head;
        if (index < size / 2){
            for (int i = 0; i < index && curr!=null; i++) {
                curr = curr.next;
            }
        }
        else {
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr.data;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index > 0 && index < size){
            Node<T> curr = head;
            Node<T> prev = null;
            while (curr.next != null){
                prev = curr;
                curr = curr.next; 
            }
            prev.next = curr.next;
        }else
            throw new IndexOutOfBoundsException("Index");
    }

    @Override
    public void removeFirst() {
        if (head != null){
            if (head.next != null){
                head = head.next;
                head.prev = null;
            }
            else{
                head = null;
                tail = null;
            }
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (tail != null){
            if (tail.prev != null){
                tail = tail.prev;
                tail.next = null;
            }
            else{
                    head = null;
                    tail = null;
            }
            size--;
        }
    }

    @Override
    public void sort() {
        Object[] arr = toArray();

    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (Node<T> currNode = head; currNode != null; currNode = currNode.next){
            if (currNode.data.equals(object)){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (Node<T> currNode = tail; currNode != null; currNode = currNode.prev){
            if (currNode.data.equals(object)){
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int index = 0;
        for (Node<T> currNode = head; currNode != null; currNode = currNode.next){
            arr[index++] = currNode.data;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
