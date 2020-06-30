package carry.分布式专题.第二讲远程通讯协议原理.案例.序列化;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamSerializer implements ISerializer {
    XStream xStream = new XStream(new DomDriver());
    @Override
    public <T> byte[] serialize(T obj) {
        xStream.allowTypesByWildcard(new String[] {
                "com.carry.**"  //你的包路径
        });
        byte[] bytes = xStream.toXML(obj).getBytes();
        return bytes;
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        xStream.allowTypesByWildcard(new String[] {
                "com.carry.**"  //你的包路径
        });
        return (T) xStream.fromXML(new String(data));
    }
}
