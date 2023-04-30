import java.util.LinkedList;
import java.util.EmptyStackException;
public class MyLinkedListStack <E extends Comparable<E>>{

    private MyLinkedList stack;
    public MyLinkedListStack(){
        stack = new MyLinkedList();
    }

    public E push(Object item){
        stack.addFirst(item);
        return (E) item;
    }

    public E pop(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return (E) stack.removeFirst();

    }

    public E peek(){
        return (E) stack.getFirst();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }

    public void printStack(){
        stack.printList();
    }


}