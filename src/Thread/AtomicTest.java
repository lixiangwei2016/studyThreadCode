package Thread;

/**
 * Created by lixiangwei2 on 2017/12/29.
 */
public class AtomicTest {
    public static void main(String[] args) {
        int i =0 ;
        new Thread(new Mytask(i)).start();
        new Thread(new Mytask(i)).start();
    }
}

class Mytask implements Runnable{
    int i;

    public Mytask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        i++;
    }
}