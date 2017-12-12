package Nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by lixiangwei2 on 2017/10/26.
 */
public class Program  {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\nodejs\\AOI\\branch\\public\\dist\\js\\modules\\dfyoo\\category\\newTour.bundle.js");
            FileOutputStream fos = new FileOutputStream("D:\\io.txt");
            // 设置一个，每次 装载信息的容器
            byte[] buf = new byte[1024];
            // 定义一个StringBuffer用来存放字符串
            StringBuffer sb = new StringBuffer();
            // 开始读取数据
            int len = 0;// 每次读取到的数据的长度
            while ((len = fis.read(buf)) != -1) {// len值为-1时，表示没有数据了
                // append方法往sb对象里面添加数据
                //sb.append(new String(buf, 0, len, "utf-8"));
                fos.write(buf);

            }

            // 输出字符串
            System.out.println("写完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
