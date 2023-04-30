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
    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        T item = (T)queue.get(0);
        queue.remove(0);
        return item;
    }
    public void clearQueue(){
        queue.clear();
    }

    public T peek(){
        return (T) queue.get(0);
    }
}