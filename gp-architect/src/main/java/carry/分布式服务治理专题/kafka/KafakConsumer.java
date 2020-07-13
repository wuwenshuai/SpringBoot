package carry.分布式服务治理专题.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafakConsumer {

    @KafkaListener(topics = {"test"})
    public void listener(ConsumerRecord record) {

        Optional<Object> value = Optional.ofNullable(record.value());
        if (value.isPresent()) {
            System.out.println(value.get());
        }
    }
}
