package ba.nsoft.yellowbackend.stream;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@org.springframework.context.annotation.Configuration
public class Config {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value="${spring.event.topic.name}")
    private String EVENT_TOPIC;

    @Value(value="${spring.market.topic.name}")
    private String MARKET_TOPIC;

    @Bean
    public NewTopic eventTopic() {
        return TopicBuilder.name(this.EVENT_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic marketTopic() {
        return TopicBuilder.name(this.MARKET_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
