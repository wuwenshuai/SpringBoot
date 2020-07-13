package carry.分布式服务治理专题.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProduct {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send() {
        System.out.println("---------");
        kafkaTemplate.send("test","msgkey", "msgData");
    }
}
