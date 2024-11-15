public class Stack {
    private int[] array;
    private int size;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void push(int item) {
        if (size == capacity) {
            int[] newArray = new int[capacity * 2];
            System.arraycopy(array, 0, newArray, 0, capacity);
            array = newArray;
            capacity *= 2;
        }
        array[size++] = item;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}