package ru.t1.fitnessconsumer.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.t1.fitnessconsumer.service.interfaces.MessageConsumerService;
import ru.t1.fitnessconsumer.service.interfaces.MessageSenderService;

@Service
@RequiredArgsConstructor
public class MessageConsumerServiceImpl implements MessageConsumerService {

    private final MessageSenderService messageSenderService;

    @KafkaListener(topics = "${kafka.firstTopicName}", groupId = "${kafka.groupId}")
    public void listenGroupBase(String message) {
        System.out.println("Received Message: " + message);
        messageSenderService.sendMessage("Message - |" + message + "| received by consumer");
    }
}
