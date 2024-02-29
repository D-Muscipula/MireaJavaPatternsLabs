package org.example.Labs.task4;

public class Test {
    public static void main(String[] args) {
        try (MyExecutorService myExecutorService = new MyExecutorService(3)) {
            myExecutorService.submit(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("We run it1");
            });
            myExecutorService.submit(() -> {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("We run it2");
            });
            myExecutorService.submit(() -> System.out.println("Start"));
        }
    }
}
