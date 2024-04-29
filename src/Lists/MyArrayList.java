package Lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private T[] arr = (T[]) new Object[5];
    private int size = 0;

    /**
     * Adds an element to the end of the list.
     * @param item the element to add.
     */
    @Override
    public void add(T item) {
        if (size >= arr.length)
            increaseBuffer();
        arr[size++] = item;
    }

    /**
     * Adds an element to the specified index.
     * @param index the index at which to add the element.
     * @param item the element to add.
     */
    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if (size >= arr.length)
            increaseBuffer();
        arr[index] = item;
    }

    /**
     * Sets the element at the specified index
     * @param index the index of the element to set
     * @param item the new value of the element
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }

    /**
     * Checks if the index is valid
     * @param index index to check
     */
    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index not correct!");
        }
    }

    /**
     * Increases the size of list when needed
     */
    private void increaseBuffer(){
        Object[] newArr = new Object[arr.length*2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = (T[]) newArr;
    }

    /**
     * Adds an element to the beginning of the list
     * @param item the element to add
     */
    @Override
    public void addFirst(T item) {
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = item;
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param item the element to add.
     */
    @Override
    public void addLast(T item) {
        arr[size] = item;
        size++;
    }

    /**
     * Retrieves the element at the specified index.
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
     * Retrieves the first element of the list
     * @return the first element of the list
     */
    @Override
    public T getFirst() {
        return arr[0];
    }

    /**
     *  Retrieves the last element of the list
     * @return the last element of the list
     */
    @Override
    public T getLast() {
        return arr[size - 1];
    }

    /**
     * Prints the elements of the list
     */
    public void printArr(){
        if (size == 0)
            System.out.println("Empty");

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Remove the element at the specified index
     * @param index index of the element to remove
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
    }

    /**
     * Removes the first element of the list
     */
    @Override
    public void removeFirst() {
        if (size == 0){
            throw new NoSuchElementException("Empty");
        }
        else {
            for (int i = 0; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        }
    }

    /**
     * Removes the last element of the list
     */
    @Override
    public void removeLast() {
        arr[size - 1] = null;
        size--;
    }

    /**
     * Performs a quick sort on the list
     * @param arr the array to sort
     * @param left the index of the leftmost element of the array
     * @param right the index of the rightmost element of the array
     */
    private void quickSort(T[] arr, int left, int right){
        if (left >= right)
            return;
        T pivot = arr[left + (right - left) / 2];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    /**
     * Partitions the array for quick sort.
     * @param arr the array to be partitioned
     * @param left the index of the leftmost element of the array
     * @param right the index of the rightmost element of the array
     * @param pivot the pivot element for partitioning
     * @return
     */
    private int partition(T[] arr, int left, int right, T pivot) {
        while (left <= right){
            while (((Comparable<T>)arr[left]).compareTo(pivot) < 0){
                left++;
            }

            while (((Comparable<T>)arr[right]).compareTo(pivot) > 0){
                right--;
            }

            if (left <= right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    /**
     * Swaps two elements in the array.
     *
     * @param arr   the array in which elements are to be swapped
     * @param left  the index of the first element to be swapped
     * @param right the index of the second element to be swapped
     */
    private void swap(T[] arr, int left, int right) {
        T tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    /**
     * Sorts the list
     */
    @Override
    public void sort() {
        quickSort(arr, 0, size - 1);
    }

    /**
     * Finds the index of the object in array
     * @param object the element to search for
     * @return the index of the element, or -1 if not found
     */
    @Override
    public int indexOf(Object object) {
        if (object == null){
            for (int i = 0; i < size; i++) {
                if (arr[i] == null)
                    return i;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (object.equals(arr[i])) {
                    System.out.println(i);
                    return i;
                }
            }
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
        if (object == null){
            for (int i = size - 1; i > 0; i--) {
                if (arr[i] == null)
                    return i;
            }
        }
        else {
            for (int i = size - 1; i > 0; i--) {
                if (object.equals(arr[i]))
                    return i;
            }
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
        for (int i = 0; i < size; i++) {
            if (arr[i] == null && object == null)
                return true;
            if (arr[i] != null && arr[i].equals(object))
                return true;
        }
        return false;
    }

    /**
     * Returns an array containing all elements in this list in proper sequence.
     * @return an array containing all elements in this list
     */
    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    /**
     * Removes all elements from the list
     */
    @Override
    public void clear() {
        arr = (T[]) new Object[5];
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
