package com.carry.impl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    // 提供一个发布服务的接口
    public void publisher(Object service, int port) {
        // 需要一个socketServer
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();// BIO阻塞
            // socket.getInputStream() 我们可以考虑用线程池来解决IO阻塞的问题
            executorService.execute(new ProcessorHandler(socket, service));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放流
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
