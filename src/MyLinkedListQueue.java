public class MyLinkedListQueue <E extends Comparable<E>>{

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

    public E dequeue(){
        if(isEmpty()){
            throw new RuntimeException("No elements in stack");
        }
        return (E) queue.removeFirst();
    }

    public boolean isEmpty(){
        if(queue.size() == 0 || queue.get(0) == null){
            return true;
        }else{
            return false;
        }
    }

}