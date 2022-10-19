package ru.t1.fitnessconsumer.service.implement;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.t1.fitnessconsumer.service.interfaces.MessageConsumerService;

@Service
public class MessageConsumerServiceImpl implements MessageConsumerService {

    @KafkaListener(topics = "${kafka.topicName}", groupId = "${kafka.groupId}")
    public void listenGroupBase(String message) {
        System.out.println("Received Message: " + message);
    }
}
