import java.util.NoSuchElementException;

public class MyStack<T> extends MyLinkedList<T> {
    private int size;
    public MyStack(){
        super();
    }

    public void push(T item){
        super.addFirst(item);
        size++;
    }

    public void pop(){
        if (isEmpty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        super.removeFirst();
        size--;
    }

    public T peek(){
        if (isEmpty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        return super.getFirst();
    }

    public int search(T item){
        if (indexOf(item) >= 0){
            return size - indexOf(item);
        }
        return -1;
    }

    public void display(){
        super.printLl();
    }

    public boolean isEmpty(){
        if (size == 0)
            return true;
        else
            return false;
    }

    public int size(){
        return size;
    }
}
