package com.carry.impl;

import com.carry.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;


public class ProcessorHandler implements Runnable {

    private Socket socket;
    private Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {

        // 我们可以在socket里面获取输出和输入流
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            // 输入流里面应该有哪些东西呢？ 参数，哪个类，方法名称，我们可以定义一个类。来保存这些东西
            try {
                RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
                // 拿到了客户端的请求的信息，我们下一步肯定是需要反射调用本地服务楼
                Object result = invoke(rpcRequest);
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(result);
                objectOutputStream.flush();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 反射调用本地方法
    private Object invoke(RpcRequest rpcRequest) {
        // 1拿到客户端的请求参数(数组)
        Object[] parameters = rpcRequest.getParameters();
        // 获得每个参数的类型（先不判空吧,异常分开写，看的清楚一些）
        Class<?>[] types = new Class[parameters.length];
        for (int i = 0; i < types.length; i++) {
            types[i] = parameters[i].getClass();
        }
        // 2根据类名去获取class
        Class<?> clazz = null;
        try {
            clazz = Class.forName(rpcRequest.getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 3获取method
        try {
            Method method = clazz.getMethod(rpcRequest.getMethodName(), types);
            // 4执行方法
            Object result = method.invoke(service, types);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
