public class MyLinkedListQueue {
    MyLinkedList queue;

    public MyLinkedListQueue(){
        queue = new MyLinkedList();
    }
    public E enqueue(Object item){
        return (E) queue.addLast(item);
    }

    public void printQueue(){
        queue.printList();
    }
}
