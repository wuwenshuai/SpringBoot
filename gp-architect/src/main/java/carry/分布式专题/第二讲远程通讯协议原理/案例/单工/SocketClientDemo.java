package carry.分布式专题.第二讲远程通讯协议原理.案例.单工;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientDemo {

    public static void main(String[] args) throws IOException {
        // 一些异常处理和流的关闭啥的都不处理了
        Socket socket = new Socket("127.0.0.1", 8080);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("hello carry");
    }
}
