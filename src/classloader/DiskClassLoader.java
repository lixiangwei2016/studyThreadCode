package classloader;

import java.io.*;

/**
 * Created by lixiangwei2 on 2017/11/1.
 */
public class DiskClassLoader extends ClassLoader {

    private String path;

    public DiskClassLoader(String path) {
        this.path = path;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filename = getFileName(name);
        File file = new File(path,filename);

        try {
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int len;
            while ((len = in.read())!=-1){
                out.write(len);
            }

            byte[] data = out.toByteArray();
            in.close();
            out.close();

            return defineClass(name,data,0,data.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    //获取要加载 的class文件名
    private String getFileName(String name) {
        // TODO Auto-generated method stub
        int index = name.lastIndexOf('.');
        if(index == -1){
            return name+".class";
        }else{
            return name.substring(index+1)+".class";
        }
    }
}
