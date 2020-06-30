package carry.分布式专题.第二讲远程通讯协议原理.案例.序列化;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClientConsumer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(new User("carry"));
    }
}
