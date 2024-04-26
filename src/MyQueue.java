import java.util.NoSuchElementException;

public class MyQueue<T> extends MyLinkedList<T>{
    private int size;
    public MyQueue(){
        super();
    }

    public void enqueue(T item){
        super.add(item);
        size++;
    }

    public void dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty!");
        }
        super.removeFirst();
        size--;
    }

    public void display(){
        super.printLl();
    }

    public T peek(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty!");
        }
        return super.getFirst();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
       if (size == 0)
           return true;
       else
           return false;
    }

}
