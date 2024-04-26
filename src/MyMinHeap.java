import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> extends MyArrayList<T>  {
    private int size;
    public MyMinHeap(){
        super();
    }

    public void add(T item){
        super.add(item);
        heapUp(size - 1);
        size++;
    }

    public void display(){
        super.printArr();
    }

    public T removeMin(){
        if (size == 0){
            throw new NoSuchElementException("Heap is empty!");
        }
        T min = super.get(0);
        super.set(0, super.get(super.size() - 1));
        super.removeLast();
        heapDown(0);
        return min;
    }

    public T peek(){
        if (size == 0)
            throw new NoSuchElementException("Heap is empty!");
        return super.get(0);
    }

    private void heapUp(int index){
        int parent = (index - 1) / 2;
        if (parent >= 0 && super.get(index).compareTo(super.get(parent)) < 0){
            swap(index, parent);
            heapUp(parent);
        }
    }

    private void heapDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallIndex = index;

        if (leftChild < size && super.get(leftChild).compareTo(super.get(smallIndex)) < 0){
            smallIndex = leftChild;
        }

        if (rightChild < size && super.get(rightChild).compareTo(super.get(smallIndex)) < 0){
            smallIndex = rightChild;
        }

        if (smallIndex != index){
            swap(index, smallIndex);
            heapDown(smallIndex);
        }
    }

    private void swap(int index1, int index2){
        T tmp = super.get(index1);
        super.set(index1, super.get(index2));
        super.set(index2, tmp);
    }

    public int size(){
        return size;
    }
}
