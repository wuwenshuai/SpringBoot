package carry.分布式专题.第二讲远程通讯协议原理.案例.序列化;

import com.alibaba.fastjson.JSON;

public class FastJsonSeriliazer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return JSON.parseObject(new String(data), clazz);
    }
}
