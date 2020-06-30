package carry.分布式专题.第二讲远程通讯协议原理.案例.序列化;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerProvider {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        try {
            User user = (User) inputStream.readObject();
            System.out.println(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
