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
        Node newNode = new Node(item);
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

    private void checkIndex(int index){
        if (index < 0 || size <= index)
            throw new IndexOutOfBoundsException("index not correct");
    }

    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

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

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {
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
