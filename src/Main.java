import Lists.MyArrayList;
import Lists.MyLinkedList;
import Types.MyMinHeap;
import Types.MyQueue;
import Types.MyStack;

public class Main {
    public static void main(String[] args){
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        System.out.println("************************************************************ \n ArrayList: ");
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        System.out.println("Array before adding item: " + myArrayList.get(2));
        myArrayList.add(10);
        System.out.println("Array after added element: " + myArrayList.get(3));
        myArrayList.printArr();
        System.out.println("First element of array: " + myArrayList.getFirst());
        System.out.println("Last element of array: " + myArrayList.getLast());
        myArrayList.remove(2);
        System.out.print("After deleting 2 index: ");
        myArrayList.printArr();
        myArrayList.addFirst(23);
        System.out.print("\nArray after adding first element: ");
        myArrayList.printArr();
        System.out.println("\nSize: " + myArrayList.size());
        myArrayList.addLast(7);
        System.out.print("Array after adding last element: ");
        myArrayList.printArr();
        myArrayList.set(0, 12);
        System.out.print("\nArray after setting: ");
        myArrayList.printArr();
        myArrayList.removeFirst();
        System.out.print("\nArray after removed first element: ");
        myArrayList.printArr();
        myArrayList.removeLast();
        System.out.print("\nArray after removed last element: ");
        myArrayList.printArr();
        myArrayList.add(0);
        myArrayList.sort();
        System.out.print("\nArray after sorting: ");
        myArrayList.printArr();
        System.out.println("\nElement index: " + myArrayList.indexOf(10));
        System.out.println("Last elements' index: " + myArrayList.lastIndexOf(1));
        myArrayList.clear();
        System.out.println("Array after clear: ");
        myArrayList.printArr();

        myArrayList.add(10);
        System.out.println("Exists method: " + myArrayList.exists(10));
        System.out.println("*********************************************************** \n LinkedList:");

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(3);
        myLinkedList.add(1);
        myLinkedList.add(1);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(3, 10);
        System.out.println("Size: " + myLinkedList.size());
        System.out.println("Get element: " + myLinkedList.get(0));
        myLinkedList.removeFirst();
        System.out.print("List after deleting first element: ");
        myLinkedList.printLl();
        myLinkedList.sort();
        System.out.print("\nList after sorting: ");
        myLinkedList.printLl();
        myLinkedList.set(0, 0);
        System.out.print("\nList after setting: ");
        myLinkedList.printLl();
        myLinkedList.addFirst(2);
        System.out.print("\nList after adding 1st element: ");
        myLinkedList.printLl();
        System.out.println("\nGet 1st element from list: " + myLinkedList.getFirst());
        myLinkedList.remove(0);
        System.out.print("List after removing element: ");
        myLinkedList.printLl();
        System.out.println("\nIndex of 4: " + myLinkedList.indexOf(4));
        System.out.println("Exists: " + myLinkedList.exists(2));
        myLinkedList.clear();
        System.out.println("Clear: ");
        myLinkedList.printLl();
        System.out.println("*********************************************************** \n Queue:");

        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.enqueue(2);
        myQueue.enqueue(1);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(10);
        myQueue.dequeue();
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.peek());
        System.out.print("Queue: ");
        myQueue.display();
        System.out.println("\nSize: " + myQueue.size());
        System.out.println("********************************************************* \n Stack:");

        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.pop();
        System.out.println("1st element: " + myStack.peek());
        System.out.print("Display stack: ");
        myStack.display();
        System.out.println("\nSearch 3rd element: " + myStack.search(1));
        System.out.println("Size: " + myStack.size());
        System.out.println("********************************************************** \n MinHeap:");

        MyMinHeap<Integer> myMinHeap = new MyMinHeap<>();

        myMinHeap.add(10);
        myMinHeap.add(3);
        myMinHeap.add(8);
        myMinHeap.add(5);

        System.out.println("1st element: " + myMinHeap.peek());
        myMinHeap.removeMin();
        System.out.print("MinHeap: ");
        myMinHeap.display();
    }
}
