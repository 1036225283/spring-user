package xws.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by xws on 2019/7/15.
 */
@Component
public class UserMessageHandler {


    @KafkaListener(topics = "userRegister")
    public void listen(ConsumerRecord<String, String> cr) throws Exception {
        System.out.println("this is kafka message");
        System.out.println(cr.toString());

    }
}
