import java.util.EmptyStackException;

public class MyArrayListStack <T extends Comparable<T>>{
    MyArrayList stack;

    public MyArrayListStack(){
        stack = new MyArrayList<>();
    }

    public T push(Object item){
        stack.add(item);
        return (T)item;
    }

    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return (T) stack.remove(stack.size()-1);
    }

    public void printStack(){
        stack.printList();
        System.out.println();
    }

    public T peek(){
        return (T) stack.get(stack.size()-1);
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        if(stack.size() == 0 || stack.get(0) == null){
            return true;
        }else{
            return false;
        }
    }

}