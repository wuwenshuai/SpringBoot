package carry.分布式专题.第二讲远程通讯协议原理.案例.序列化;

import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable {
    private  transient  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

        s.writeObject(name);
    }

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        name=(String)s.readObject();
    }

}