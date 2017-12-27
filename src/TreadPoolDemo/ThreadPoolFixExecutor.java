package TreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lixiangwei2 on 2017/12/27.
 */
public class ThreadPoolFixExecutor {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 1; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"{value:"+index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("sdfsfes");
    }
}
