public class MyLikedList<E extends Comparable<E>> implements MyList{
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

    @Override
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
        newNode.previous = currentNode; // identifying the precious node
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
        while(currentNode != null){//traversing through the List
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
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
