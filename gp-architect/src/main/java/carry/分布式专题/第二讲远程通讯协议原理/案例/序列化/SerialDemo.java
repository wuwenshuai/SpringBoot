package carry.分布式专题.第二讲远程通讯协议原理.案例.序列化;

public class SerialDemo {
    public static void main(String[] args) {

        // java原生的序列化与反序列化实现
         javaSerial();

        // 利用Xstream来实现序列化与反序列化
       // xStreamSerial();

        //利用fastJson实现序列化
       // fastJsonSerial();
    }


    public static void javaSerial() {
        ISerializer javaSerializer = new JavaSerializer();
        User user = new User("carry");
        byte[] serialize = javaSerializer.serialize(user);
        System.out.println("javaSerial序列化的长度:" + serialize.length);
        // 反序列化
        User user1 = javaSerializer.deserialize(serialize, User.class);
        System.out.println(user1);
    }

    public static void xStreamSerial() {
        ISerializer javaSerializer = new XStreamSerializer();
        User javaUser = new User("carry");
        byte[] serialize = javaSerializer.serialize(javaUser);
        System.out.println("xStreamSerial序列化的长度:" + serialize.length);
        // 反序列化
        User user = javaSerializer.deserialize(serialize, User.class);
        System.out.println(user);
    }

    public static void fastJsonSerial() {
        ISerializer javaSerializer = new FastJsonSeriliazer();
        User javaUser = new User("carry");
        byte[] serialize = javaSerializer.serialize(javaUser);
        System.out.println("fastJsonSerial序列化的长度:" + serialize.length);
        // 反序列化
        User user = javaSerializer.deserialize(serialize, User.class);
        System.out.println(user);
    }
}
