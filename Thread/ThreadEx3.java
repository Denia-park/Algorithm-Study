package Thread;

/*
java.lang.Exception
	at Thread.ThreadEx3_1.throwException(ThreadEx3.java:18)
	at Thread.ThreadEx3_1.run(ThreadEx3.java:13)
	at Thread.ThreadEx3.main(ThreadEx3.java:7)
 */

public class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx3_1 t1 = new ThreadEx3_1();

        t1.run();
    }
}

class ThreadEx3_1 extends Thread {
    public void run() {
        throwException();
    }

    private void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


