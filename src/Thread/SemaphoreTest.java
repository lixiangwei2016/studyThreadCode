package Thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 * Created by lixiangwei2 on 2017/10/25.
 */
public class SemaphoreTest implements Runnable{

    private Semaphore  semaphore;
    private Random rnd = new Random();

    private String thredname;

    public SemaphoreTest(String thredname,Semaphore  semaphore) {
        this.thredname = thredname;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Thread "+thredname+" is working");
            Thread.sleep(rnd.nextInt(1000));
            semaphore.release();
            System.out.println("Thread " + thredname + " is over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Semaphore  semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new SemaphoreTest("A",semaphore));
        executorService.execute(new SemaphoreTest("B",semaphore));
        executorService.execute(new SemaphoreTest("C",semaphore));
        executorService.execute(new SemaphoreTest("D",semaphore));
        executorService.execute(new SemaphoreTest("E",semaphore));
        executorService.execute(new SemaphoreTest("F",semaphore));
    }
}
