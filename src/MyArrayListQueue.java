import java.util.NoSuchElementException;
public class MyArrayListQueue <T extends Comparable<T>> {
    MyArrayList queue;

    public MyArrayListQueue() {
        queue = new MyArrayList();
    }
    public T enqueue(Object item){
        queue.add(item);
        return (T) item;
    }
    public void printQueue(){
        queue.printList();
        System.out.println();
    }
}