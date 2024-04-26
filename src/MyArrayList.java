import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{
    private T[] arr = (T[]) new Object[5];
    private int size = 0;

    @Override
    public void add(T item) {
        if (size >= arr.length)
            increaseBuffer();
        arr[size++] = item;
    }
    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if (size >= arr.length)
            increaseBuffer();
        arr[index] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index not correct!");
        }
    }

    private void increaseBuffer(){
        Object[] newArr = new Object[arr.length*2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = (T[]) newArr;
    }

    @Override
    public void addFirst(T item) {
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        arr[size] = item;
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public T getFirst() {
        return arr[0];
    }

    @Override
    public T getLast() {
        return arr[size - 1];
    }

    public void printArr(){
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
    }

    @Override
    public void removeLast() {
        arr[size - 1] = null;
        size--;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) arr[j]).compareTo(arr[j+1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

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
                if (object.equals(arr[i]))
                    return i;
            }
        }
        return -1;
    }

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

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[5];
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
