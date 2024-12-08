package challenges;
/*

Taken from here :

https://levelup.gitconnected.com/java-interview-questions-that-i-struggled-to-answer-part-1-atomic-integer-vs-synchronized-9e82cf26c8a8

 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);
    public void increment() {
        count.incrementAndGet();  // Atomic operation
    }
    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        AtomicCounter counter = new AtomicCounter();
        // Submit 1000 increment tasks
        for (int i = 0; i < 20; i++) {
            executor.submit(counter::increment);
        }
        executor.shutdown();
        while (!executor.isTerminated()) { } // wait for all tasks to finish
        System.out.println("Final count (with AtomicInteger): " + counter.getCount());
    }
}
