import java.util.EmptyStackException;

public class MyLinkedList <E extends Comparable<E>> implements MyList{

    private int size = 0;

    private class Node<E>{

        private E data;
        Node<E> next;
        Node<E> previous;
        public Node(E data){
            this.data = data;
        }
        public Node(){

        }
    }
    private Node head;
    private Node tail;

    @Override
    public int size() {
        return size;
    }

    @Override // finding the certain element in the linked list
    public boolean contains(Object o) {
        Node currentNode = this.head;
        while(currentNode != null){ // the logic of traversing the linked list
            if(currentNode.data.equals((E)o)){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public void add(Object item) {
        Node newNode = new Node<>((E)item);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
            size++;
            return;
        }
        Node currentNode = this.head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        newNode.previous = currentNode;
        this.tail = newNode;
        size++; // increasing the size
    }

    @Override
    public void add(Object item, int index) {
        Node currentNode = this.head;
        Node newNode = new Node<>((E) item);
        int currentIndex = 0;
        if(index == 0){
            Node temp = this.head;
            this.head = newNode;
            this.head.next = temp;
            return;
        }else if(index >= size){
            add((E)item);
            return;
        }

        while(currentNode != null){
            if(currentIndex == index){
                currentNode.previous.next = newNode;
                newNode.next = currentNode;
                size++;
                return;
            }
            currentIndex++;
            currentNode = currentNode.next;
        }

        System.out.println("Error of adding the element");
    }

    @Override
    public boolean remove(Object item) {
        Node currentNode = this.head;
        Node previousNode = new Node();
        if(currentNode != null && currentNode.data.equals((E)item)){
            this.head = currentNode.next;
            size--;
            return true;
        }
        while(currentNode != null){
            if(currentNode.data.equals((E)item)){
                System.out.println("Starting...");
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;

        }
        if (currentNode == null){
            return false;
        }

        previousNode.next = currentNode.next;
        size--;
        return true;
    }

    @Override
    public Object remove(int index) {
        int currentIndex = 0;
        Node currentNode = this.head;
        Node previousNode = this.head;
        if(index == 0){
            this.head = currentNode.next;
            return currentNode;
        }
        while(currentNode != null){
            if(index == currentIndex){
                previousNode.next = currentNode.next;
                size--;
                return currentNode.data;
            }
            currentIndex++;
            previousNode = currentNode;
            currentNode = currentNode.next;

        }
        return null;
    }

    @Override
    public void clear() {
        this.head = new Node<>();
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        int currentIndex = 0;
        Node currentNode = this.head;
        while(currentNode != null){
            if(index == currentIndex){
                return currentNode.data;
            }
            currentIndex++;
            currentNode = currentNode.next;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node currentNode = this.head;
        while(currentNode != null) {
            if(currentNode.data.equals((E) o)){
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int desiredIndex = -1;
        Node currentNode = this.head;
        while(currentNode != null) {
            if(currentNode.data.equals((E) o)){
                desiredIndex = index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return desiredIndex;
    }

    @Override
    public void sort() {
        int n = 0; // double-checking the size of the array
        Node currentNode = this.head;
        while(currentNode != null){
            n++;
            currentNode = currentNode.next;
        }

        for(int i = 0; i < n; i++){
            currentNode = this.head;
            while(currentNode.next != null){
                E data1 = (E)currentNode.data;
                E data2 = (E)currentNode.next.data;

                if(data1.compareTo(data2) > 0){
                    currentNode.next.data = data1;
                    currentNode.data = data2;
                }
                currentNode = currentNode.next;
            }
        }
    }

    @Override
    public void addAll(MyList o) {
        for(int i = 0; i < o.size(); i++){
            add(o.get(i));
        }
    }

    public Node returnTail(){
        return tail;
    }

    public Node returnHead(){
        return head;
    }

    public void printList(){
        Node currentNode = this.head;
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    public void printInReverse(){
        Node currentNode = this.tail;
        while(currentNode != null){
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.previous;
        }
    }


    public void SelfAddAll(MyLinkedList list){
        this.tail.next = list.tail;
        this.tail = list.tail;
    }

    public E addFirst(Object item){
        if(size == 0 || this.head ==null){
            Node newNode = new Node<>();
            head = newNode;
            this.head.data = (E)item;
            size++;
            return (E)item;
        }else{
            Node temp = new Node<>(item);
            Node oldTemp = this.head;
            temp.next = oldTemp;
            this.head = temp;
            size++;
            return (E)item;
        }
    }

    public boolean isEmpty(){
        if(size == 0 || this.head == null){
            return true;
        }else{
            return false;
        }
    }

    public E removeFirst(){
        Node temp = new Node<>();
        E data = (E) this.head.data;
        temp = this.head.next;
        this.head = temp;
        return data;
    }

    public E getFirst(){
        if(this.head != null && size > 0){
            return (E) this.head.data;
        }else{
            throw new EmptyStackException();
        }

    }

    public E addLast(Object item){
        add(item);
        return (E) this.tail.data;
    }

}