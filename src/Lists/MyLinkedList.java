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

    /**
     * Adds the specified item to the end of this list.
     * @param item the element to be added to the list
     */
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

    /**
     * Adds an element to the specified index.
     * @param index the index at which to add the element.
     * @param item the element to add.
     */
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

    /**
     * Checks if the index is valid
     * @param index index to check
     */
    private void checkIndex(int index){
        if (index < 0 || size <= index)
            throw new IndexOutOfBoundsException("index not correct");
    }

    /**
     * Sets the element at the specified index
     * @param index the index of the element to set
     * @param item the new value of the element
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        Node<T> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        currNode.data = item;
    }

    /**
     * Adds an element to the beginning of the list
     * @param item the element to add
     */
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

    /**
     * Adds an element to the end of the list.
     * @param item the element to add.
     */
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

    /**
     * Prints the elements of the list
     */
    public void printLl(){
        Node<T> currNode = head;
        while (currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    /**
     * Retrieves the element at the specified index.
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
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

    /**
     * Retrieves the first element of the list
     * @return the first element of the list
     */
    @Override
    public T getFirst() {
        return head.data;
    }

    /**
     *  Retrieves the last element of the list
     * @return the last element of the list
     */
    @Override
    public T getLast() {
        if (tail == null)
            throw new NoSuchElementException("List empty");
        return tail.data;
    }

    /**
     * Remove the element at the specified index
     * @param index index of the element to remove
     */
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

    /**
     * Removes the first element of the list
     */
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

    /**
     * Removes the last element of the list
     */
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

    /**
     * Sorts the list
     */
    @Override
    public void sort() {
        if (size > 0)
            bubbleSort();
        else
            System.out.println("List is empty!");
    }

    /**
     * Sorts the list using bubble sort method in ascending order.
     */
    private void bubbleSort(){
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

    /**
     * Finds the index of the object in array
     * @param object the element to search for
     * @return the index of the element, or -1 if not found
     */
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

    /**
     * Returns the index of the last occurrence of the specified element in the list,
     * or -1 if this list does not contain the element.
     * @param object the element to search for
     * @return the index of the last occurrence of the element, or -1 if not found
     */
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

    /**
     * Checks if the specified element exists in the list.
     * @param object the element to search for
     * @return true if exists, false if not exists
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Returns an array containing all elements in this list in proper sequence.
     * @return an array containing all elements in this list
     */
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int index = 0;
        for (Node<T> currNode = head; currNode != null; currNode = currNode.next){
            arr[index++] = currNode.data;
        }
        return arr;
    }

    /**
     * Removes all elements from the list
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * This method showing arrays' size.
     * @return size of array
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
