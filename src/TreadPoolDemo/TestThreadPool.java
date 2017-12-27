package TreadPoolDemo;

import java.util.concurrent.*;

/**
 * Created by lixiangwei2 on 2017/12/27.
 */
public class TestThreadPool {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}


class MyTask implements Runnable{

    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}