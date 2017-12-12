package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by lixiangwei2 on 2017/10/26.
 */
public class CusAndPro {

    private int queueSize = 10 ;

    private BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();


    class Consumer implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized (blockingQueue) {
                    if (blockingQueue.size() == 0) {
                        System.out.println("队列空，等待数据。。。");
                        try {
                            blockingQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    blockingQueue.poll();
                    blockingQueue.notify();
                    System.out.println("从队列中取走一个元素，队列中剩余"+blockingQueue.size()+"个");
                }

            }
        }
    }


    class Product implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized (blockingQueue) {
                    if (blockingQueue.size() == queueSize) {
                        System.out.println("队列已满，等待空余的空间");
                        try {
                            blockingQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    blockingQueue.offer(1);
                    blockingQueue.notify();
                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-blockingQueue.size()));
                }

            }
        }
    }

    public static void main(String[] args) {
        CusAndPro cap = new CusAndPro();
        Consumer cus = cap.new Consumer();
        Product pro = cap.new Product();
        Thread cusT = new Thread(cus);
        Thread proT = new Thread(pro);

        proT.start();
        cusT.start();
    }
}
