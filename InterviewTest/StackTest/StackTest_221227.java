package InterviewTest.StackTest;

public class StackTest_221227 {
    public static void main(String[] args) {
        StackTest st = new StackTest(10);

        st.push(5);
        st.push(1);
        st.push(2);
        st.push(4);
        st.push(3);

        st.show();

        st.pop();
        st.pop();
        st.pop();

        st.show();
    }
}

class StackTest {
    int[] arr;
    int cursor;

    public StackTest(int size) {
        this.arr = new int[size];
        this.cursor = -1;
    }

    public void push(int val) {
        cursor++;
        arr[cursor] = val;
    }

    public void pop() {
        arr[cursor] = 0;
        cursor--;
    }

    public boolean isEmpty() {
        return cursor == -1;
    }

    public int peek() {
        return arr[cursor];
    }

    public void show() {
        for (int i = 0; i <= cursor; i++) {
            System.out.println(arr[i]);
        }
    }
}
