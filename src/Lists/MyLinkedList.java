package Lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

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
        return curr.data;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null)
            throw new NoSuchElementException("List empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0){
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        }
        Node<T> curr = head;
        Node<T> prev = head;
        for (int i = 0; i < index && curr.next != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        size--;
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
        for (int i = 0; i < size - 1; i++) {
            Node<T> currNode = head;
            for (int j = 0; j < size - i - 1; j++) {
                if (currNode.next != null && ((Comparable<T>) currNode.data).compareTo((T) currNode.next.data) > 0){
                    T tmp = currNode.data;
                    currNode.data = (T) currNode.next.data;
                    currNode.next.data = tmp;
                }
                currNode = currNode.next;
            }
        }
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
        return indexOf(object) != -1;
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
