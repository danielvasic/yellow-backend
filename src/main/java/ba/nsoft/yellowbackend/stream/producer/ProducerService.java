package ba.nsoft.yellowbackend.stream.producer;

import ba.nsoft.yellowbackend.model.Event;
import ba.nsoft.yellowbackend.model.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerService {
    @Value(value="${spring.event.topic.name}")
    private String EVENT_TOPIC;

    @Value(value="${spring.market.topic.name}")
    private String MARKET_TOPIC;

    @Autowired
    private KafkaTemplate<String, Event> eventKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Market> marketKafkaTemplate;

    public void sendEvent (Event event) {
        /** TODO
         * Filter data that is not acceptable for Event.
         * Add logging.
         */
        ListenableFuture<SendResult<String, Event>> future = this.eventKafkaTemplate.send(EVENT_TOPIC, event);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Event>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Error sending message: " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Event> result) {
                System.out.println("Message sent.");
            }
        });
    }

    public void sendMarket (Market market) {
        /** TODO
         * Filter data that is not acceptable for Market
         */
        ListenableFuture<SendResult<String, Market>> future = this.marketKafkaTemplate.send(MARKET_TOPIC, market);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Market>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Error sending message.");
            }

            @Override
            public void onSuccess(SendResult<String, Market> result) {
                System.out.println("Message sent.");
            }
        });
    }
}
