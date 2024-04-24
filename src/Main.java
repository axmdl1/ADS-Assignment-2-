public class Main {
    public static void main(String[] args){
        MyArrayList myArrayList = new MyArrayList();

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
        System.out.println("\nElement index: " + myArrayList.indexOf(10));
        System.out.println("Last elements' index: " + myArrayList.lastIndexOf(1));
        myArrayList.clear();
        System.out.println("Array after clear: ");
        myArrayList.printArr();
        myArrayList.add(10);
        System.out.println("Exists method: " + myArrayList.exists(10));
    }
}
