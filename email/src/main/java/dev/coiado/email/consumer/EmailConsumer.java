package dev.coiado.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @RabbitListener(queues = "email-queue")
    public void ListenEmailQueue (@Payload String string){
        System.out.println(string);
    }
}
