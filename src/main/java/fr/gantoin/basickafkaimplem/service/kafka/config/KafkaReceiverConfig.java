package fr.gantoin.basickafkaimplem.service.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import fr.gantoin.basickafkaimplem.domain.Video;


/**
 * Configuration du destinataire
 */
@EnableKafka
@Configuration
public class KafkaReceiverConfig {

    @Value(value = "${kafka.bootstrapAddress:kafka:9092}") // Adresse du serveur Kafka pour envoyer les messages (il est possible de le configurer via application.properties)
    private String bootstrapAddress;

    private static final String groupId = "Tutorial"; // Définition du groupe ex: Tutorial

    @Bean
    public ConsumerFactory<String, Video> receiverFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress); // Configuration de l'adresse du serveur
        props.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);// Configuration du groupe
        return new DefaultKafkaConsumerFactory<>(props,new StringDeserializer(),new JsonDeserializer<>(Video.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Video> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Video> factory =new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(receiverFactory());
        return factory;
    }
}
