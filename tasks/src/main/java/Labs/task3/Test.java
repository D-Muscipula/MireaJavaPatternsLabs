package Labs.task3;

import java.util.ArrayList;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedSet<Integer> set = new SynchronizedSet<>(new HashSet<>());
        LockList<Integer> list = new LockList<>(new ArrayList<>());
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                set.add(i);
                list.add(i);
            }
        });
        Thread thread1 = new Thread(() -> {
            for (var a: set) {
                System.out.print(a + " ");
            }
            System.out.println();
            for (int i = 0; i < 15; i++) {
                System.out.print(list.get(i) + " ");
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread1.start();
        thread.join();
        thread1.join();


    }
}
