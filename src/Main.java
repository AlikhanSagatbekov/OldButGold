import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyLinkedListQueue q = new MyLinkedListQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(9);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.printQueue();

    }
}