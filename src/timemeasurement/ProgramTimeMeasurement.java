package timemeasurement;

import java.util.concurrent.*;

public class ProgramTimeMeasurement  {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis()/1000;
        ScheduledExecutorService timeMeasurement = Executors.newSingleThreadScheduledExecutor();
        timeMeasurement.scheduleAtFixedRate(
                () -> System.out.println((System.currentTimeMillis()/1000)-startTime),
                0,
                1,
                TimeUnit.SECONDS
        );
        Thread.sleep(5000);
        timeMeasurement.scheduleAtFixedRate(
                ()-> System.out.println("Минуло 5 секунд."),
                0,
                5,
                TimeUnit.SECONDS
        );
    }
}
