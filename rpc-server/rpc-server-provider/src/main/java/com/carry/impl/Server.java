package com.carry.impl;

import com.carry.IHelloService;

public class Server {

    public static void main(String[] args) {
        IHelloService helloService=new HelloServiceImpl();
        RpcProxyServer proxyServer = new RpcProxyServer();
        proxyServer.publisher(helloService, 9999);
    }
}
