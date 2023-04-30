public class MyArrayList<T extends Comparable<T>> implements MyList {
    private int size = 0;
    private T[] arr;

    public MyArrayList() {
        this.arr = (T[]) new Comparable[10];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object item) {
        if (arr.length == size) {
            increaseBuffer();
        }
        arr[size++] = (T) item;
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public void add(Object item, int index) {
        if (arr.length == size - 1) {
            increaseBuffer();
        }
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = (T) item;
        size++;
    }

    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    private void validIndex(int index) {
        if (index >= size || index < 0) {
            System.out.println("Error, No such element in the array");
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object remove(int index) {
        validIndex(index);
        if (size == 1) {
            T temp = arr[0];
            size = 0;
            clear();
            return temp;
        }
        T temp = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return temp;
    }

    @Override
    public void clear() {
        T[] newArr = (T[]) new Object[0];
        arr = newArr;
        size = 0;
    }

    @Override
    public Object get(int index) {
        validIndex(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        validIndex(-1);
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int desiredIndex = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                desiredIndex = i;
            }
        }
        if (desiredIndex == -1) {
            System.out.println("Error, No such element in the array");
        }
        return desiredIndex;
    }

    @Override
    public void sort() {
        for(int i = 0; i < size - 1;i++){
            for (int j = 0; j < size - i - 1; j++){
                if (arr[j].compareTo(arr[j+1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public void printList(){
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] +  " ");
        }
    }

}
