package JavaAlgorithmRef.Queues;

public class Queue {
    private static final int DEFAULT_CAPACITY = 10;
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;
    private int[] queueArray;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        this.maxSize = capacity;
        this.queueArray = new int[this.maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(4);
        myQueue.insert(10);
        myQueue.insert(2);
        myQueue.insert(5);
        myQueue.insert(3);
        // [10(front), 2, 5, 3(rear)]

        System.out.println(myQueue.isFull()); // Will print true

        myQueue.remove(); // Will make 2 the new front, making 10 no longer part of the queue
        // [10, 2(front), 5, 3(rear)]

        myQueue.insert(7); // Insert 7 at the rear which will get 0 index because of wrap around
        // [7(rear), 2(front), 5, 3]

        System.out.println(myQueue.peekFront()); // Will print 2
        System.out.println(myQueue.peekRear()); // Will print 7
        System.out.println(myQueue.toString()); // Will print [2, 5, 3, 7]
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        nItems++;
        rear = (rear + 1) % maxSize;
        queueArray[rear] = item;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            return -1;
        }

        nItems--;
        int temp = queueArray[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public boolean isFull() {
        return this.nItems == this.maxSize;
    }

    public boolean isEmpty() {
        return this.nItems == 0;
    }

    public int peekFront() {
        if (isEmpty()) {
            return -1;
        }
        return queueArray[front];
    }

    public int peekRear() {
        if (isEmpty()) {
            return -1;
        }
        return queueArray[rear];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int idx = front;
        while (true) {
            sb.append(queueArray[idx]).append(", ");
            if (idx == rear) {
                break;
            }
            idx = (idx + 1) % maxSize;
        }
        sb.replace(sb.length() - 2, sb.length(), "]");

        return sb.toString();
    }
}
