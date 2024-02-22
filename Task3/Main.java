package Task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // SafeList
        SafeList<Integer> list = new SafeList<>();
        ExecutorService list_executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            final int value = i;

            list_executor.execute(() -> {
                list.add(value);
                System.out.println("Added to list: " + value + ", Size: " + list.size());
            });
        }

        list_executor.shutdown();
        
        try {
            list_executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // SafeSet
        SafeSet<Integer> set = new SafeSet<>();
        ExecutorService set_executor = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 100; i++) {
            final int value = i;
            
            set_executor.execute(() -> {
                set.add(value);
                System.out.println("Added to set: " + value + ", Size: " + set.size());
            });
        }

        set_executor.shutdown();
        
        try {
            set_executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Total
        System.out.println("Total list size: " + list.size());
        System.out.println("Total set size: " + set.size());
    }
}
