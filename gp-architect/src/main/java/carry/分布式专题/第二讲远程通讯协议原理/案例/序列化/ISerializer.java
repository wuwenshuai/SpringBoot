package carry.分布式专题.第二讲远程通讯协议原理.案例.序列化;

public interface ISerializer {

    // 序列化

    <T> byte[] serialize(T obj);

    // 反序列化
    <T> T deserialize(byte[] data, Class<T> clazz);
}
