package fr.gantoin.basickafkaimplem.service.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import fr.gantoin.basickafkaimplem.domain.Video;

/**
 * Configuration de l'expéditeur
 */
@Configuration
public class KafkaSenderConfig {

    @Value(value = "${kafka.bootstrapAddress:kafka:9092}")
    // Adresse du serveur Kafka (il est possible de le configurer via application.properties)
    private String bootstrapAddress;

    @Bean
    public ProducerFactory<String, Video> senderFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress); // Adresse du serveur
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Video> kafkaTemplate() {
        return new KafkaTemplate<>(senderFactory());
    }
}
