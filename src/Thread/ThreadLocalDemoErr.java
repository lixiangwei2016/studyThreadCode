package Thread;

/**
 * Created by lixiangwei2 on 2017/12/6.
 */
public class ThreadLocalDemoErr {
    private Integer num = new Integer(0);

    public  Integer getNum() {
        return num++;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

class TestThreadLocal implements Runnable{

    ThreadLocalDemoErr threadLocalDemo;

    public TestThreadLocal(ThreadLocalDemoErr threadLocalDemo) {
        this.threadLocalDemo = threadLocalDemo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + threadLocalDemo.getNum());
        }
    }
}

class TestMain{
    public static void main(String[] args) {
        ThreadLocalDemoErr threadLocalDemo = new ThreadLocalDemoErr();
        TestThreadLocal testThreadLocal = new TestThreadLocal(threadLocalDemo);
        TestThreadLocal testThreadLocal1 = new TestThreadLocal(threadLocalDemo);
        new Thread(testThreadLocal).start();
        new Thread(testThreadLocal1).start();
    }
}
