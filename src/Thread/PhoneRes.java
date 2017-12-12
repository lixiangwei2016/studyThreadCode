package Thread;

/**
 * Created by lixiangwei2 on 2017/10/26.
 */
public class PhoneRes {
    private int id;
    private String name;

    public PhoneRes(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PhoneRes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
