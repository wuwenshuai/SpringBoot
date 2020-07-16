package carry.分布式服务治理专题.RabbitMQ.java;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MyProducer {

    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";


    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        // 设置ip
        factory.setHost("10.206.0.14");
        // 设置端口
        factory.setPort(5672);
        // 用户密码
        factory.setUsername("guest");
        factory.setPassword("guest");

        // 建立连接
        Connection connection = factory.newConnection();
        // 创造消息通道
        Channel channel = connection.createChannel();
        // 发送消息
        // String exchange, String routingKey, BasicProperties props, byte[] body
        channel.basicPublish(EXCHANGE_NAME, "carry.best", null, "hello mq".getBytes());
        //关闭连接
        channel.close();
        connection.close();
    }
}
