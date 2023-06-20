package fizzbuzz;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread {
    private int num;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private NumberProcessor processor;

    public ProcessThread(NumberProcessor processor){
        this.processor = processor;
    }
    public void process(int num){
        this.num = num;
        processed.set(false);
    }

    public  boolean isProcessed(){
        return  processed.get();
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(processed.get()){
                continue;
            }
            processor.process(num);
            processed.set(true);
        }
    }
}
