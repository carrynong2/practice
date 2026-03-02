package thread;

public class MultiThreadThing implements Runnable {
    private int threadNumber;
    public MultiThreadThing(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running: " + i);
            if (threadNumber == 3) {
                throw new RuntimeException();
            }
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
