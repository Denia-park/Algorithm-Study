package JavaAlgorithmRef.StackArray;

//Stack using a Regular Array

public class StackArray {

    private static final int DEFAULT_CAPACITY = 10;
    private int[] stackArray;
    private int top;
    private int maxSize;

    public StackArray(int size) {
        maxSize = size;
        top = -1;
        this.stackArray = new int[size];
    }

    public StackArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Driver Code
     */
    public static void main(String[] args) {
        System.out.println("Test Start");

        // Declare a stack of maximum size 4
        StackArray myStackArray = new StackArray(4);

        assert myStackArray.isEmpty();
        assert !myStackArray.isFull();

        // Populate the stack
        myStackArray.push(5);
        myStackArray.push(8);
        myStackArray.push(2);
        myStackArray.push(9);

        assert !myStackArray.isEmpty();
        assert myStackArray.isFull();
        assert myStackArray.peek() == 9;
        assert myStackArray.pop() == 9;
        assert myStackArray.peek() == 2;
        assert myStackArray.size() == 3;

        System.out.println("Test End");
    }

    public void push(int value) {
        if (isFull()) {
            return;
        }
        top++;
        stackArray[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == (maxSize - 1));
    }

    public int size() {
        return top + 1;
    }
}
