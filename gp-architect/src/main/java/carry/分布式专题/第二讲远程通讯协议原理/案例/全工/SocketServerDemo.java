package carry.分布式专题.第二讲远程通讯协议原理.案例.全工;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        //创建一个serverSocket在端口8080监听客户请求
        //使用accept()阻塞等待客户请求
        // 有客户请求来了则产生一个socket对象，并接着执行
        Socket socket = serverSocket.accept();
        //连接建立成功之后，双方开始通过 read 和 write 函数来读写数据，就像往一个文件流里面写东西一 样。
        //由Socket对象得到`输入流，并构建bufferReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //由Socket对象得到`输出，并构建printWriter
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        //由系统标准设备构造BufferReader对象
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Client:" + bufferedReader.readLine());
        String line = sin.readLine();
        while (!"bye".equals(line)) {
            // 如果该字符串为bye，则停止循环
            printWriter.println(line);
            //刷新输出流，使Client马上收到该字符串
            printWriter.flush();
            System.out.println("server:" + line);
            System.out.println("client:" + bufferedReader.readLine());
            line = sin.readLine();
        }
    }
}
