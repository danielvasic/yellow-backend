package ba.nsoft.yellowbackend.stream.consumer;

import ba.nsoft.yellowbackend.model.Event;
import ba.nsoft.yellowbackend.model.Market;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Consumer {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.event.topic.group.id}")
    private String eventGroupId;

    @Value(value = "${spring.market.topic.group.id}")
    private String marketGroupId;

    public ConsumerFactory<String, Event> eventConsumerFactory (){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, eventGroupId);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(Event.class)
        );
    }

    public ConsumerFactory<String, Market> marketConsumerFactory (){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, marketGroupId);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(Market.class)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Event> eventListenerContainerFactory (){
        ConcurrentKafkaListenerContainerFactory<String, Event> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(eventConsumerFactory());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Market> marketListenerContainerFactory (){
        ConcurrentKafkaListenerContainerFactory<String, Market> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(marketConsumerFactory());
        return factory;
    }
}
