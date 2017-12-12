package Thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by lixiangwei2 on 2017/10/26.
 */
public class TestProducerAndConsumer {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        Producer producer = new Producer(blockingQueue);
        new Thread(producer).start();

        Consumer consumer = new Consumer(blockingQueue);
        new Thread(consumer).start();
    }
}
