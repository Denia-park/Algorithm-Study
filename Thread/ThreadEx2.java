package Thread;

/*
java.lang.Exception
	at Thread.ThreadEx2_1.throwException(ThreadEx2.java:18)
	at Thread.ThreadEx2_1.run(ThreadEx2.java:13)
 */

public class ThreadEx2 {
    public static void main(String[] args) {
        ThreadEx2_1 t1 = new ThreadEx2_1();

        t1.start();
    }
}

class ThreadEx2_1 extends Thread {
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


