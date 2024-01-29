package CodingTest.LeetCode;

import java.util.Stack;

public class Quiz {
    public static void main(final String[] args) {
//        final Solution solution = new Solution();

        final MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}

class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(final int x) {
        input.push(x);
    }

    public int pop() {
        moveAllItemFromInputToOutputIfOutputIsEmpty();

        return output.pop();
    }

    private void moveAllItemFromInputToOutputIfOutputIsEmpty() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public int peek() {
        moveAllItemFromInputToOutputIfOutputIsEmpty();

        return output.peek();
    }

    public boolean empty() {
        return (input.size() + output.size()) == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
