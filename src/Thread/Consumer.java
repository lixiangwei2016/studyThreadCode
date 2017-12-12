package Thread;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lixiangwei2 on 2017/10/26.
 */
public class Consumer implements Runnable{
    private BlockingQueue  phoneResLists;

    public Consumer(BlockingQueue phoneResLists) {
        this.phoneResLists = phoneResLists;
    }

    @Override
    public void run() {
         while (true){
             try {
                 PhoneRes phoneRes = (PhoneRes) phoneResLists.take();
                 Thread.sleep(1000);
                 System.out.println(Thread.currentThread().getName()+"消息了"+phoneRes);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}
