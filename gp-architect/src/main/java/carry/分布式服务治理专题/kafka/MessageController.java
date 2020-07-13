package carry.分布式服务治理专题.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private KafkaProduct kafkaProduct;

    @GetMapping("msg")
    public String send() {
        kafkaProduct.send();
        return "succcess";
    }
}
