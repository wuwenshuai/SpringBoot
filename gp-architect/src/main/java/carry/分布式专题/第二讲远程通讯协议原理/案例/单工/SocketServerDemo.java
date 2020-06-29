package carry.分布式专题.第二讲远程通讯协议原理.案例.单工;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {

    public static void main(String[] args) throws IOException {

//         TCP 的服务端要先监听一个端口，一般是先调用
//         bind 函数，给这个 Socket 赋予一个 IP 地址和端口。
//         为什么需要端口呢?要知道，你写的是一个应用程序，当一个网络包来的时候，内核要通过 TCP 头里
//        面的这个端口，来找到你这个应用程序，把包给你。
//        为什么要 IP 地址呢?有时候，一台机器会有多个网
//        卡，也就会有多个 IP 地址，你可以选择监听所有的网卡，也可以选择监听一个网卡，这样，只有发给这个网卡的包，才会给你。
        ServerSocket serverSocket = new ServerSocket(8080);

        //阻塞等待客户端连接，服务端调用 accept 函数，拿出一个已经完成的连接进行处理。如果还没有完成，就要等着。
        Socket socket = serverSocket.accept();

        //连接建立成功之后，双方开始通过 read 和 write 函数来读写数据，就像往一个文件流里面写东西一 样。
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
    }
}
