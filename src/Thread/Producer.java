package Thread;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lixiangwei2 on 2017/10/26.
 */
public class Producer implements Runnable{
    private BlockingQueue phoneResLists;

    public Producer(BlockingQueue  phoneResLists) {
        this.phoneResLists = phoneResLists;
    }

    @Override
    public void run() {
        while (true) {
                PhoneRes phoneRes = new PhoneRes((int) Math.random() * 1000, "apple" + (int) Math.random() * 1000);
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"生产了"+phoneRes);
                    phoneResLists.put(phoneRes);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
