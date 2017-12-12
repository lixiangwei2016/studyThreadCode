package Thread;

/**
 * Created by lixiangwei2 on 2017/10/25.
 */
public class AwaitTreadTest {
    private static int tickNum = 10;


    private static class AwaitRunnable implements Runnable{


        @Override
        public  void run() {

                while (true) {
                    try {
                        if(tickNum > 0) {
                            System.out.println("开始卖票。。。 " + tickNum);
                            Thread.sleep(100);
                            tickNum--;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        }
    }

    public static void main(String[] args) {
        AwaitRunnable awaitRunnable = new AwaitRunnable();
        new Thread(awaitRunnable,"a").start();
        new Thread(awaitRunnable,"b").start();
        new Thread(awaitRunnable,"c").start();
    }
}
