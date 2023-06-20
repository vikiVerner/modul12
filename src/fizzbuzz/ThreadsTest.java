package fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class ThreadsTest {
    public static void main(String[] args) {
        ProcessThread fizzBuzz = new ProcessThread(
                (n)-> {
                    if(n%15==0){
                        System.out.println("FizzBuzz");
                    }
                });
        ProcessThread fizz = new ProcessThread((n)->{
            if(n%3 == 0){
                System.out.println("Fizz");
            }
        });
        ProcessThread buzz = new ProcessThread((n)->{
            if(n%5 == 0){
                System.out.println("Buzz");
            }
        });
        ProcessThread number = new ProcessThread((n)->{
            if(n%3 !=0 && n%5 != 0){
                System.out.println(n);
            }
        });

        List<ProcessThread> threads = new ArrayList<ProcessThread>();
        threads.add(fizzBuzz);
        threads.add(fizz);
        threads.add(buzz);
        threads.add(number);

        for (ProcessThread thread : threads) {
            thread.start();
        }

        for (int i = 1; i < 100; i++) {
            for (ProcessThread thread : threads) {
                thread.process(i);
            }
            while (true){
                int processedCount = 0;
                for (ProcessThread thread : threads) {
                    if(thread.isProcessed()){
                        processedCount++;
                    }
                }
                if(processedCount == threads.size()){
                    break;
                }
            }
        }


    }
}
