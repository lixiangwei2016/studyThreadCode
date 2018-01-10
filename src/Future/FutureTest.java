package Future;

import java.util.concurrent.*;

/**
 * Created by lixiangwei2 on 2018/1/4.
 */
public class FutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //FutureTask future = new FutureTask(new Mytask());
       // executorService.execute(future);
        Future future = executorService.submit(new Mytask());
        System.out.println(future.get());
        System.out.println("主线程执行完成");
    }

}

class Mytask implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("多线程");
        return "执行成功";
    }
}
