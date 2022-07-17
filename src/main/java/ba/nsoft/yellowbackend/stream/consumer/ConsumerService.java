package ba.nsoft.yellowbackend.stream.consumer;

import ba.nsoft.yellowbackend.model.Event;
import ba.nsoft.yellowbackend.model.Market;
import ba.nsoft.yellowbackend.utils.DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConsumerService {
    @Autowired
    SimpMessagingTemplate template;

    // Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();

    @KafkaListener(topics = "${spring.event.topic.name}", groupId = "${spring.event.topic.group.id}")
    public void consume (Event event){
        if (event.valid()){
            System.out.println("Sending event over WebSocket.");
            template.convertAndSend("/topic/event", event);
        }
    }

    @KafkaListener(topics = "${spring.market.topic.name}", groupId = "${spring.market.topic.group.id}")
    public void consume (Market market){
        if (market.valid()){
            System.out.println("Sending market over WebSocket.");
            template.convertAndSend("/topic/market", market);
        }
    }
}
