package TreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lixiangwei2 on 2017/12/27.
 */
public class ThreadCachePool  {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

     static class  InnerThreadClass implements Runnable {

         @Override
         public void run() {
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println(Thread.currentThread().getName()+"正在运行");
         }
     }

    public static void main(String[] args) {
        executorService.execute(new InnerThreadClass());
        executorService.execute(new InnerThreadClass());
        executorService.execute(new InnerThreadClass());
        executorService.execute(new InnerThreadClass());
        executorService.execute(new InnerThreadClass());
        executorService.execute(new InnerThreadClass());
    }
}
