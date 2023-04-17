package Queue;

import java.util.Stack;

public class MyTwoStackQueue {
    private Stack<Integer> enqueueStack = new Stack<>();
    private Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int value) {
        enqueueStack.push(value);
    }

    public int dequeue() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
            return dequeueStack.pop();
        }

        return dequeueStack.pop();
    }

    public int peek() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
            return dequeueStack.peek();
        }

        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }
}
