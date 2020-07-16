package carry.分布式服务治理专题.RabbitMQ.java;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MyConsumer {

    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private final static String QUEUE_NAME = "SIMPLE_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {


        ConnectionFactory factory = new ConnectionFactory();
        // 设置ip
        factory.setHost("10.206.0.14");
        // 设置端口
        factory.setPort(5672);
        // 虚拟机
        factory.setVirtualHost("/");

        //设置访问的用户
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();
        // 声明交换机
        // String exchange, String type, boolean durable, boolean autoDelete, Map<String, Object> arguments
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", false, false, null);

        //声明一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //绑定交换机和队列
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"carry.best");

        //创建一个消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("Received message : '" + msg + "'");
                System.out.println("consumerTag : " + consumerTag );
                System.out.println("deliveryTag : " + envelope.getDeliveryTag() );
            }
        };
        // 开始获取消息
        // String queue, boolean autoAck, Consumer callback
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}
