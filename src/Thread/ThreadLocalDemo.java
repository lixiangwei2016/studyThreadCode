package Thread;

/**
 * Created by lixiangwei2 on 2017/12/6.
 */
public class ThreadLocalDemo {
    private ThreadLocal<Integer>  num = new ThreadLocal<Integer>(){
        public Integer initialValue() {
            return 0;
        }
    };

    public  Integer getNum() {
        num.set(num.get()+1);
        return num.get();
    }


}


class TestThreadLocal1 implements Runnable{

    ThreadLocalDemo threadLocalDemo;

    public TestThreadLocal1(ThreadLocalDemo threadLocalDemo) {
        this.threadLocalDemo = threadLocalDemo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + threadLocalDemo.getNum());
        }
    }
}

class TestMain1{
    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        TestThreadLocal1 testThreadLocal = new TestThreadLocal1(threadLocalDemo);
        TestThreadLocal1 testThreadLocal1 = new TestThreadLocal1(threadLocalDemo);
        new Thread(testThreadLocal).start();
        new Thread(testThreadLocal1).start();
    }
}

