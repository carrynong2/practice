package thread;

public class MultiThreading {
    static void main() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            MultiThreadThing myTing = new MultiThreadThing(i);
            Thread myThread = new Thread(myTing);
            myThread.start();
            myThread.join();
        }
        throw new RuntimeException();
    }
}
